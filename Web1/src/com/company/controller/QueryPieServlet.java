package com.company.controller;

import com.company.entity.Enterprise;
import com.company.model.EnterpriseService;
import com.company.model.EnterpriseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class QueryPieServlet extends HttpServlet {
    EnterpriseService enterpriseService=new EnterpriseServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orgcode=request.getParameter("orgcode");
        String str= enterpriseService.queryPie(orgcode);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.print(str);
    }
}
