package com.company.controller;

import com.company.dao.UserDAO;
import com.company.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String userCode = request.getParameter("usercode");
        String userName = request.getParameter("username");
        String userPwd = request.getParameter("userpwd");
        String orgType = request.getParameter("orgType");
        System.out.println(orgType==null);
        UserDAO dao = new UserDAO();
        User user = new User(userCode, userName, userPwd, orgType);
        int res = dao.addUser(user);
        if (res == 1) {
            request.getRequestDispatcher("/pageQuery").forward(request, response);
        } else {
//            request.getRequestDispatcher("/addUserError.jsp").forward(request,response);
//            response.sendRedirect("/EGOV/addUserError.html");
//            out.print("<font style='color: red;font-size: 20px'>添加失败</font>");
            request.setAttribute("addError", "添加失败");
            request.getRequestDispatcher("/addUser.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userCode=request.getParameter("usercode");
        response.setContentType("text/html;charset=utf-8");
        UserDAO dao =new UserDAO();
        int result=dao.verifyUsercode(userCode);
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
