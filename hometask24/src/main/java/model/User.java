package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private int id;
    private String login;
    private String password;
    private String token;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.token = "";
    }


}
