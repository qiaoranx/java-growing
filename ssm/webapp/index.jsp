<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath=request.getScheme()+
            "://"+request.getServerName()+
            ":"+request.getServerPort()+
            request.getContextPath()+"/";
%>
<html>
<base href="<%=basePath%>"/>
<script type="text/javascript" src="static/js/jquery.js"></script>
<title></title>
<head>
</head>
<body>
<form action="student/addStudent.do" method="post">
    学生姓名： <input name="name" type="text"><br/>
    学生年龄： <input name="age" type="text"><br/>
    <input type="submit" value="添加学生">
</form>
<br/>
<input type="button" value="查询学生信息" id="btnQuery"><br/>
<table border="1">
    <thead>
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>年龄</td>
    </tr>
    </thead>
    <tbody id="tableBody">

    </tbody>
</table>
</body>
</html>
<script type="text/javascript">
    //$(function ()在dom页面加载完毕时执行
    $(function () {
        $("#btnQuery").click(function () {
            $.ajax({
                url:"student/queryStudent.do",
                type:"get",
                dataType:"json",
                success:function (data) {
                    $("#tableBody").html("");
                    $.each(data,function (i,n) {
                        $("#tableBody").append("<tr>")
                            .append("<td>"+n.id+"</td>")
                            .append("<td>"+n.name+"</td>")
                            .append("<td>"+n.age+"</td>")
                        .append("</tr>")
                    })
                }
            })
        })
    })
</script>