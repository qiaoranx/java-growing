package com.company.controller;

import com.company.dao.ProvinceDAO;
import com.company.entity.Province;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ProServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str=request.getParameter("proid").trim();
        //json默认值
        String proJson="{}";
        if(str!=null&&!"".equals(str)){
            ProvinceDAO dao=new  ProvinceDAO();
            Province pro= dao.queryProvinceById(Integer.valueOf(str));
            ObjectMapper om=new ObjectMapper();
            proJson= om.writeValueAsString(pro);
        }
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.print(proJson);
        out.flush();
        out.close();
    }
}
