package com.company;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String userName= request.getParameter("userName");
        String money= request.getParameter("money");
        Cookie card1=new Cookie("userName",userName);
        Cookie card2=new Cookie("money",money);
        response.addCookie(card1);
        response.addCookie(card2);
        //请求转发
        request.getRequestDispatcher("/index_2.html").forward(request,response);




    }
}
