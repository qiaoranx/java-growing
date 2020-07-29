package com.company.controller;

import com.company.dao.UserDAO;
import com.company.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
        String userCode=request.getParameter("loginName");
        String userPwd=request.getParameter("loginPwd");
        String orgType=request.getParameter("orgType");
        User user=new User(userCode,"",userPwd,orgType);
        UserDAO dao =new UserDAO();
        int res= dao.login(user);
//        response.setContentType("text/html;charset=utf-8");
        if(res==1){
            //确认用户存在再创建session,保证数据合法性
            User userSession=dao.selectUser(userCode);
            HttpSession session=request.getSession(true);
            session.setAttribute("user",userSession);
            response.sendRedirect("/EGOV/home.jsp");
        }else{
            request.setAttribute("loginError","登录失败");
            //欢迎页面可以省略路径
            request.getRequestDispatcher("/").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
