package com.company.dao;

import com.company.entity.Enterprise;
import com.company.entity.OrgInv;

import java.util.List;

public interface EnpDAO {
    int[] AddEnp(Enterprise enp, List<OrgInv> lst);
     Enterprise queryOrgcode(String orgcode);
     List<Enterprise> queryOrg();
     String queryPie(String orgcode);
}
