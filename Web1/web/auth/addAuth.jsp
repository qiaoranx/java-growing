<%@ page import="com.company.entity.Enterprise" %>
<%@ page import="com.company.util.PropertyUtil" %><%--
  Created by IntelliJ IDEA.
  User: xiang
  Date: 2020/8/2
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Enterprise enp=(Enterprise)request.getAttribute("enp");
    String orgcode=request.getParameter("orgcode");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<font style="color: forestgreen;font-size: 20px">资本金账户开户核准信息</font><br/>
组织机构代码：<input readonly type="text" value="<%=orgcode%>"><br/>
企业中文名称：<input readonly type="text" value="<%=enp.getCnname()%>" ><br/>
限额币种：<input readonly type="text" value="<%=PropertyUtil.proUtil(enp.getRegtype()) %>" ><br/>
账户限额：<input readonly  type="text" value="<%=enp.getOutregcap()%>"><br/>
<font style="color: forestgreen;font-size: 20px">核准件其他信息</font><br/>
联系人：<input  type="text" ><br/>
联系电话：<input  type="text" ><br/>
备注：<input readonly type="text" ><br/>
<font style="color: forestgreen;font-size: 20px">文件信息</font><br/>
验资文件：<input  type="text">&nbsp;&nbsp;<input type="button" value="浏览..."><br/>
备注：<input  type="text" ><br/>

<br/><input type="submit" value="确认">
<input type="button" value="返回">
</body>
</html>
