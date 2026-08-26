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
               
                   <a href="http://127.0.0.1:5500/ch17/index11.html"><button type="submit">목록으로</button></a>
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
                   <h1>존재하지 않는 유저 ID입니다.</h1>
                   <br />
               
                   <a href="http://127.0.0.1:5500/ch17/index11.html"><button type="submit">목록으로</button></a>
                 </body>
               </html>
               
               """;

    public static String htmlNoNameEmail = """
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
                   <h1>이름과 이메일은 비어있을 수 없습니다.</h1>
                   <br />
               
                   <a href="http://127.0.0.1:5500/ch17/index11.html"><button type="submit">목록으로</button></a>
                 </body>
               </html>
               
               """;
}