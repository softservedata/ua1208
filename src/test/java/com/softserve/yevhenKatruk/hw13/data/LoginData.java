package com.softserve.yevhenKatruk.hw13.data;

public class LoginData {
    private String email;
    private String password;
    private String emailErrorMessage;
    private String passwordErrorMessage;

    public LoginData(String email, String password, String emailErrorMessage, String passwordErrorMessage) {
        this.email = email;
        this.password = password;
        this.emailErrorMessage = emailErrorMessage;
        this.passwordErrorMessage = passwordErrorMessage;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getEmailErrorMessage() {
        return emailErrorMessage;
    }

    public String getPasswordErrorMessage() {
        return passwordErrorMessage;
    }
}

