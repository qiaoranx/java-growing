<%@ page import="com.company.entity.Investor" %>
<%@ page import="com.company.util.PropertyUtil" %><%--
  Created by IntelliJ IDEA.
  User: xiang
  Date: 2020/7/28
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
Investor inv=(Investor) request.getAttribute("inv");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
投资人名称：<input type="text" readonly value="<%=inv.getInvname()%>"><br/>
所属国家：<input type="text" readonly value="<%=PropertyUtil.proUtil(inv.getCty())%>"><br/>
组织机构代码：<input type="text" readonly value="<%=inv.getOrgcode()%>"><br/>
联系人：<input type="text" readonly value="<%=inv.getContactman()%>"><br/>
联系电话：<input type="text" readonly value="<%=inv.getContacttel()%>"><br/>
电子邮箱：<input type="text" readonly value="<%=inv.getEmail()%>"><br/>
备注：<input type="text" readonly value="<%=inv.getRemark()%>"><br/>
<input type="button" value="返回" onclick="Back()">
</body>
</html>
<script type="text/javascript">
    function Back() {
        window.location.href = "http://localhost:80/EGOV/invest/invMsgReg.jsp";
        window.location.href.target = "section";
    }
</script>
