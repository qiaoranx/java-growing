package com.company.controller;

import com.company.dao.InvDAO;
import com.company.entity.Investor;
import com.company.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class InvSaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
        Investor inv=new Investor();
        WebUtil.makeRequestToObject(request,inv);
        InvDAO dao=new InvDAO();
       int res= dao.addInvestor(inv);
       if(res==1){
           response.sendRedirect("/EGOV/invest/invMsgReg.jsp");
       }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
