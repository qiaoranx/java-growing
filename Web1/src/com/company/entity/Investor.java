package com.company.entity;

import com.company.util.PropertyUtil;

import java.util.Date;

public class Investor {

    private  int invregnum;
    private String invname;
    private String cty;
    private String orgcode;
    private String contactman;
    private String contacttel;
    private String email;
    private String remark;
    private String usercode;
    private String username;
    private String regdate;

    public Investor(String invname, String cty, String orgcode, String contactman, String contacttel, String email, String remark, String usercode) {
        this.invname = invname;
        this.cty = cty;
        this.orgcode = orgcode;
        this.contactman = contactman;
        this.contacttel = contacttel;
        this.email = email;
        this.remark = remark;
        this.usercode = usercode;
        this.regdate = PropertyUtil.timeUtil("yyyy-MM-dd");
    }

    public Investor() {
        this.regdate = PropertyUtil.timeUtil("yyyy-MM-dd");
    }

    public int getInvregnum() {
        return invregnum;
    }

    public void setInvregnum(int invregnum) {
        this.invregnum = invregnum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getInvname() {
        return invname;
    }

    public void setInvname(String invname) {
        this.invname = invname;
    }

    public String getCty() {
        return cty;
    }

    public void setCty(String cty) {
        this.cty = cty;
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    public String getContactman() {
        return contactman;
    }

    public void setContactman(String contactman) {
        this.contactman = contactman;
    }

    public String getContacttel() {
        return contacttel;
    }

    public void setContacttel(String contacttel) {
        this.contacttel = contacttel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate=regdate;
    }

}
