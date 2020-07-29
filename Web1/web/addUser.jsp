<%--
  Created by IntelliJ IDEA.
  User: xiang
  Date: 2020/7/27
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String msg=(String) request.getAttribute("addError");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <%
       if(msg!=null){
           %>
    <div id="addError" style="color: red;font-size: 17px"><%=msg%></div>
    <%
       }
    %>

     <form action="/EGOV/addUser" target="section" method="post">
         用户代码：<input type="text" name="usercode" id="usercode" onblur="verifyUsercode(this.value)"><span id="usercodeMsg"></span><br/>
         用户姓名：<input type="text" name="username"><br/>
         用户密码：<input type="password" name="userpwd"><br/>
         机构类型：<select name="orgtype">
         <option value =></option>
         <option value ="0">外汇局</option>
         <option value ="1">银行</option>
     </select><br/><br/>
         <input type="submit" value="保存">
         <input type="reset" value="清除" >
     </form>
</div>
</body>
</html>
<script type="text/javascript">
   function verifyUsercode(usrcodeVal) {
       var xmlHttp=new XMLHttpRequest();
       xmlHttp.onreadystatechange=function () {
           if(xmlHttp.readyState==4&&xmlHttp.status==200){

               document.getElementById("usercodeMsg").innerHTML=xmlHttp.responseText;
           }
       }
       //避免get缓存
       xmlHttp.open("get","/EGOV/addUser?_"+new Date().getTime()+"&usercode="+usrcodeVal,true);
       xmlHttp.send();
   }
</script>
