<%@ page import="com.company.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="com.company.util.PropertyUtil" %><%--
  Created by IntelliJ IDEA.
  User: xiang
  Date: 2020/7/23
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<User> userList=(List<User>) request.getAttribute("userList");
    int totalCount=(int)request.getAttribute("totalCount");
    int totalPage= (int)request.getAttribute("totalPage");
    int pageSize=  (int)request.getAttribute("pageSize");
    int curPage=Integer.parseInt( request.getParameter("pageNum")) ;


%>
<html>
<head>
    <title>title</title>
</head>
<body>
<div>
    <input type="button" id="addUser" value="添加用户">
</div><br/>
<script type="text/javascript">
    window.onload=function () {
        document.getElementById("addUser").onclick=function () {
            window.location.href="http://localhost:80/EGOV/addUser.html";
            window.location.href.target="section";
        }

    }
</script>
<table border="1">
    <tr>
        <td>选择</td>
        <td>序号</td>
        <td>用户代码</td>
        <td>用户名</td>
        <td>用户机构</td>
    </tr>
    <%
        int i=0;
        for (User user : userList) {
    %>
    <tr>
        <td><input type="checkbox"></td>
        <td><%=++i%></td>
        <td><%=user.getUserCode()%></td>
        <td><%=user.getUserName()%></td>
        <td><%=PropertyUtil.proUtil(user.getOrgType()).replace("\"","")%></td>
    </tr>
    <%
        }
    %>
</table>
<font style="font-size: 20px;color: black">共<%=totalCount%>条记录，当前第<%=curPage%>/<%=totalPage%>页，每页<%=pageSize%>条记录</font>

</body>
</html>
