package com.company.jdbc;

import java.sql.*;

public class JDBCUtil {
    //工具类的构造方法都是私有的
static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private JDBCUtil() {

    }

    public  static Connection getConnection() throws SQLException {

          return DriverManager.getConnection("jdbc:mysql://localhost:3306/login?useSSL=false", "root", "976431");
    }

    public static void close(Connection conn, Statement ps, ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (ps!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


}
