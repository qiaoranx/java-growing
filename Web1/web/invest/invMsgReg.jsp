<%--
  Created by IntelliJ IDEA.
  User: xiang
  Date: 2020/7/27
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<img>
    投资人登记编号：<input type="text" id="invRegNum"><br/>
    投资人名称：<input type="text" id="invname"><br/>
    登记日期：<input type="text" id="regdate1">
    <img src="/EGOV/img/calendar.png" width="20" height="20"/>
    ~<input type="text" id="regdate2">
    <img src="/EGOV/img/calendar.png" width="20" height="20"/><br/>
    <input type="button" onclick="GoinvAdd()" value="新增"><input type="button" value="查询"><input type="button" value="清除">
    <table>

    </table>
</div>
</body>
</html>
<script type="text/javascript">
    function GoinvAdd() {
        window.location.href = "http://localhost:80/EGOV/invest/invAdd.jsp";
        window.location.href.target = "section";
    }
</script>