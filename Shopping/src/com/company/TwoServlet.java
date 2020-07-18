package com.company;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

public class TwoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        Enumeration goodNames=session.getAttributeNames();
        while (goodNames.hasMoreElements()){
            String goodName=(String)goodNames.nextElement();
            int goodNum=(int)session.getAttribute(goodName);
            System.out.println(goodName+goodNum);
        }

    }
}
