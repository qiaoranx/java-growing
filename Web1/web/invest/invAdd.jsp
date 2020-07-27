<%--
  Created by IntelliJ IDEA.
  User: xiang
  Date: 2020/7/27
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/EGOV/invsave" method="post" target="section">
投资人名称：<input type="text" name="invname" id="invName"><br/>
所属国家：<select type="text" name="cty" id="cty">
    <option value=""></option>
    <option value="000">中国</option>
    <option value="001">美国</option>
    <option value="002">英国</option>
    <option value="003">日本</option>
    </select><br/>
组织机构代码：<input type="text" name="orgtype" id="orgcode"><br/>
联系人：<input type="text" name="contactman" id="contactMan"><br/>
联系电话：<input type="text" name="contacttel" id="contactTel"><br/>
电子邮箱：<input type="text" name="email" id="email"><br/>
备注：<input type="text" name="remark" id="remark"><br/><br/>
<input type="submit" value="保存" >
 <input type="button" value="清除">
 <input type="button" value="返回">
</form>
</body>
</html>
<script type="text/javascript">

</script>