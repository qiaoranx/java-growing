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
