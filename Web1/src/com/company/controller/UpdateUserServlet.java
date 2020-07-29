package com.company.controller;

import com.company.dao.UserDAO;
import com.company.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post在响应体需要指定编码格式
//        request.setCharacterEncoding("utf-8");
        String pageNum=request.getParameter("pageNum");
        String userCode=request.getParameter("usercode");
        String userName=request.getParameter("username");
        String userPwd=request.getParameter("userpwd");
        String orgType=request.getParameter("orgType");
        User user=new User(userCode,userName,userPwd,orgType);
        UserDAO dao =new UserDAO();
        int res=dao.updateUser(user);
//        response.setContentType("text/html;charset=utf-8");
        if(res==1){
            request.getRequestDispatcher("/pageQuery?pageNum="+pageNum).forward(request,response);
        }else{
//            request.getRequestDispatcher("/addUserError.html").forward(request,response);
            response.sendRedirect("/EGOV/addUserError.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
