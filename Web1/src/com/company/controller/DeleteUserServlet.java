package com.company.controller;

import com.company.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] usercodes=request.getParameterValues("usercheck");
        UserDAO dao=new UserDAO();
        int res= dao.deleteUser(usercodes);
        if(res==usercodes.length){
            request.getRequestDispatcher("/pageQuery?pageNum=1").forward(request,response);
        }else{
//            request.getRequestDispatcher("/addUserError.html").forward(request,response);
            response.sendRedirect("/EGOV/addUserError.html");
        }
    }
}
