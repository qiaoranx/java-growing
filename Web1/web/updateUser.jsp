<%@ page import="com.company.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: xiang
  Date: 2020/7/24
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user=(User)request.getAttribute("user");
    System.out.println(user.getOrgType());
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="updateUser">
    <form action="/EGOV/updateUser" target="section">
        用户代码：<input type="text" name="usercode" value="<%=user.getUserCode()%>" disabled="true"><br/>
        用户姓名：<input type="text" name="username" value="<%=user.getUserName()%>"><br/>
        用户密码：<input type="password" name="userpwd" value="<%=user.getUserPwd()%>"><br/>
        机构类型：<select name="orgType" >
        <option value =""></option>
        <option value ="0" selected=<%=Integer.parseInt(user.getOrgType())==0?"selected":""%>>外汇局</option>
        <option value ="1" <%=Integer.parseInt(user.getOrgType())==1?"selected":""%>>银行</option>
    </select><br/><br/>
        <input type="submit" value="保存">
        <input type="reset" value="清除" >
    </form>
</div>
</body>
</html>
