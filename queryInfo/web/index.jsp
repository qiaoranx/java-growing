<%--
  Created by IntelliJ IDEA.
  User: xiang
  Date: 2020/7/20
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>queryInfo</title>
  <script type="text/javascript">
    function search() {
      var xmlHttp=new XMLHttpRequest();
      xmlHttp.onreadystatechange=function () {
        if(xmlHttp.readyState==4&&xmlHttp.status==200){
          var jsonObj=eval("("+xmlHttp.responseText+")");
          document.getElementById("proname").value=  jsonObj.name;
          document.getElementById("projiancheng").value=  jsonObj.jiancheng;
          document.getElementById("proshenghui").value=  jsonObj.shenghui;
        }
      }
      var id=  document.getElementById("proid").value.trim();
      xmlHttp.open("get","/queryInfo_war_exploded/pro?proid="+id,true);
      xmlHttp.send();

    }
  </script>
</head>
<body>
<tr>
  <td>省份编号</td>
  <td><input type="text" id="proid">
    <input type="button" value="搜索" onclick="search()">
  </td>
</tr>
<br/>
<td>省份名称</td>
<td><input type="text" id="proname"></td>
<br/>
<tr>
  <td>省份简称</td>
  <td><input type="text" id="projiancheng"></td>
</tr>
<br/>
<tr>
  <td>省会</td>
  <td><input type="text" id="proshenghui"></td>
</tr>
</body>
</html>
