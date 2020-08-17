package controller;

import com.mysql.cj.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class TestController {
    @RequestMapping("/some.do")
    public ModelAndView doSome(String name, Integer age) {
        ModelAndView mv=new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        mv.setViewName("add");
        return mv;
    }
    @RequestMapping("/login")
    public ModelAndView doLogin(String name, HttpSession session) {
        session.setAttribute("name",name);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("show");
        return mv;
    }
}
