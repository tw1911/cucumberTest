package ru.tw1911.testforsber.entity;

import lombok.Data;

@Data
public class User {
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
