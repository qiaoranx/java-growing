<%--
  Created by IntelliJ IDEA.
  User: xiang
  Date: 2020/7/29
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String outMsg=(String) request.getAttribute("out");
    String orgcodeMsg=request.getParameter("orgcode");

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if(outMsg!=null){
        %>
<span style="color:red;font-size:17px"><%=outMsg%></span>
<%
    }
%>
<form action="/EGOV/queryOrg">
    组织机构代码：<input type="text" name="orgcode" value="<%=orgcodeMsg!=null?orgcodeMsg:""%>"><br/>
    <input type="submit" value="确定">
</form>

</body>
</html>
<script>

</script>
