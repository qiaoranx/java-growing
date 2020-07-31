package com.company.controller;

import com.company.dao.EnpDAO;
import com.company.entity.Enterprise;
import com.company.entity.OrgInv;
import com.company.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SaveOrgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enterprise enp=new Enterprise();
        WebUtil.makeRequestToObject(request,enp);
        enp.setOutregcap(new BigDecimal(request.getParameter("outregcap")));
        enp.setForeiregmoney(new BigDecimal(request.getParameter("foreiregmoney")));
        String[] invregnums=request.getParameterValues("invregnum");
        String[] regmoneyouts=request.getParameterValues("regmoneyout");
        String[] percents=request.getParameterValues("percent");
        List<OrgInv> orgInvList=new ArrayList<>();
        for (int i = 0; i <invregnums.length ; i++) {
            OrgInv orgInv=new OrgInv();
            orgInv.setInvregnum(Integer.parseInt(invregnums[i]));
            orgInv.setRegmoneyout(new BigDecimal(regmoneyouts[i]));
            orgInv.setPercent(new BigDecimal(percents[i]));
            orgInv.setOrgcode(enp.getOrgcode());
            orgInvList.add(orgInv);
        }
        EnpDAO dao=new EnpDAO();
        int[] res=dao.AddEnp(enp,orgInvList);
        int times=0;
        for (int i : res) {
            if(i==1){
                times++;
            }
        }
        if(times==orgInvList.size()+1){
            response.sendRedirect("invest/enterprise.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
