package com.company.listener;

import com.company.util.JDBCUtil;

import javax.naming.ldap.HasControls;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.swing.text.html.HTMLDocument;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OneListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JDBCUtil util=new JDBCUtil();
        Map map=new HashMap();
        for (int i = 0; i <20 ; i++) {
            try {
                Connection con=util.getConnection();
                System.out.println("创建20个conn");
                //使用con的地址作为key
                map.put(con,true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
       // map是局部变量，为了保存它，将它放到全局作用域对象中，其生命周期是服务器的启动到关闭
        ServletContext application= sce.getServletContext();
        application.setAttribute("key1",map);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext application= sce.getServletContext();
        Map map=(Map)application.getAttribute("key1");
        //set中的对象是无序的，不能被遍历，可以获得其迭代器
      Iterator it= map.keySet().iterator();
      while (it.hasNext()){
           Connection con=(Connection)it.next();
           if(con!=null){
               System.out.println("销毁该连接con");
           }
      }

    }
}
