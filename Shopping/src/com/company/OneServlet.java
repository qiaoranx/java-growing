package com.company;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodName= request.getParameter("goodName");
        HttpSession session=request.getSession();
        Integer goodNum= (Integer) session.getAttribute(goodName);
        if(goodNum==null){
            session.setAttribute(goodName,1);
        }else{
            session.setAttribute(goodName,goodNum+1);
        }

    }
}
