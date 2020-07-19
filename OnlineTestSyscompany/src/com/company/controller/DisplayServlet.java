package com.company.controller;

import com.company.dao.UserDao;
import com.company.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "DisplayServlet")
public class DisplayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao dao=new UserDao();
        List<Users> result;
        PrintWriter out;
        result= dao.display();
        response.setContentType("text/html;charset=utf-8");
        out=response.getWriter();
        out.print("<table border='2' align='center'");
        out.print("<tr>");
        out.print("<td>UserId</td>");
        out.print("<td>UserName</td>");
        out.print("<td>Password</td>");
        out.print("<td>Gender</td>");
        out.print("<td>Email</td>");
        out.print("<td>Operate</td>");
        out.print("</tr>");
        for(Users user:result){
            out.print("<tr>");
            out.print("<td>"+user.getUserId()+"</td>");
            out.print("<td>"+user.getUserName()+"</td>");
            out.print("<td>***********</td>");
            out.print("<td>"+user.getSex()+"</td>");
            out.print("<td>"+user.getEmail()+"</td>");
            out.print("<td> <a href='/OnlineTestSys/delete?userId="+user.getUserId()+"'>delete</a></td>");
            out.print("</tr>");
        }
        out.print("</table>");
    }




}
