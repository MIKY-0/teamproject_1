package server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class Login implements HttpHandler {

    private static final String LOGIN = """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>로그인</title>
                <style>
                    body{
                        text-align:center;
                        border: 2px solid #ddd;
                        max-width: 500px;
                        border-radius: 15px;
                        margin: 50px auto;
                        padding: 20px;
                    }
                    button{
                        cursor: pointer;
                    }
                    .text{
                        padding:30px;
                        margin:30px;
                    }
                    #login{
                        background-color: lightblue;
                    }
                </style>
            </head>
            <body>
                <form>
                    <h2 style="margin:10px">로그인</h2>
                    <input type="id" placeholder="아이디" maxlength="30" required>
                    <input type="password" placeholder="비밀번호" maxlength="30" required>
                    <button id="login" type="submit">로그인</button>\s
                </form>
            
                <br>
                <br>
                <button onclick="location.href='/api/signup.html'" style="margin-bottom: 20px;">회원가입</button>
            </body>
            </html>
            """;

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        SimpleHttpServer.sendResponse(exchange, 200, SimpleHttpServer.TYPE_HTML, LOGIN);
    }

    public static void main(String[] args) {
        // 로그인에서 필요한 기능
        // 1. 회원가입에 저장된 list 정보 들고 오기
        // 2. 아이디 유무
        // 3. 비밀번호 유무
        // 4. 아이디 - 비밀번호가 일치하는지
        // 5. 틀렸을 때 에러 메시지 출력
        // 6. 정상적으로 로그인 버튼 클릭시 메인 홈으로 이동
    }
}
