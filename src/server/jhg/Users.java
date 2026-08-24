package server.jhg;

import lombok.Getter;

@Getter
public class Users {

    private String id;
    private String pw;

    public Users(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

}
