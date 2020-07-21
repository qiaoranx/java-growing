package com.company.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;

public class JDBCUtil {
    //工具类的构造方法都是私有的

    public JDBCUtil() {

    }

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/springdb?useSSL=false", "root", "976431");
    }

    //重载
    public Connection getConnection(HttpServletRequest req) throws SQLException {
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

    public  void close(Connection conn, Statement ps){
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
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    //重载
    public  void close(Connection conn, Statement ps,HttpServletRequest req ){
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

    public  void close(Connection conn, Statement ps,ResultSet rs){

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
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


}
