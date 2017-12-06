package com.neiron.neiron.service;

import javax.mail.Authenticator;

public class MyAuthEmail extends Authenticator {
    private String user;
    private String password;

    MyAuthEmail(String user, String password) {
        this.user = user;
        this.password = password;
    }
}