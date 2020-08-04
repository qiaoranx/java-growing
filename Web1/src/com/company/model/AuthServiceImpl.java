package com.company.model;

import com.company.dao.AuthDAO;
import com.company.dao.AuthDAOImpl;
import com.company.util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public class AuthServiceImpl implements AuthService {

    AuthDAO dao=new AuthDAOImpl();
    @Override
    public boolean saveAuth(Map<String, String> map) {
        Connection con=null;
        int res=0;
        try {
            con= JDBCUtil.getConnection();
            con.setAutoCommit(false);
            con.setTransactionIsolation(2);
            res=dao.saveAuth(map);
            con.commit();
        } catch (Exception throwables) {
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
            JDBCUtil.close(con,null,null);
        }

        return res==1;
    }
}

