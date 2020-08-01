package com.company.controller;

import com.company.dao.EnpDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QueryOrgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String orgcode=request.getParameter("orgcode");
           EnpDAOImpl dao=new EnpDAOImpl();
          int res=dao.queryOrgcode(orgcode);
          if(res==1){
              request.setAttribute("out","组织机构代码已存在");
              request.getRequestDispatcher("/invest/enterprise.jsp").forward(request,response);
          }else{
              request.getRequestDispatcher("/invest/addEnterp.jsp").forward(request,response);
          }
    }
}
