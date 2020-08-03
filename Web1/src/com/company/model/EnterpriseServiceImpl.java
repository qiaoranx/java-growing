package com.company.model;

import com.company.dao.EnpDAO;
import com.company.dao.EnpDAOImpl;
import com.company.entity.Enterprise;
import com.company.entity.OrgInv;
import com.company.util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EnterpriseServiceImpl implements EnterpriseService {
    private static EnpDAO enpDAO=new EnpDAOImpl();

    @Override
    public String queryPie(String orgcode) {
        Connection con=null;
        String str=null;
        try {
            con= JDBCUtil.getConnection();
            con.setAutoCommit(false);
            con.setTransactionIsolation(2);
            str=enpDAO.queryPie(orgcode);
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
        return str;

    }

    @Override
    public List<Enterprise> queryOrg() {
        Connection con=null;
        List<Enterprise> lst=null;
        try {
            con= JDBCUtil.getConnection();
            con.setAutoCommit(false);
            con.setTransactionIsolation(2);
            lst=enpDAO.queryOrg();
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
        return lst;

    }

    @Override
    public Enterprise queryOrgcode(String orgcode) {
        Connection con=null;
        Enterprise enp=new Enterprise();
        try {
            con= JDBCUtil.getConnection();
            con.setAutoCommit(false);
            con.setTransactionIsolation(2);
            enp=enpDAO.queryOrgcode(orgcode);
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
        return enp;

    }

    @Override
    public int[] save(Enterprise en, List<OrgInv> lst) {
        Connection con=null;
        int[] res=null;
        try {
           con= JDBCUtil.getConnection();
           con.setAutoCommit(false);
           con.setTransactionIsolation(2);
            res=enpDAO.AddEnp(en,lst);
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

       return res;
    }
}
