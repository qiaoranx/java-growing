package com.company.controller;

import com.company.dao.ProvinceDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class QueryProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str=request.getParameter("proid").trim();
        String proName="查询不能为空";
        if(str!=null&&!"".equals(str)){
            ProvinceDAO dao=new  ProvinceDAO();
            proName= dao.queryProvinceNameById(Integer.valueOf(request.getParameter("proid")));
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.print(proName);

    }
}
