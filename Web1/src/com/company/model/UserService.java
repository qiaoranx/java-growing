package com.company.model;

import com.company.dao.UserDAO;
import com.company.entity.User;
import com.company.util.JDBCUtil;
import com.company.util.WebUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class UserService {
    private static UserDAO dao=new UserDAO();

    public  int addUserService(User user)  {

        //创建事务
        Connection con=null;
        int res=0;
        try {
            con= JDBCUtil.getConnection();
            con.setAutoCommit(false);
            con.setTransactionIsolation(2);
            User u=dao.selectUser(user.getUsercode());
            if(u!=null){
                res=-1;
                return res;
            }
            res = dao.addUser(user);
            con.commit();
        } catch (SQLException throwables) {
            try {
                con.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            JDBCUtil.close(con,null,null);
        }
        return res;
    }
}
