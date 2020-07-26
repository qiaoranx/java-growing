package com.company.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object tem=  request.getParameter("name");
        String tem1=request.getParameter("name");
        System.out.println(tem=="");
        System.out.println(tem==null);
        System.out.println(tem1=="");
        System.out.println(tem1==null);
    }
}
