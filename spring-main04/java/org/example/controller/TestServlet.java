package org.example.controller;

import org.example.domain.Student;
import org.example.service.StudentService;
import org.example.service.impl.StudentServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Style;
import java.io.IOException;

public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        String age=request.getParameter("age");
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        Student stu=new Student();
        stu.setAge(Integer.parseInt(age));
        stu.setId(Integer.parseInt(id));
        stu.setName(name);
        stu.setEmail(email);
//        String config="applicationContext.xml";
//        ApplicationContext ac=new ClassPathXmlApplicationContext(config);
        //从servletContext取容器对象
//        WebApplicationContext ac=null;
//        String key=WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
//        Object value=getServletContext().getAttribute(key);
//        if(value!=null){
//            ac=(WebApplicationContext) value;
//        }
        //或者使用工具类
        ApplicationContext ac= WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        StudentService studentService = (StudentService) ac.getBean("studentService");
        studentService.addStudent(stu);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
