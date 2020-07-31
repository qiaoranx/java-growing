<%@ page import="com.company.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: xiang
  Date: 2020/7/29
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
 User user=(User)session.getAttribute("user");
 String usercode=user.getUsercode();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/EGOV/saveOrg" method="post">
    <font style="color: forestgreen;font-size: 20px">企业基本信息</font><br/>
    <input type="hidden" name="usercode" value="<%=usercode%>">
    组织机构代码：<input readonly type="text" name="orgcode" value="<%=request.getParameter("orgcode")%>"><br/>
    外汇登记证号：<input type="text" name="regno"><br/>
    企业中文名称：<input type="text" name="cnname"><br/>
    企业英文名称：<input type="text" name="enname"><br/>
    联系人：<input type="text" name="contactman"><br/>
    联系电话：<input type="text" name="contacttel"><br/>
    <font style="color: forestgreen;font-size: 20px">企业资金情况信息</font><br/>
    注册资本：<input readonly type="text" name="outregcap" id="outregcap"><br/>
    注册币种：<select name="regtype">
    <option ></option>
    <option value="00r">人民币</option>
    <option value="01r">美元</option>
    <option value="02r">英镑</option>
    <option value="03r">日元</option>
</select><br/>
    外方注册资本：<input readonly type="text" name="foreiregmoney" id="foreiregmoney"><br/>
    外方出资比例：<input readonly type="text" id="outpercent" value="0"><span >%</span><br/>
    <font style="color: forestgreen;font-size: 20px">投资者资金及利润分配</font><br/>
    <table id="invListTable" border="1">
        <tr>
            <td>投资者名称</td>
            <td>国别</td>
            <td>注册资本出资额</td>
            <td>利润分配比例</td>
            <td><input type="button" value="查询" onclick="goQuery()"></td>
        </tr>
    </table>

    <br/><input type="submit" value="确认">
    <input type="button" value="返回">
</form>
</body>
</html>
<script type="text/javascript">
    function goQuery() {
        window.open("http://localhost:80/EGOV/invest/selectInv.jsp","selectInv","width=800,height=400");
    }
    function addNewLine(invregnum,invname,cty) {
        var invListTable=document.getElementById("invListTable");
        var index=invListTable.rows.length;
        var tableRow=invListTable.insertRow(index);
        tableRow.id=invregnum;
        var tableCell0=tableRow.insertCell(0);
        var tableCell1=tableRow.insertCell(1);
        var tableCell2=tableRow.insertCell(2);
        var tableCell3=tableRow.insertCell(3);
        var tableCell4=tableRow.insertCell(4);
        tableCell0.innerHTML="<div>"+invname+"</div><input type='hidden' name='invregnum' value='"+invregnum+"'/>"
        tableCell1.innerHTML="<div><input type='hidden' name='cty' value='"+cty+"'>"+cty+"</div>"
        tableCell2.innerHTML='<input type="text" name="regmoneyout"  onblur="calCap()"/>'
        tableCell3.innerHTML="<input type='text' name='percent' />"
        tableCell4.innerHTML="<input type='button' onclick='delRow("+invregnum+")' value='删除'/>"
    }


    function delRow(invregnum) {
        var invListTable=document.getElementById("invListTable");
        var tableRow=document.getElementById(invregnum);
        invListTable.deleteRow(tableRow.rowIndex);
    }


    function calCap() {
        regCapAry= document.getElementsByName("regmoneyout");
        ctys= document.getElementsByName("cty");
        var totalCap=0;
        var totalCapOut=0;
        for(var i=0;i<regCapAry.length;i++){
            if(regCapAry[i].value!=""){
                totalCap+=parseInt(regCapAry[i].value);
                if(ctys[i].value.toString().indexOf("中")==-1){
                    totalCapOut+=parseInt(regCapAry[i].value);
                }
            }
        }
        document.getElementById("outregcap").value=totalCap;
        document.getElementById("foreiregmoney").value=totalCapOut;
        document.getElementById("outpercent").value=((totalCapOut /totalCap)*100).toFixed(2);
    }
</script>