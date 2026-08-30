package com.gridweaver.dto;

public class LoginResponce {
    private String message;
    private String username;
    public LoginResponce(String message , String username ){
        this.message=message;
        this.username=username;
    }
    public String getMessage(){
        return message;
    }
    public String getUserName(){
        return username;
    }

}
