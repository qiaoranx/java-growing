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
        List<User> userList=new ArrayList<>();
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

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public int updateUser(User user){
        Connection con=null;
        PreparedStatement ps=null;
        int res=0;
        try {
            con= jdbcUtil.getConnection();
            String sql="update t_user set username=?,userpwd=?,orgtype=? where usercode=?";
            ps= con.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getUserPwd());
            ps.setString(3, user.getOrgType());
            ps.setString(4, user.getUserCode());
            res=ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbcUtil.close(con,ps);
        }
        return res;
    }

    /**
     * 删除用户
     * @param usercodes
     * @return
     */
    public int deleteUser(String[] usercodes){
        Connection con=null;
        PreparedStatement ps=null;
        int res=0;
        try {

            con= jdbcUtil.getConnection();
            con.setAutoCommit(false);
            con.setTransactionIsolation(2);
            //开始事务
            String sql="delete from t_user where usercode = ?" ;
            ps= con.prepareStatement(sql);
            //进程之间的交互耗时
            //批处理
            for (int i = 0; i <usercodes.length ; i++) {
                ps.setString(1,usercodes[i]);
//                ps.executeUpdate();
                ps.addBatch();
                res++;
            }
            ps.executeBatch();
            con.commit();
            //结束事务
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            jdbcUtil.close(con,ps);
        }
        return res;
    }

}
