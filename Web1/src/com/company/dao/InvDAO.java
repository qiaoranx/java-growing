package com.company.dao;

import com.company.entity.Investor;
import com.company.entity.User;
import com.company.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvDAO {

    /**
     * 添加投资人
     * @param inv
     * @return
     */
    public int addInvestor(Investor inv){
        Connection con=null;
        PreparedStatement ps=null;
        int res=0;
        String sql="insert into t_inv(invname,cty,orgcode,contactman,contacttel,email,remark,usercode,regdate) " +
                "values(?,?,?,?,?,?,?,?,?)";
        try {
            con=JDBCUtil.getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1,inv.getInvname());
            ps.setString(2,inv.getCty());
            ps.setString(3,inv.getOrgcode());
            ps.setString(4,inv.getContactman());
            ps.setString(5,inv.getContacttel());
            ps.setString(6,inv.getEmail());
            ps.setString(7,inv.getRemark());
            ps.setString(8,inv.getUsercode());
            ps.setString(9,inv.getRegdate());
            res= ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(con,ps,null);
        }
        return res;
    }

    /**
     * 查询投资人
     * @return
     */
    public List<Investor> queryInv(String invregnum,String invname,String regdate1,String regdate2){
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Investor> lst=new ArrayList<>();
        //联表sql
        StringBuilder sql=new StringBuilder("select i.invregnum,i.invname,i.regdate,i.cty,u.username from t_inv as i join t_user as u on i.usercode=u.usercode where 1=1 ");
        //动态条件查询
        List<String> paraLst=new ArrayList<>();
        if(invregnum!=null&&invregnum.trim().length()!=0){
            paraLst.add(invregnum);
            sql.append("and i.invregnum=?");
        }
        if(invname!=null&&invname.trim().length()!=0){
            paraLst.add("%"+invname+"%");
            sql.append("and i.invname like ?");//模糊查询
        }
        if(regdate1!=null&&regdate1.trim().length()!=0){
            paraLst.add(regdate1);
            sql.append("and i.regdate>=?");
        }
        if(regdate2!=null&&regdate2.trim().length()!=0){
            paraLst.add(regdate2);
            sql.append("and i.regdate<=?");
        }
        sql.append("order by i.regdate desc");

        try {
            con=JDBCUtil.getConnection();
            ps= con.prepareStatement(sql.toString());
            int i=1;
            for (String s : paraLst) {
                ps.setString(i,s);
                i++;
            }
            rs= ps.executeQuery();
            while (rs.next()){
                Investor inv=new Investor();
                inv.setUsername(rs.getString("username"));
                inv.setCty(rs.getString("cty"));
                inv.setInvname(rs.getString("invname"));
                inv.setRegdate(rs.getString("regdate"));
                inv.setInvregnum(rs.getInt("invregnum"));
                lst.add(inv);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(con,ps,rs);
        }
        return lst;
    }

    public Investor invByNum(String invregnum){
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Investor inv=new Investor();
        String sql="select * from t_inv where invregnum=?";
        try {
            con=JDBCUtil.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1,invregnum);
            rs= ps.executeQuery();
            while (rs.next()){
                inv.setInvname(rs.getString("invname"));
                inv.setCty(rs.getString("cty"));
                inv.setOrgcode(rs.getString("orgcode"));
                inv.setContactman(rs.getString("contactman"));
                inv.setContacttel(rs.getString("contacttel"));
                inv.setEmail(rs.getString("email"));
                inv.setRemark(rs.getString("remark"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(con,ps,rs);
        }
        return inv;
    }
}
