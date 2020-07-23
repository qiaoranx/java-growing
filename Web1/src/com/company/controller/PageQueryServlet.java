package com.company.controller;

import com.company.dao.UserDAO;
import com.company.entity.User;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.company.util.Const.PAGESIZE;

public class PageQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int pageNum=request.getParameter("pageNum")==null?1:Integer.parseInt(request.getParameter("pageNum"));
//            HttpSession session=request.getSession();
//            List<User> bigList=( List<User>)session.getAttribute("bigList");
//            if(bigList==null){
//
//                bigList= dao.pageQuery();
//                session.setAttribute("bigList",bigList);
//            }
//
//            for (int i = beginindex; i <endindex ; i++) {
//                if(i>bigList.size()-1){
//                    return;
//                }
//                userList.add(bigList.get(i));
//            }

            UserDAO dao=new UserDAO();
            List<User> userList=dao.pageDivQuery(PAGESIZE,pageNum);
            int totalCount= dao.seqQuery();
            int totalPage=totalCount%PAGESIZE==0?totalCount/PAGESIZE:totalCount/PAGESIZE+1;
            request.setAttribute("userList",userList);
            request.setAttribute("totalCount",totalCount);
            request.setAttribute("totalPage",totalPage);
            request.setAttribute("pageSize",PAGESIZE);

        request.getRequestDispatcher("/user.jsp").forward(request,response);
    }
}
