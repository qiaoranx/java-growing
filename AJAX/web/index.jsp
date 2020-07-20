<%--
  Created by IntelliJ IDEA.
  User: xiang
  Date: 2020/7/20
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>全局刷新</title>
  </head>
  <body>
  <p>全局刷新bmi</p>
  <form action="/AJAX_war_exploded/BMIServlet" method="get">
姓名：<input type="text" name="name"/><br/>
  体重：  <input type="text" name="h"/><br/>
  身高： <input type="text" name="w"/><br/>
    <input type="submit" value="提交">

  </form>
  </body>
</html>
