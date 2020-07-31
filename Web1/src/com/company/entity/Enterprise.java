package com.company.entity;

import com.company.util.PropertyUtil;

import java.math.BigDecimal;

public class Enterprise {

    private String orgcode;
    private String regno;
    private String cnname;
    private String enname;
    private String contactman;
    private String contacttel;
    private BigDecimal outregcap;
    private BigDecimal foreiregmoney;
    private String regtype;
    private String usercode;
    private String regdate;

    public Enterprise() {
        this.regdate= PropertyUtil.timeUtil("yyyy-MM-dd");
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
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

    public BigDecimal getOutregcap() {
        return outregcap;
    }

    public void setOutregcap(BigDecimal outregcap) {
        this.outregcap = outregcap;
    }

    public BigDecimal getForeiregmoney() {
        return foreiregmoney;
    }

    public void setForeiregmoney(BigDecimal foreiregmoney) {
        this.foreiregmoney = foreiregmoney;
    }

    public String getRegtype() {
        return regtype;
    }

    public void setRegtype(String regtype) {
        this.regtype = regtype;
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
        this.regdate = regdate;
    }
}
