package com.await.chinema.da.entity;

public class Response {
    public String nameUser;
    public String response;


    public Response(String nameUser, String response) {
        this.nameUser = nameUser;
        this.response = response;
    }

    public String getNameUser() {
        return nameUser;
    }

    public String getResponse() {
        return response;
    }
}
