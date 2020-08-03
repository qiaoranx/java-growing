package com.company.controller;

import com.company.dao.EnpDAOImpl;
import com.company.entity.Enterprise;
import com.company.model.AuthService;
import com.company.model.AuthServiceImpl;
import com.company.model.EnterpriseService;
import com.company.model.EnterpriseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class QueryOrgServlet extends HttpServlet {
    private EnterpriseService enterpriseService=new EnterpriseServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String orgcode=request.getParameter("orgcode");
           if(orgcode==null){
               List<Enterprise> lst=enterpriseService.queryOrg();
               request.setAttribute("orgLst",lst);
               request.getRequestDispatcher("/auth/selectOrg.jsp").forward(request,response);
           }else{
               Enterprise enp= enterpriseService.queryOrgcode(orgcode);
               if(enp.getCnname()!=null){
                   request.setAttribute("out","组织机构代码已存在");
                   request.getRequestDispatcher("/invest/enterprise.jsp").forward(request,response);
               }else{
                   request.getRequestDispatcher("/invest/addEnterp.jsp").forward(request,response);
               }
           }

    }
}
