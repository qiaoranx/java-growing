package com.company.model;

import com.company.entity.Enterprise;
import com.company.entity.OrgInv;

import java.util.List;

public interface EnterpriseService {
    int[] save(Enterprise en, List<OrgInv> lst);
    Enterprise queryOrgcode(String orgcode);
    List<Enterprise> queryOrg();
    String queryPie(String orgcode);
}
