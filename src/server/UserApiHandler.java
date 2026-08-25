package server;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// /api/users -
// GET : 목록을 조회 한다.
// POST : 새 사용자를 등록한다.
public class UserApiHandler implements HttpHandler {

    // 실제로는 DB에 저장한다. 지금은 메모리 리스트로 대신 한다. 즉, 서버를 껐다 켜면 내용이 다 사라진다.
    private static final List<User> userList = new ArrayList();
    // 다음에 부여할 id
    private static int nextId = 1;

    // static 초기화 블록
    // 클래스가 메모리에 처음 올라갈 때 딱 한 번만 실행되는 코드 묶음
    // 이름도 없고, 우리가 직접 호출하지도 않는다. JVM 알아서 실행한다.
    static {
        addUser(new User("홍길동", "a@naver.com"));
        addUser(new User("김철수", "c@naver.com"));
    }

    private static synchronized int addUser(User user) {
        user.setId(nextId); // 최소 1 <- 쏙 들어감
        nextId++;
        userList.add(user);
        return user.getId();
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try {
            String method = exchange.getRequestMethod();
            String url = exchange.getRequestURI().getPath();
            String query = exchange.getRequestURI().getQuery();

            if (method.equals("GET")) {
                if(url.equals("/api/users") && query.isEmpty()) handleGet(exchange);
                else if (query != null) getById(exchange);
                else SimpleHttpServer.sendResponse(exchange , 404 , SimpleHttpServer.TYPE_TEXT ,
                            "잘못된 요청입니다.");

            } else if(method.equals("POST")) {
                handlePost(exchange);
            } else {
                // 405 를 보낼 때는 어떤 메서드가 되는지 Allow 헤더로 알려주는 것이 규칙이다.
                exchange.getResponseHeaders().set("Allow", "GET, POST");
                SimpleHttpServer.sendResponse(exchange, 405,
                        SimpleHttpServer.TYPE_TEXT, "지원하지 않는 메서드 입니다");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            exchange.close();
        }
    }

    /**
     * 목록을 복사해서 다시 둘려 준다.
     * 왜 복사하는가?
     * 원본을 그대로 넘기면, Gson이 JSON 으로 바꾸면서 순회 도중에
     * 다른 스레드가 POST 로 add 요청을 만약 한다면 중간에 예외가 발생한다.
     * 즉, 순회 도중에 ArrayList 크기가 바뀌면 예외를 던지는 증상이 있다.
     *
     */
    private ArrayList<User> copyUserList() {
        return new ArrayList<>(userList);
    }

    /**
     *  GET : 사용자 목록을 조회, (요청 HTTP 메세지 body 없음)
     *  List<User>를 그대로 넘기면 Gson 이 JSON 배열로 바꿔 준다.
     */
    private void handleGet(HttpExchange exchange) throws IOException {
        // sendJson 임 !
        SimpleHttpServer.sendJson(exchange, 200, copyUserList());
    }


    /**
     *  POST 요청 : 요청 본문이(HTTP 요청 메세지 바디) 있다
     */
    private void handlePost(HttpExchange exchange) throws IOException {
        // 1. HTTP 요청 바디를 읽어야 한다.
        String requestBody = SimpleHttpServer.readRequestBody(exchange);
        System.out.println("POST 요청 [api/users] 받은 본문 확인 : " + requestBody);

        // 2. JSON 문자열을 User 객체로 변환한다.
        // 주의
        User user;
        try {
            user = new Gson().fromJson(requestBody, User.class);
        } catch (JsonSyntaxException e) {
            SimpleHttpServer.sendResponse(exchange, 400,
                    SimpleHttpServer.TYPE_TEXT, "JSON 형식이 올바르지 않습니다");
            return;
        }

        // 3. 검증
        if (user == null || user.getName() == null || user.getName().isBlank()) {
            SimpleHttpServer.sendResponse(exchange, 400,
                    SimpleHttpServer.TYPE_TEXT , "name 은 반드시 있어야 합니다");
            return;
        }

        if (user.getEmail() == null) {
            user.setEmail("");
        }

        // 4. 저장 처리 id 값은 고정값이 아니라서 저장 결과를 다시 돌려 준다.
        int newId = addUser(user);

        // 5. 등록 성공은 200 대신 201 Created 로 응답을 한다.
        SimpleHttpServer.sendJson(exchange, 201, user);
    }

    private void getById(HttpExchange exchange) throws IOException {
          String query = exchange.getRequestURI().getQuery();

        if(query.substring(3).isEmpty()) {
            SimpleHttpServer.sendResponse(exchange , 404 , SimpleHttpServer.TYPE_TEXT ,
                    "ID를 입력하세요");
            return;
        }
          int id = Integer.parseInt(query.substring(3));

              for(User user : userList) {
                  if(id == user.getId()) {
                      SimpleHttpServer.sendJson(exchange , 200 , user);
                      return;
                  }
              }
              SimpleHttpServer.sendResponse(exchange , 404 , SimpleHttpServer.TYPE_TEXT ,
                      "존재하지 않는 ID입니다.");



    }

    private void createUserById(HttpExchange exchange) {
        try {
            String method = exchange.getRequestMethod();
            String[] body = SimpleHttpServer.readRequestBody(exchange).split("&");
            String name = body[0].substring(5);
            String email = body[1].substring(6);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


} // end of class
