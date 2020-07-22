package com.company.entity;

import com.company.util.Const;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private String userCode;
    private String userName;
    private String userPwd;
    private String orgType;
    private String regDate;

    public User() {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern(Const.DATE_FORMAT_ALL);
        this.regDate =sdf.format(new Date());
    }

    public User(String userCode, String userName, String userPwd, String orgType) {
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        this.userCode = userCode;
        this.userName = userName;
        this.userPwd = userPwd;
        this.orgType = orgType;
        this.regDate =sdf.format(new Date());
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }


}
