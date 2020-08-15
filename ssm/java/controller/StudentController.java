package controller;

import domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.StudentService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @Resource
    private StudentService studentService;
    @RequestMapping(value = "/addStudent.do",method = RequestMethod.POST)
    public ModelAndView addStudent(Student student){
        ModelAndView mv=new ModelAndView();
        int res= studentService.addStudent(student);
        String resStr="注册成功";
        if(res!=1){
            resStr="注册失败";
        }
        mv.addObject("res",resStr);
        mv.setViewName("result");
        return mv;
    }
    @ResponseBody
    //body注解会自动将返回的对象通过响应体输出转成json格式的数组
    @RequestMapping(value = "/queryStudent.do",method = RequestMethod.GET)
    public List<Student> queryStudent(){
       return studentService.queryStudent();

    }
}
