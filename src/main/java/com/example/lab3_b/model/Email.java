package com.example.lab3_b.model;

import java.util.regex.Pattern;

public class Email {
    private String email;

    private Email(String email) {
        this.email = email;
    }

    public static Email createEmail(String emailStr){

        if (Pattern.matches("^[a-z0-9+_.-]+@[a-z.]+$", emailStr)){
            Email newEmail = new Email(emailStr);
            return newEmail;
        }else{
            return null;
        }
    }

    public String getAsString() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Email) {
            Email newEmail = (Email) o;
            return email.equals(newEmail.email);
        }
        return false;
    }

}
