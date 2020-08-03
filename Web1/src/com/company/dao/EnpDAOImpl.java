package com.company.dao;

import com.company.entity.Enterprise;
import com.company.entity.OrgInv;
import com.company.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnpDAOImpl implements EnpDAO {

   public int[] AddEnp(Enterprise enp, List<OrgInv> lst){
       Connection con=null;
       PreparedStatement ps=null;
       int res1=0;
       int[] res2=new int[10];
       int size=0;
       try {
           con= JDBCUtil.getConnection();
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
       } catch (Exception throwables) {
           throwables.printStackTrace();
           throw new RuntimeException("添加企业失败");
       }finally {
           JDBCUtil.close(null,ps,null);
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
            throw new RuntimeException("查询组织机构代码失败");
        }finally {
            JDBCUtil.close(null,ps,rs);
        }
        return res;
    }

    public List<Enterprise> queryOrg(){
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Enterprise> lst=new ArrayList<>();
        try {
            con= JDBCUtil.getConnection();
            String sql="select e.orgcode,e.cnname,e.regdate,u.username from t_enterprise e join t_user u on e.usercode=u.usercode";
            ps= con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Enterprise enp=new Enterprise();
                enp.setOrgcode(rs.getString("orgcode"));
                enp.setCnname(rs.getString("cnname"));
                enp.setRegdate(rs.getString("regdate"));
//                enp.setRegtype(rs.getString("regtype"));
                enp.setUsername(rs.getString("username"));
                lst.add(enp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("查询企业信息失败");
        }finally {
            JDBCUtil.close(null,ps,rs);
        }
        return lst;
    }

    @Override
    public String queryPie(String orgcode) {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        StringBuilder str=new StringBuilder();
        try {
            con= JDBCUtil.getConnection();
            String sql="select o.regmoneyout,i.invname from t_orginv o join t_inv i on o.invregnum=i.invregnum where o.orgcode=?";
            ps= con.prepareStatement(sql);
            ps.setString(1,orgcode);
            rs=ps.executeQuery();
            while (rs.next()){
               str.append(rs.getString("invname")+","+rs.getString("regmoneyout")+";");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("查询企业投资明细失败");
        }finally {
            JDBCUtil.close(null,ps,rs);
        }
        str.deleteCharAt(str.length()-1);
        System.out.println(str.toString());
        return str.toString();
    }
}
