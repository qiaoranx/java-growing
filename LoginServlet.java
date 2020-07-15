package com.company.controller;

import com.company.dao.UserDao;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataInput;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao=new UserDao();
        request.setCharacterEncoding("utf-8");
        String name,pwd;
        int isVerify;
        name=request.getParameter("name");
        pwd=request.getParameter("pwd");
       isVerify= dao.verify(name,pwd);
       if(isVerify==1){
           response.sendRedirect("/OnlineTestSys/index.html");
       }else{
           response.sendRedirect("/OnlineTestSys/loginError.html");
       }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
