package com.company.controller;

import com.company.dao.InvDAO;
import com.company.entity.Investor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoInvDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String invregnum= request.getParameter("invregnum");
         InvDAO dao=new InvDAO();
         Investor inv=dao.invByNum(invregnum);
         request.setAttribute("inv",inv);
         request.getRequestDispatcher("invest/invDetail.jsp").forward(request,response);
    }
}
