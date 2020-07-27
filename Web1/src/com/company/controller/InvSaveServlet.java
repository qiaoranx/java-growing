package com.company.controller;

import com.company.entity.Investor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InvSaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Investor inv=new Investor(
            request.getParameter("invname"),
            request.getParameter("cty"),
            request.getParameter("orgcode"),
            request.getParameter("contactman"),
            request.getParameter("contacttel"),
            request.getParameter("email"),
            request.getParameter("remark"),
            request.getParameter("usercode")
        );

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
