<%@ page import="com.company.entity.User" %>
<%@ page import="com.company.util.PropertyUtil" %><%--
  Created by IntelliJ IDEA.
  User: xiang
  Date: 2020/7/27
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
   User user=(User)session.getAttribute("user");
   String usercode=user.getUserCode();
   String orgtype=PropertyUtil.proUtil(user.getOrgType());
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="button" value="个人信息修改" >
<input type="button" onclick="logout()" value="退出" >
<span style="color: black;font-size: 15px">当前登录用户：<%=usercode%>&nbsp;&nbsp;机构类型：<%=orgtype%></span>
</body>
</html>
<script type="text/javascript">
    function logout() {
        top.location.href = "http://localhost:80/EGOV/logout";
    }
</script>
