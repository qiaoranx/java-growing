<%--
  Created by IntelliJ IDEA.
  User: xiang
  Date: 2020/8/11
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
<script type="text/javascript">
    $(function () {
        $("button").click(function () {
            $.ajax({
                url:"returnajax.do",
                data:{
                    name:"zhangsan"
                },
                type:"get",
                dataType:"json",
                success:function (resp) {
                    alert(resp.name);
                }
            })

        })
    })
</script>
<head>
    <title>Title</title>
</head>
<body>
<a href="test/some.do">some.do</a><br/><br/>
<button id="btn">发起ajax请求</button>
</body>
</html>
