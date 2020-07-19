package com.company.entity;

public class Users {
    private Integer userId;
    private String userName;
    private String password;
    private String sex;
    private String email;

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    public Users( ) {

    }

    public Users(Integer userId, String userName, String password, String sex, String email) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.email = email;
    }


}
