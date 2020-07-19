package com.company.controller;

import com.company.dao.UserDao;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.DataInput;
import java.io.IOException;
import java.util.Enumeration;

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
           //在服务器端创建柜子
           HttpSession session=request.getSession();
           response.sendRedirect("/OnlineTestSys/index.html");
       }else{
           response.sendRedirect("/OnlineTestSys/loginError.html");
       }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
