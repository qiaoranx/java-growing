package com.company.controller;

import com.company.dao.UserDAO;
import com.company.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String usercode=request.getParameter("usercheck");
            String pageNum=request.getParameter("pageNum");
            UserDAO dao=new UserDAO();
            User user= dao.selectUser(usercode);
            request.setAttribute("user",user);
            request.setAttribute("pageNum",pageNum);
            request.getRequestDispatcher("/updateUser.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
