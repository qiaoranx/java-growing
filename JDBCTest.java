package com.company.jdbc;

//模拟用户登录
//解决SQL注入的问题

import java.sql.*;
import java.util.*;

public class JDBCTest {

    public static void main(String[] args) {

        //初始化一个界面
        Map<String, String> userLoginInfo = initialUI();
        //验证用户名和密码
        boolean isLogin = login(userLoginInfo);
        System.out.println(isLogin ? "登陆成功" : "登录失败");
    }


    /**
     * 验证登录信息
     *
     * @param userLoginInfo
     * @return 是否登陆成功
     */
    private static boolean login(Map<String, String> userLoginInfo) {

        boolean isLogin = false;
        Connection conn = null;
       // Statement state = null;
        PreparedStatement ps=null;
        ResultSet rs = null;

        //1.注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?useSSL=false", "root", "976431");

            //获取数据库操作对象
            String sql = "select * from t_user where loginName= ? and loginPwd=?";
            //对sql框架编译
            ps = conn.prepareStatement(sql);
            //给框架传值
            ps.setString(1,userLoginInfo.get("loginName"));
            ps.setString(2,userLoginInfo.get("loginPwd"));

            //处理结果集
            rs = ps.executeQuery();
            if (rs.next()) {
                isLogin = true;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    if (conn != null) {
                        try {
                            conn.close();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }

            }
        }
        return isLogin;

    }

    /**
     * 初始化用户界面
     *
     * @return 返回用户名和密码信息
     */
    private static Map<String, String> initialUI() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String loginName = sc.nextLine();
        System.out.println("请输入账户密码：");
        String loginPwd = sc.nextLine();
        Map<String, String> userLoginInfo = new HashMap<>();
        userLoginInfo.put("loginName", loginName);
        userLoginInfo.put("loginPwd", loginPwd);
        return userLoginInfo;

    }


}

