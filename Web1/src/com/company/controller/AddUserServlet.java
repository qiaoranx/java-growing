package com.company.controller;

import com.company.dao.UserDAO;
import com.company.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userCode=request.getParameter("usercode");
        String userName=request.getParameter("username");
        String userPwd=request.getParameter("userpwd");
        String orgType=request.getParameter("orgType");
        User user=new User(userCode,userName,userPwd,orgType);
        UserDAO dao =new UserDAO();
        int res=dao.addUser(user);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        if(res==1){
            out.print("<font style='color:red;font-size:20'>添加成功</font>");
        }else{
            out.print("<font style='color:red;font-size:20'>添加失败</font>");
        }
    }
}
