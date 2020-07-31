package com.company.entity;

import java.math.BigDecimal;

public class OrgInv {

    private String orgcode;
    private int invregnum;
    private BigDecimal regmoneyout;
    private BigDecimal percent;

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    public int getInvregnum() {
        return invregnum;
    }

    public void setInvregnum(int invregnum) {
        this.invregnum = invregnum;
    }

    public BigDecimal getRegmoneyout() {
        return regmoneyout;
    }

    public void setRegmoneyout(BigDecimal regmoneyout) {
        this.regmoneyout = regmoneyout;
    }

    public BigDecimal getPercent() {
        return percent;
    }

    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }
}
