package com.company.controller;

import com.company.dao.UserDAO;
import com.company.entity.User;
import com.company.model.UserService;
import com.company.util.JDBCUtil;
import com.company.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

public class AddUserServlet extends HttpServlet {
    private UserService userService=new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //数据输入
        User user =new User();
        WebUtil.makeRequestToObject(request,user);
        //业务层
        int res=userService.addUserService(user);
        //jsp层
        response.setContentType("text/html;charset=utf-8");
        if(res==1){
            request.getRequestDispatcher("/pageQuery").forward(request, response);
        } else {
            request.setAttribute("addError", "添加失败");
            request.getRequestDispatcher("/addUser.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userCode=request.getParameter("usercode");
        UserDAO dao =new UserDAO();
        int result=dao.verifyUsercode(userCode);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        if(result!=0){
            out.print("<font style='color: red;font-size: 17px'>用户代码已存在</font>");
        }else{
            out.print("<font style='color: red;font-size: 20px'></font>");
        }
        out.flush();
        out.close();
    }
}
