package controller;

import exception.AgeException;
import exception.MyUserException;
import exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
@RequestMapping("/some.do")
    public ModelAndView doSome(String name, Integer age) throws MyUserException {
    ModelAndView mv=new ModelAndView();
    if(!"zs".equals(name)){
        throw new NameException("姓名不正确");
    }
    if(age==null||age>90){
        throw new AgeException("年龄不合法");
    }
    mv.addObject("myname",name);
    mv.addObject("myage",age);
    mv.setViewName("show");
    return mv;
}
}
