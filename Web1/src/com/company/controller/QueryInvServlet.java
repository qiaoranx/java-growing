package com.company.controller;

import com.company.dao.InvDAO;
import com.company.entity.Investor;
import com.company.entity.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class QueryInvServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //invregnum在getparameter的参数错误时才会返回null,否则返回的是空字符串
        //url中key=,value，返回的是null
        String invregnum=request.getParameter("invregnum");
        String invname=request.getParameter("invname");
        String regdate1=request.getParameter("regdate1");
        String regdate2=request.getParameter("regdate2");
        InvDAO dao=new InvDAO();
        List<Investor> invLst= dao.queryInv(invregnum,invname,regdate1,regdate2);
        request.setAttribute("invLst",invLst);
        //可以在表单添加隐藏域，value为路径，dispatcher(value).forward();
        if("1".equals(request.getParameter("gowhere"))){
            request.getRequestDispatcher("invest/invMsgReg.jsp").forward(request,response);
        }else if("2".equals(request.getParameter("gowhere"))){
            request.getRequestDispatcher("invest/selectInv.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
