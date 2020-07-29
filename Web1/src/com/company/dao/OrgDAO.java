package com.company.dao;

import com.company.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrgDAO {
    private JDBCUtil jdbcUtil=new JDBCUtil();
    public int queryOrgcode(String orgcode){
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int res=0;
        try {
            con= jdbcUtil.getConnection();
            String sql="select * from t_enterprise where orgcode=?";
            ps= con.prepareStatement(sql);
            ps.setString(1,orgcode);
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
