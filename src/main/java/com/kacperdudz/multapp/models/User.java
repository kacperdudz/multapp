package com.kacperdudz.multapp.models;

import lombok.Data;

@Data
public class User {

    private final Integer userId;
    private final String userName;

    public User(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
