package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import vo.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建控制器对象的注解，放在mvc的容器中
 */
@Controller
//模块名称，所有url的公共部分
//@RequestMapping(value = "/test")
public class TestController {
    /**
     * RequestMapping修饰的方法叫做控制器方法
     * 请求映射，将一个url和一个方法绑定在一起
     * 属性：method，请求的方式，RequestMethod.的枚举值
     *
     */
    @RequestMapping(value = "/some.do",method = RequestMethod.GET)
    //请求传参定义在方法的形参位置
    //逐个接收
    //也可以直接接收参数，参数名要和请求提交中的名字一致，框架会自己进行数据类型转化
    //public ModelAndView doSome(String name,Integer age){
    //http状态码400对应的tomcat把数据提交给controller发生错误
    //@RequestParam注解解决请求参数名和形参名不一致的情况
    //@RequestParam的属性required的默认值是true，表示参数不能为空，否则报错
    public ModelAndView doSome(@RequestParam(value = "rname",required = true)String name){
        //ModelAndView数据和视图,框架提供的类
        ModelAndView mv=new ModelAndView();
        //mvc框架会自动将mv的内容添加到request中
        mv.addObject("msg","hello,mvc");
        mv.addObject("fun","执行的是dosome方法");
        //框架对视图执行的是request.getDispatcher().forward();
        mv.setViewName("show");
        return mv;
    }

    //对象传参
    //框架会自己创建set注入，将相同的请求参数赋值给对象的属性
    @RequestMapping(value = "/other.do",method = RequestMethod.GET)
    public ModelAndView doOther(Student stu){
        //ModelAndView数据和视图,框架提供的类
        ModelAndView mv=new ModelAndView();
        //mvc框架会自动将mv的内容添加到request中
        mv.addObject("msg","hello,mvc"+stu.getName());
        mv.addObject("fun","执行的是dosome方法");
        //框架对视图执行的是request.getDispatcher().forward();
        mv.setViewName("show");
        return mv;
    }

    //方法返回值的介绍
    //string代表视图的逻辑路径或者绝对路径
    @RequestMapping(value = "/returnString.do",method = RequestMethod.GET)
    //框架对视图执行的是request.getDispatcher().forward();
    public String doThing(Student stu){
        return "show";
    }

    //处理器方法返回void处理ajax请求
    //ajax的输出内容以response形式输出，不需要方法返回值
    @RequestMapping(value = "/returnajax.do",method = RequestMethod.GET)
    public void doAjax(HttpServletResponse response,String name){
        Student stu=new Student();
        stu.setName(name);
        String json="";
        if(stu!=null){
            ObjectMapper om=new ObjectMapper();
            try {
                json=om.writeValueAsString(stu);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        response.setContentType("application/json;charset=utf-8");
        try {
            PrintWriter pw=response.getWriter();
            pw.print(json);
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @ResponseBody
    //通过response输出做ajax响应的
    @RequestMapping(value = "/returnObject.do",method = RequestMethod.GET)
    //object代表数据返回，而不是视图路径
    public Student doObject(String name){
        Student stu=new Student();
        stu.setName("ajaxObject");
        return stu;//框架会自动转为json
    }

    @ResponseBody
    @RequestMapping(value = "/returnList.do",method = RequestMethod.GET)
    public List<Student> doList(String name){
        Student stu=new Student();
        Student stu1=new Student();
        stu.setName("ajaxObject");
        stu1.setName("ajaxList");
        List<Student> lst=new ArrayList<>();
        lst.add(stu);
        lst.add(stu1);
        return lst ;//框架会自动转为json
    }

    //区别返回值是string还是视图，看有没有responseBody的注解
    @ResponseBody
    //解决乱码问题produces属性
    @RequestMapping(value = "/returnStringData.do",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String doString(String name){
        return "hello,mvc";
    }
}
