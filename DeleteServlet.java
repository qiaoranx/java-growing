package com.company.controller;

import com.company.dao.UserDao;
import com.company.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao=new UserDao();
        int result;
        PrintWriter out;
       String num= request.getParameter("userId");
        result= dao.delete(Integer.parseInt(num));
        response.setContentType("text/html;charset=utf-8");
        out=response.getWriter();
        if(result==1){
            out.print("<font style='color:red;font-size:20'>delete success</font>");
        }else{
            out.print("<font style='color:red;font-size:20'>delete failed</font>");
        }
    }
}
