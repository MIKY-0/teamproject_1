package server.jhg;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SignUp implements HttpHandler {

    private static final String SIGN_UP = """
            <!DOCTYPE html>
            <html lang="ko">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>회원가입</title>
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
                </style>
            </head>
            <body>
                <form>
                    <h2 style="margin:10px">회원가입</h2>
                    <input type="id" placeholder="아이디" maxlength="30" required>
                    <input type="password" placeholder="비밀번호" maxlength="30" required>
                    <button id="signup" type="submit">회원가입</button>
                </form>
            </body>
            </html>
            """;

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        SimpleHttpServer.sendResponse(exchange, 200, SimpleHttpServer.TYPE_HTML, SIGN_UP);
    }

    public static void main(String[] args) {
        // 회원가입에서 필요한 기능
        // 아이디, 비밀번호 작성 시 list에 저장
        List<Users> users = new ArrayList<>();
        

    }
}
