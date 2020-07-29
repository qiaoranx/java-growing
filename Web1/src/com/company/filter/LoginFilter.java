package com.company.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       //访问任何一个jsp文件，服务器会自动创建session
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        HttpSession session= req.getSession(false);
        if(req.getRequestURI().contains("login")||req.getRequestURI().equals("/EGOV/")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else if(session!=null&&session.getAttribute("user")!=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            req.getRequestDispatcher("/").forward(servletRequest,servletResponse);
        }
    }
}
