package com.company.entity;

import com.company.util.Const;
import com.company.util.PropertyUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private String usercode;
    private String username;
    private String userpwd;
    private String orgtype;
    private String regdate;

    public User() {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern(Const.DATE_FORMAT_ALL);
        this.regdate =sdf.format(new Date());
    }

    public User(String userCode, String userName, String userPwd, String orgType) {
        this.usercode = userCode;
        this.username = userName;
        this.userpwd = userPwd;
        this.orgtype = orgType;
        this.regdate = PropertyUtil.timeUtil("yyyy-MM-dd HH:mm:ss");
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String userCode) {
        this.usercode = userCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userPwd) {
        this.userpwd = userPwd;
    }

    public String getOrgtype() {
        return orgtype;
    }

    public void setOrgtype(String orgType) {
        this.orgtype = orgType;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regDate) {
        this.regdate = regDate;
    }


}
