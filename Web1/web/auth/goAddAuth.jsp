<%--
  Created by IntelliJ IDEA.
  User: xiang
  Date: 2020/8/1
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    组织机构代码：<input id="orgcode" type="text" readonly><br/>
    <input type="button" onclick="queryOrg()" value="查询">
    <input type="button" onclick="goAddAuth()" value="确定">
</form>

</body>
</html>
<script type="text/javascript">
    function queryOrg() {
        window.open("http://localhost:80/EGOV/auth/selectOrg.jsp","selectOrg","width=1000,height=400");
    }

    function getOrgcode(orgcode) {
        document.getElementById("orgcode").value=orgcode;
    }

   function goAddAuth(){
      var orgcode= document.getElementById("orgcode").value;
        if(orgcode==""){
            return;
        }
        window.location.href="/EGOV/addAuth?orgcode="+orgcode;
        window.location.href.target="section";
   }
</script>