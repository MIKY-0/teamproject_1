package ex1;

import java.util.HashMap;
import java.util.Map;


public class UserValidator {
    private String id;
    private String password;
    private static final String PASS = "성공(0)";
    private static final String LENGTH = "길이 미달(1)";
    private static final String SYNTAX = "형식 불일치(2)";

    public UserValidator(String id , String password ) {
        this.id = id;
        this.password = password;

        checkId(id);
        checkPassword(password);
    }


    public void checkId(String id){
            if(id.matches(".*[ㄱ-ㅎ ㅏ-ㅣ 가-힣]") || id.matches(".*[!@#$%^&*].*")) {
                System.out.println("아이디에는 한글,특수문자가 포함될 수 없습니다 : " + SYNTAX);
                return;
            }
            if (id.length() < 3 || 10 < id.length()) {
                System.out.println("Id는 3글자 이상 10글자 이하여야 합니다. : " + LENGTH);
            } else {
                System.out.println("아이디 일치 : " + PASS);
            }
        }


    public void checkPassword(String password){
        if(!(password.matches(".*[!@#$%^&*].*") && password.matches(".*[a-zA-Z].*") &&
                password.matches(".*[0-9].*"))) {
            System.out.println("비밀번호는 영문(대/소문자) , 숫자 , 특수문자(!@#$%^&*)를 하나씩 포함해야합니다 : " + SYNTAX);
            return;
        }
        if(password.length() < 4 || 12 < password.length()) {
            System.out.println("비밀번호는 4글자 이상 12글자 이하여야합니다. : " + LENGTH);
        } else {
            System.out.println("비밀번호 일치 : " + PASS);
        }
    }


}
