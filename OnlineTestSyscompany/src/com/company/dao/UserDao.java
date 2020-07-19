package com.company.dao;

import com.company.entity.Users;
import com.company.util.JDBCUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private JDBCUtil util = new JDBCUtil();

    //注册
    public int add(Users user) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rs=0;
        try {
            conn = util.getConnection();
            String sql = "insert into t_userInfo(userName,password,sex,email) values(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getSex());
            ps.setString(4, user.getEmail());
            rs = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close(conn,ps);
        }
        return rs;
    }

    //重载
    public int add(Users user, HttpServletRequest req) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rs=0;
        try {
            conn = util.getConnection(req);
            String sql = "insert into t_userInfo(userName,password,sex,email) values(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getSex());
            ps.setString(4, user.getEmail());
            rs = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close(conn,ps,req);
        }
        return rs;
    }

    //查询
    public List<Users> display(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        List<Users> lst=new ArrayList();
        try {
            conn = util.getConnection();
            String sql = "select * from t_userInfo";
            ps = conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next()){
                Integer userId=rs.getInt("userId");
                String userName=rs.getString("userName");
                String password=rs.getString("password");
                String sex=rs.getString("sex");
                String email=rs.getString("email");
                Users user=new Users(userId,userName,password,sex,email);
                lst.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close(conn,ps,rs);
        }
        return lst;

    }

    //删除
    public int delete(Integer usrid){
        Connection conn = null;
        PreparedStatement ps = null;
        int rs=0;
        try {
            conn = util.getConnection();
            String sql = "delete from t_userInfo where userId=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, usrid.toString());
            rs = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close(conn,ps);
        }
        return rs;
    }

    //登录验证
    public int verify(String name ,String pwd){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        int result=0;
        try {
            conn = util.getConnection();
            String sql = "select count(*) from t_userInfo where userName=? and password=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pwd);
            rs= ps.executeQuery();
           while (rs.next()){
              result= rs.getInt("count(*)");
           }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close(conn,ps,rs);
        }
        return result;
    }
}
