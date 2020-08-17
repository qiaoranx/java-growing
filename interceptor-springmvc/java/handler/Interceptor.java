package handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
过滤器和拦截器的区别
 1.过滤器是servlet规范中的对象，拦截器是框架中的对象
 2.过滤器是tomcat创建的对象，拦截器是springmvc容器创建的请求
 3.过滤器在拦截器之前执行
 4.过滤器可以对静态文件html,js等过滤，而拦截器主要针对controller请求进行拦截,如果请求不通过中央调度器，则不会经过拦截器
 */
public class Interceptor implements HandlerInterceptor {
    //多个拦截器，在mvc配置文件中的声明顺序就是拦截顺序
    //preHandle和声明顺序一致
    //postHandle、afterCompletion和声明顺序相反
    //控制器方法执行之前
    //该方法如果返回false，controller和剩余两个方法都不会执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getSession(false)==null||request.getSession(false).getAttribute("name")==null){
            System.out.println("拦截了！！！！");
            return false;
        }else{
            return true;
        }
    }

    //控制器方法执行完毕后
    //可以获取ModelAndView,修改返回的视图或者数据
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    //在请求forward之后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
