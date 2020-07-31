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

    /**
     * 添加用户
     * @param user
     * @return
     */
    public int addUser(User user)  {
        Connection con=null;
        PreparedStatement ps=null;
        int res=0;
        try {
            con= JDBCUtil.getConnection();
            String sql="insert into t_user(usercode,username,userpwd,orgtype,regdate) values(?,?,?,?,?)";
            ps= con.prepareStatement(sql);
            ps.setString(1,user.getUsercode());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getUserpwd());
            ps.setString(4, user.getOrgtype());
            ps.setString(5, user.getRegdate());
            res=ps.executeUpdate();
            JDBCUtil.close(null,ps,null);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("添加失败");
        }finally {
            JDBCUtil.close(null,ps,null);
        }
        return res;
    }

    /**
     * 判断用户代码唯一性
     * @param usercode
     * @return
     */
    public int verifyUsercode(String usercode){
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int res=0;
        try {
            con= JDBCUtil.getConnection();
            String sql="select * from t_user where usercode=?";
            ps= con.prepareStatement(sql);
            ps.setString(1,usercode);
            rs= ps.executeQuery();
            while (rs.next()){
                res++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(null,ps,rs);
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
            con= JDBCUtil.getConnection();
            //where子句先查第一个条件（mysql）
            String sql="select * from t_user where usercode=? and userpwd=? and orgtype=?";
            ps= con.prepareStatement(sql);
            ps.setString(1, user.getUsercode());
            ps.setString(2, user.getUserpwd());
            ps.setString(3, user.getOrgtype());
            rs=ps.executeQuery();
            while (rs.next()){
                res++;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(con,ps,rs);
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
            con= JDBCUtil.getConnection();
            String sql="select usercode,username,orgtype from t_user order by regdate desc";
            ps= con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                User user=new User();
                user.setUsercode(rs.getString("usercode"));
                user.setUsername(rs.getString("username"));
                user.setOrgtype(rs.getString("orgtype"));
                bigList.add(user);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(con,ps,rs);
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
            con=JDBCUtil.getConnection();
            String sql="select * from t_user order by regdate desc limit ? offset ?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,pagesize);
            ps.setInt(2,(pageNum-1)*pagesize);
            rs= ps.executeQuery();
            while(rs.next()){
                User user=new User();
                user.setUsercode( rs.getString("usercode"));
                user.setUsername( rs.getString("username"));
                user.setOrgtype( rs.getString("orgtype"));
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(con,ps,rs);
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
            con=JDBCUtil.getConnection();
            String sql="select count(*) as totalcount from t_user";
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                totalcount=rs.getInt("totalcount");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(con,ps,rs);
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
            con=JDBCUtil.getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1,usercode);
            rs= ps.executeQuery();
            if(rs.next()){
                user.setUsername(rs.getString("username"));
                user.setUserpwd(rs.getString("userpwd"));
                user.setOrgtype(rs.getString("orgtype"));
                user.setUsercode(rs.getString("usercode"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(con,ps,rs);
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
            con= JDBCUtil.getConnection();
            String sql="update t_user set username=?,userpwd=?,orgtype=? where usercode=?";
            ps= con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getUserpwd());
            ps.setString(3, user.getOrgtype());
            ps.setString(4, user.getUsercode());
            res=ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(con,ps,null);
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

            con= JDBCUtil.getConnection();
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
            JDBCUtil.close(con,ps,null);
        }
        return res;
    }

}
