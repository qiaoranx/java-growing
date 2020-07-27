package com.company.entity;

import com.company.util.PropertyUtil;

import java.util.Date;

public class Investor {

    private int invregnum;
    private String invname;
    private String cty;
    private String orgcode;
    private String contactman;
    private String contacttel;
    private String email;
    private String remark;
    private String usercode;
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
}
