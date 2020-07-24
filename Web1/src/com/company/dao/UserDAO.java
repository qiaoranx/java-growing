package com.company.dao;

import com.company.entity.User;
import com.company.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private JDBCUtil jdbcUtil=new JDBCUtil();

    /**
     * 添加用户
     * @param user
     * @return
     */
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

    /**
     * 登录验证
     * @param user
     * @return
     */
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

    /**
     * 分页逻辑查询
     * @return
     */
    public List<User> pageQuery(){
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<User> bigList=new ArrayList<User>();
        try {
            con= jdbcUtil.getConnection();
            String sql="select usercode,username,orgtype from t_user order by regdate desc";
            ps= con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                User user=new User();
                user.setUserCode(rs.getString("usercode"));
                user.setUserName(rs.getString("username"));
                user.setOrgType(rs.getString("orgtype"));
                bigList.add(user);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbcUtil.close(con,ps,rs);
        }
        return bigList;
    }

    /**
     * 物理分页查询
     * @param pagesize
     * @param pageNum
     * @return
     */
    public List<User> pageDivQuery(int pagesize,int pageNum){
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<User> userList=new ArrayList<User>();
        try {
            con=jdbcUtil.getConnection();
            String sql="select * from t_user order by regdate desc limit ? offset ?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,pagesize);
            ps.setInt(2,(pageNum-1)*pagesize);
            rs= ps.executeQuery();
            while(rs.next()){
                User user=new User();
                user.setUserCode( rs.getString("usercode"));
                user.setUserName( rs.getString("username"));
                user.setOrgType( rs.getString("orgtype"));
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbcUtil.close(con,ps,rs);
        }
        return userList;
    }

    /**
     * 查询总信息条数
     * @return
     */
    public int seqQuery(){
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int totalcount=0;
        try {
            con=jdbcUtil.getConnection();
            String sql="select count(*) as totalcount from t_user";
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                totalcount=rs.getInt("totalcount");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbcUtil.close(con,ps,rs);
        }
        return totalcount;
    }

    /**
     * 根据usercode查询user
     * @param usercode
     * @return
     */
    public User selectUser(String usercode){
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        User user=new User();
        String sql="select * from t_user where usercode=?";
        try {
            con=jdbcUtil.getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1,usercode);
            rs= ps.executeQuery();
            if(rs.next()){
                user.setUserName(rs.getString("username"));
                user.setUserPwd(rs.getString("userpwd"));
                user.setOrgType(rs.getString("orgtype"));
                user.setUserCode(rs.getString("usercode"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbcUtil.close(con,ps,rs);
        }
           return user;
    }
}
