package com.company.dao;

import com.company.entity.User;
import com.company.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    private JDBCUtil jdbcUtil=new JDBCUtil();

    public int addUser(User user){
        Connection con=null;
        PreparedStatement ps=null;
        int res=0;
        try {
           con= jdbcUtil.getConnection();
           String sql="insert into t_user(usercode,username,userpwd,orgtype,regdate) values(?,?,?,?,?)";
           ps= con.prepareStatement(sql);
            ps.setString(1,user.getUserCode());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getUserPwd());
            ps.setString(4, user.getOrgType());
            ps.setString(5, user.getRegDate());
            res=ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbcUtil.close(con,ps);
        }
        return res;
    }

    public int login(User user){
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int res=0;
        try {
            con= jdbcUtil.getConnection();
            String sql="select * from t_user where username=? and userpwd=? and orgtype=?";
            ps= con.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getUserPwd());
            ps.setString(3, user.getOrgType());
            rs=ps.executeQuery();
            while (rs.next()){
                res++;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbcUtil.close(con,ps,rs);
        }
        return res;
    }
}
