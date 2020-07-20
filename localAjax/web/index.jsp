<%--
  Created by IntelliJ IDEA.
  User: xiang
  Date: 2020/7/20
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>局部刷新</title>
  <script type="text/javascript">
    function doAjax() {
      var xmlHttp=new XMLHttpRequest();
      xmlHttp.onreadystatechange=function () {
        if(xmlHttp.readyState==4&&xmlHttp.status==200){
          var data=xmlHttp.responseText;
          document.getElementById("mydata").innerText=data;
        }
      }
      var name=document.getElementById("name").value;
      var weight=document.getElementById("w").value;
      var height=document.getElementById("h").value;
      var para="name="+name+"&w="+weight+"&h="+height;
      xmlHttp.open("get","/localAjax_war_exploded/LocalServlet?"+para,true);
      xmlHttp.send();
    }

  </script>
</head>
<body>
<div>
  姓名：<input type="text" id="name"/><br/>
  体重：<input type="text" id="w"/><br/>
  身高：<input type="text" id="h"/><br/>
  <input type="button" value="计算bmi" onclick="doAjax()">
  <br/>
  <br/>
  <div id="mydata"></div>
</div>
</body>
</html>
