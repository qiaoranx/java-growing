package com.company.dao;

import com.company.entity.Province;
import com.company.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProvinceDAO {
    public String queryProvinceNameById(Integer provinceId){
        JDBCUtil util=new JDBCUtil();
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String proName="";
        try {
            con= util.getConnection();
            String sql="select name from province where id=?";
            ps= con.prepareStatement(sql);
            ps.setInt(1,provinceId);
            rs= ps.executeQuery();
//           while(rs.next()){
//              proName= rs.getString("name");
//           }
            if(rs.next()){
                proName= rs.getString("name");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close(con,ps,rs);
        }
        return  proName;
    }

    public Province queryProvinceById(Integer provinceId){
        JDBCUtil util=new JDBCUtil();
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Province pro=null;
        try {
            con= util.getConnection();
            String sql="select * from province where id=?";
            ps= con.prepareStatement(sql);
            ps.setInt(1,provinceId);
            rs= ps.executeQuery();
           if(rs.next()){
               pro=new Province();
              pro.setId(rs.getInt("Id"));
               pro.setName(rs.getString("name"));
               pro.setJiancheng(rs.getString("jiancheng"));
               pro.setShenghui(rs.getString("shenghui"));
           }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close(con,ps,rs);
        }
        return  pro;
    }
}
