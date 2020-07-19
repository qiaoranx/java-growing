package com.company.controller;

import com.company.dao.UserDao;
import com.company.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String name,pwd,gender,email;
       UserDao dao=new UserDao();
       Users user=null;
       int result;
       PrintWriter out;
       name=request.getParameter("name");
        pwd=request.getParameter("pwd");
        gender=request.getParameter("gender");
        email=request.getParameter("email");
        user=new Users(null,name,pwd,gender,email);
        Date startDate=new Date();
        result= dao.add(user,request);
        Date endDate=new Date();
        System.out.println(endDate.getTime()-startDate.getTime());
        response.setContentType("text/html;charset=utf-8");
        out=response.getWriter();
        if(result==1){
            out.print("<font style='color:red;font-size:20'>register success</font>");
        }else{
            out.print("<font style='color:red;font-size:20'>register failed</font>");
        }



    }
}
