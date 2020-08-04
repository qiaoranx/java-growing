<%@ page import="com.company.entity.Enterprise" %>
<%@ page import="com.company.util.PropertyUtil" %>
<%@ page import="com.company.entity.User" %><%--
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
   String usercode=((User)session.getAttribute("user")).getUsercode();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/EGOV/saveAuth" method="post" enctype="multipart/form-data">
<font style="color: forestgreen;font-size: 20px">资本金账户开户核准信息</font><br/>
 <input type="hidden" name="usercode" value="<%=usercode%>">
组织机构代码：<input readonly type="text" name="orgcode" value="<%=orgcode%>"><br/>
企业中文名称：<input readonly type="text"  value="<%=enp.getCnname()%>" ><br/>
限额币种：<input readonly type="text" value="<%=PropertyUtil.proUtil(enp.getRegtype()) %>" ><br/>
账户限额：<input readonly  type="text" value="<%=enp.getOutregcap()%>"><br/>
<font style="color: forestgreen;font-size: 20px">核准件其他信息</font><br/>
联系人：<input name="contactman" type="text" ><br/>
联系电话：<input name="contacttel" type="text" ><br/>
备注：<input name="remark"  type="text" ><br/>
<font style="color: forestgreen;font-size: 20px">文件信息</font><br/>
验资文件：<input  type="file" name="filename"><br/>
备注：<input name="fileremark" type="text" ><br/>
<br/><input type="submit" value="确认">
<input type="button" onclick="goBack()" value="返回">
</form>
</body>

</html>
<script type="text/javascript">
    function goBack() {
           window.location.href="http://localhost:80/EGOV/auth/goAddAuth.jsp"
    }
</script>
