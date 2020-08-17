package handler;

import exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 注解含义：控制器增强
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NameException.class)
    public ModelAndView doNameException(Exception ex){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","用户名必须是zs");
        mv.addObject("ex",ex);
        mv.setViewName("nameError");
        return mv;
    }
//处理未知异常
    @ExceptionHandler()
    public ModelAndView doOtherException(Exception ex){
        ModelAndView mv=new ModelAndView();
        mv.addObject("ex",ex);
        mv.setViewName("otherError");
        return mv;
    }
}
