package org.example.ba01;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

@Aspect
public class MyAspect {
    /**
     * 切面方法
     * public
     * 没有返回值
     */

    @Before(value="execution( * *..SomeServiceImpl.do*(..))")
    public void myBefore(){
        System.out.println("切面前置通知"+new Date());
    }

}
