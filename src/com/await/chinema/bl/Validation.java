package com.await.chinema.bl;

public class Validation {
    public static boolean validate(String userLogin, String userPassword){
        return userLogin.matches("[A-Za-z0-9]{5,}")  && userPassword.matches("[A-Za-z0-9]{5,}");
    }
}
