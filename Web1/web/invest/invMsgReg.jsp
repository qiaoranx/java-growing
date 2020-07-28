<%@ page import="com.company.entity.Investor" %>
<%@ page import="java.util.List" %>
<%@ page import="com.company.util.PropertyUtil" %><%--
  Created by IntelliJ IDEA.
  User: xiang
  Date: 2020/7/27
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
     List<Investor> invLst=(List<Investor>)request.getAttribute("invLst");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<img>
<form action="/EGOV/queryInv" method="post" target="section" name="queryForm">
<%--三元运算解决查询后丢失搜索条件的问题--%>
    投资人登记编号：<input type="text" id="invRegNum" name="invregnum" value=<%=request.getParameter("invregnum")==null?"":request.getParameter("invregnum")%>><br/>
    投资人名称：<input type="text" id="invname" name="invname"><br/>
    登记日期：<input type="text" id="regdate1" name="regdate1">
    <img src="/EGOV/img/calendar.png" width="20" height="20"/>
    ~<input type="text" id="regdate2" name="regdate2">
    <img src="/EGOV/img/calendar.png" width="20" height="20"/><br/>
    <input type="button" onclick="GoinvAdd()" value="新增"><input type="button" onclick="QueryInv()"  value="查询"><input type="button" value="清除">
</form>
<table border="1">
    <tr>
        <td>序号</td>
        <td>投资人登记编号</td>
        <td>投资人名称</td>
        <td>登记日期</td>
        <td>国别</td>
        <td>经办人</td>
    </tr>
    <tbody id="tableBody" >
    <%
        if(invLst!=null){
            int i=0;
            for (Investor investor : invLst) {
    %>
    <tr>
        <td><%=++i%></td>
        <td>GB<span style="cursor: hand" onclick="GoInvDetail(this.innerText)"><%=investor.getInvregnum()%></span></td>
        <td><%=investor.getInvname()%></td>
        <td><%=investor.getRegdate()%></td>
        <td><%=PropertyUtil.proUtil(investor.getCty())%></td>
        <td><%=investor.getUsername()%></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
</div>
</body>
</html>
<script type="text/javascript">
    function GoinvAdd() {
        window.location.href = "http://localhost:80/EGOV/invest/invAdd.jsp";
        window.location.href.target = "section";
    }

    function QueryInv() {
        document.forms["queryForm"].action="/EGOV/queryInv";
        document.forms["queryForm"].method="post";
        document.forms["queryForm"].submit();
        document.forms["queryForm"].target="section";
    }

    function GoInvDetail(invregnum) {
        window.location.href = "http://localhost:80/EGOV/goInvDetail?invregnum="+invregnum;
        window.location.href.target = "section";
    }


</script>