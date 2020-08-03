<%@ page import="com.company.entity.Enterprise" %>
<%@ page import="java.util.List" %>
<%@ page import="com.company.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: xiang
  Date: 2020/8/1
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Enterprise> lst=(List<Enterprise>)request.getAttribute("orgLst");
//  String StrJson=(String)request.getAttribute("json");
%>
<html>
<head>
    <title>企业查询</title>
    <script src="https://cdn.staticfile.org/echarts/4.3.0/echarts.min.js"></script>
</head>
<body>
<div id="pie" style="width: 300px;height: 300px;position: absolute;top:50px;left: 550px "></div>
<input type="button" value="查询" onclick="queryOrg()"/><br/><br/>
<table border="1">
    <tr>
        <td>序号</td>
        <td>组织机构代码</td>
        <td>企业中文名称</td>
        <td>登记日期</td>
        <td>经办人</td>
        <td>投资比例</td>
    </tr>
    <tbody>
    <%
        if(lst!=null){
            int i=0;
            for (Enterprise enp : lst) {
    %>
    <tr>
        <td><%=++i%></td>
        <td><span style="cursor: hand" onclick="window.opener.getOrgcode('<%=enp.getOrgcode()%>')"><%=enp.getOrgcode()%></span></td>
        <td><%=enp.getCnname()%></td>
        <td><%=enp.getRegdate()%></td>
        <td><%=enp.getUsername()%></td>
        <td><span style="cursor: hand" onmouseenter="displayPieCharts('<%=enp.getOrgcode()%>')" onmouseout="clearCharts()">详细</span></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
</body>
</html>
<script type="text/javascript">
    function queryOrg() {
        window.location.href = "http://localhost:80/EGOV/queryOrg";
    }

    function clearCharts(){
        document.getElementById("pie").style.visibility="hidden";
    }

    function displayPieCharts(orgcode) {
        //
        var res=[];
        var xmlHttp=new XMLHttpRequest();
        xmlHttp.onreadystatechange=function () {
            if(xmlHttp.readyState==4&&xmlHttp.status==200){
               var jsonStr=xmlHttp.responseText;
                var arr=jsonStr.split(";");
                for(var i=0;i< arr.length;i++){
                  var pair= arr[i].split(",");
                  var item={
                       name:pair[0],
                       value:pair[1]
                   }
                   res.push(item);
                }
            }
        }
        //避免get缓存
        xmlHttp.open("get","/EGOV/queryPie?_"+new Date().getTime()+"&orgcode="+orgcode,false);
        xmlHttp.send();

        //

        document.getElementById("pie").style.visibility="visible";
        var myChart = echarts.init(document.getElementById("pie"));
        myChart.setOption({
            series : [
                {
                    name: '访问来源',
                    type: 'pie',    // 设置图表类型为饼图
                    radius: '55%',  // 饼图的半径，外半径为可视区尺寸（容器高宽中较小一项）的 55% 长度。
                    data:res
                }
            ]
        })

    }
</script>