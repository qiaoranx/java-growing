package com.company.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BMIServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String height=request.getParameter("h");
        String weight=request.getParameter("w");

        float h=Float.valueOf(height);
        float w=Float.valueOf(weight);
        float bmi=w/(h*h);

        String msg="";
        if(bmi<18.5){
            msg="偏瘦";
        }else if(bmi>18.5&&bmi<=23.9){
            msg="正常";
        }else{
            msg="偏胖";
        }
        System.out.println(msg);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.print("<font style='color:red;font-size:20'>"+msg+"</font>");

        //第二种方式
        /**
         * out.println(msg);
         * out.flush();
         * out.close();
         */

    }
}
