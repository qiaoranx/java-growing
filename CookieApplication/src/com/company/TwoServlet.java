package com.company;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TwoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int dunmpling_money=30;
      int gaifan_money=25;
      int xifan_money=10;
      int money;
      String food,userName="";
      Cookie newCard=null;

      response.setContentType("text/html;charset=utf-8");
      PrintWriter out=response.getWriter();
      food=request.getParameter("food");
        Cookie[] cookieArray=null;
        cookieArray=request.getCookies();
        for (Cookie cookie : cookieArray) {
            String key=cookie.getName();
            String value=cookie.getValue();
            if("userName".equals(key)){
                userName=value;
            }else if("money".equals(key)){
                money=Integer.valueOf(value);
                if("饺子".equals(food)){
                    if(dunmpling_money>money){
                            out.print(userName+"余额不足");
                    }else{
                        newCard=new Cookie("money",(money-dunmpling_money)+"");
                    }
                }
            }
        }

        response.addCookie(newCard);
        out.print(userName+"本次消费"+dunmpling_money+"余额为"+newCard.getValue());
    }
}
