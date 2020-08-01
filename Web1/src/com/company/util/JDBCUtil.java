package com.company.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;

public class JDBCUtil {
    //工具类的构造方法都是私有的
    private JDBCUtil() {

    }

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();

    public static Connection getConnection() throws SQLException {
       Connection con= threadLocal.get();
        if(con==null){
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/egov?useSSL=false", "root", "976431");
            threadLocal.set(con);
        }
            return con;
    }

    //重载
    public static Connection getConnection(HttpServletRequest req) throws SQLException {
        Connection con=null;
        ServletContext application=req.getServletContext();
        Map map=(Map)application.getAttribute("key1");
        Iterator it=map.keySet().iterator();
        while (it.hasNext()){
            con=(Connection)it.next();
            if((boolean)map.get(con)){
                map.put(con,false);
                break;
            }
        }
        return con;
    }

    //重载
    public static void close(Connection conn, Statement ps,ResultSet rs,HttpServletRequest req ){

        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        ServletContext application=req.getServletContext();
        Map map=(Map)application.getAttribute("key1");
        map.put(conn,true);
    }

    public static void close(Connection conn, Statement ps,ResultSet rs){

        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (conn!=null){
            try {
                conn.close();
                threadLocal.remove();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
