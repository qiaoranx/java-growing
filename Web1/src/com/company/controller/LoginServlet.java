package com.company.controller;

import com.company.dao.UserDAO;
import com.company.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               String userName=request.getParameter("loginName");
               String userPwd=request.getParameter("loginPwd");
               String orgType=request.getParameter("orgType");
               User user=new User("",userName,userPwd,orgType);
               UserDAO dao =new UserDAO();
               int res= dao.login(user);
               if(res==1){
                   response.sendRedirect("/EGOV/home.html");
               }else if(res==0){
                   response.sendRedirect("/EGOV/loginError.html");
               }
    }
}
