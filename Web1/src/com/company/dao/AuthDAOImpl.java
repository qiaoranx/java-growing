package com.company.dao;

import com.company.entity.Enterprise;
import com.company.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class AuthDAOImpl implements AuthDAO {
    @Override
    public int saveAuth(Map<String, String> map) {
        Connection con=null;
        PreparedStatement ps=null;
        int res=0;
        try {
            con= JDBCUtil.getConnection();
            String sql="insert into t_veri(orgcode,remark,contactman,contacttel,filename,fileremark,usercode,feedback) values(?,?,?,?,?,?,?,'0')";
            ps= con.prepareStatement(sql);
            ps.setString(1,map.get("orgcode"));
            ps.setString(2,map.get("remark"));
            ps.setString(3,map.get("contactman"));
            ps.setString(4,map.get("contacttel"));
            ps.setString(5,map.get("filename"));
            ps.setString(6,map.get("fileremark"));
            ps.setString(7,map.get("usercode"));
            res=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("核准件保存失败");
        }finally {
            JDBCUtil.close(null,ps,null);
        }
        return res;
    }
}
