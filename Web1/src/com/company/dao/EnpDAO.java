package com.company.dao;

import com.company.entity.Enterprise;
import com.company.entity.OrgInv;
import com.company.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EnpDAO {

   public int[] AddEnp(Enterprise enp, List<OrgInv> lst){
       Connection con=null;
       PreparedStatement ps=null;
       int res1=0;
       int[] res2=new int[10];
       int size=0;
       try {

           con= JDBCUtil.getConnection();
           con.setAutoCommit(false);
           con.setTransactionIsolation(2);
           String sql="insert into t_enterprise(orgcode,regno,cnname,enname,contactman,contacttel,outregcap,foreiregmoney," +
                   "regtype,usercode,regdate) values(?,?,?,?,?,?,?,?,?,?,?) ";
           ps= con.prepareStatement(sql);
           ps.setString(1,enp.getOrgcode());
           ps.setString(2,enp.getRegno());
           ps.setString(3,enp.getCnname());
           ps.setString(4,enp.getEnname());
           ps.setString(5,enp.getContactman());
           ps.setString(6,enp.getContacttel());
           ps.setBigDecimal(7,enp.getOutregcap());
           ps.setBigDecimal(8,enp.getForeiregmoney());
           ps.setString(9,enp.getRegtype());
           ps.setString(10,enp.getUsercode());
           ps.setString(11,enp.getRegdate());
           res1= ps.executeUpdate();
           res2[size]=res1;
           size++;
           sql="insert into t_orginv(orgcode,invregnum,regmoneyout,percent) values(?,?,?,?) ";
           ps= con.prepareStatement(sql);
           /**
            * addBatch不能把ps的预编译放在循环里
            */
           for (OrgInv orgInv : lst) {
               ps.setString(1,orgInv.getOrgcode());
               ps.setInt(2,orgInv.getInvregnum());
               ps.setBigDecimal(3,orgInv.getRegmoneyout());
               ps.setBigDecimal(4,orgInv.getPercent());
               ps.addBatch();
           }
           for (int i : ps.executeBatch()) {
               res2[size]=i;
               size++;
           }
           con.commit();
       //提交事务
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
           JDBCUtil.close(con,ps,null);
       }
       return res2;
   }

    public int queryOrgcode(String orgcode){
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int res=0;
        try {
            con= JDBCUtil.getConnection();
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
            JDBCUtil.close(con,ps,rs);
        }
        return res;
    }
}
