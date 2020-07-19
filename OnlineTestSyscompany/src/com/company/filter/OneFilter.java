package com.company.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OneFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        String uri=  req.getRequestURI();
        HttpSession session=null;
        if(uri.indexOf("login")!=-1||"/myWeb/".equals(uri)){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        session= req.getSession(false);
        if(session==null){
            req.getRequestDispatcher("/loginError.html").forward(servletRequest,servletResponse);
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
