package server;

public class UserErrorHtml {
    public static String htmlNoId = """
               <!doctype html>
               <html lang="en">
                 <head>
                   <meta charset="UTF-8" />
                   <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                   <title>Document</title>
                   <style>
                     button {
                       margin-left: 30px;
                       margin-top: 40px;
                       font-size: 20px;
                       background-color: beige;
                       border: 1px solid;
                       cursor: pointer;
                     }
                     button:hover {
                       background-color: gray;
                     }
                   </style>
                 </head>
                 <body>
                   <h1>유저 ID를 입력하세요.</h1>
                   <br />
               
                   <a href="http://localhost:8080/api/users"><button type="submit">목록으로</button></a>
                 </body>
               </html>
               
               """;

    public static String htmlNoUser = """
               <!doctype html>
               <html lang="en">
                 <head>
                   <meta charset="UTF-8" />
                   <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                   <title>Document</title>
                   <style>
                     button {
                       margin-left: 30px;
                       margin-top: 40px;
                       font-size: 20px;
                       background-color: beige;
                       border: 1px solid;
                       cursor: pointer;
                     }
                     button:hover {
                       background-color: gray;
                     }
                   </style>
                 </head>
                 <body>
                   <h1>유저 ID를 입력하세요.</h1>
                   <br />
               
                   <a href="http://localhost:8080/api/users"><button type="submit">목록으로</button></a>
                 </body>
               </html>
               
               """;
}