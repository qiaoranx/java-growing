<%--
  Created by IntelliJ IDEA.
  User: xiang
  Date: 2020/7/27
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String msg=(String)request.getAttribute("loginError");
%>
<html>
<head>
    <title>登录</title>
</head>
<body>
<%
    if(msg!=null){
        %>
<div style="font-size: 17px;color: red"><%=msg%></div>
<%
    }
%>
<img>
<form action="/EGOV/login" method="post">
    机构类型：<select name="orgType">
    <option value =""></option>
    <option value ="0">外汇局</option>
    <option value ="1">银行</option>
</select>
    <br/>
    用户代码：<input type="text" name="loginName">
    <br/>
    密码：<input type="password" name="loginPwd">
    <br/>
    <input type="submit" value="登录">
    <input type="reset" value="取消">
</form>
</div>
</body>
</html>
