<%@ page import="com.company.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.company.util.PropertyUtil" %>
<%@ page import="static com.company.util.Const.PAGESIZE" %>
<%@ page import="com.company.entity.Page" %><%--
  Created by IntelliJ IDEA.
  User: xiang
  Date: 2020/7/23
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Page<User> pageUser=(Page<User>)request.getAttribute("page");
    List<User> userList=pageUser.getPageList();
    int totalCount=pageUser.getTotalCount();
    int totalPage=pageUser.getTotalPage();
    int curPage=pageUser.getCurPage();
%>
<html>
<head>
    <title>title</title>
</head>
<body onpageshow="checkboxState()">
<div>
    <input type="button" id="addUser" value="添加用户">
</div><br/>

<script type="text/javascript">
    function checkboxState() {
        var userchecks=document.getElementsByName("usercheck");
        var res=0;
        for(var i=0;i<userchecks.length;i++){
            if(userchecks[i].checked){
                res++;
            }
        }
        if(res==1){
            if(res==userchecks.length){
                document.getElementById("selectAll").checked=true;
            }else{
                document.getElementById("selectAll").checked=false;
            }
            document.getElementById("editImg").src="img/edit.png";
            document.getElementById("editImg").onclick=edit;
            document.getElementById("editImg").style.cursor="hand";
            document.getElementById("deleteImg").src="img/delete.png";
            document.getElementById("deleteImg").onclick=deleteUser;
            document.getElementById("deleteImg").style.cursor="hand";
        }else if(res>1){
            if(res==userchecks.length){
                document.getElementById("selectAll").checked=true;
            }else{
                document.getElementById("selectAll").checked=false;
            }
            document.getElementById("editImg").src="img/editdisabled.png";
            document.getElementById("editImg").onclick=null;
            document.getElementById("editImg").style.cursor="default";
            document.getElementById("deleteImg").src="img/delete.png";
            document.getElementById("deleteImg").onclick=deleteUser;
            document.getElementById("deleteImg").style.cursor="hand";
        }else{
            document.getElementById("selectAll").checked=false;
            document.getElementById("editImg").src="img/editdisabled.png";
            document.getElementById("editImg").onclick=null;
            document.getElementById("editImg").style.cursor="default";
            document.getElementById("deleteImg").src="img/deletedisabled.png";
            document.getElementById("deleteImg").onclick=null;
            document.getElementById("deleteImg").style.cursor="default";
        }
    }


    function checkAll() {

        var userchecks=document.getElementsByName("usercheck");
        if (document.getElementById("selectAll").checked){
            for(var i=0;i<userchecks.length;i++){
                userchecks[i].checked=true;
            }
            document.getElementById("editImg").src="img/editdisabled.png";
            document.getElementById("editImg").onclick=null;
            document.getElementById("editImg").style.cursor="default";
            document.getElementById("deleteImg").src="img/delete.png";
            document.getElementById("deleteImg").onclick=deleteUser;
            document.getElementById("deleteImg").style.cursor="hand";
        }else{
            for(var i=0;i<userchecks.length;i++){
                userchecks[i].checked=false;
            }
            document.getElementById("editImg").src="img/editdisabled.png";
            document.getElementById("editImg").onclick=null;
            document.getElementById("editImg").style.cursor="default";
            document.getElementById("deleteImg").src="img/deletedisabled.png";
            document.getElementById("deleteImg").onclick=null;
            document.getElementById("deleteImg").style.cursor="default";
        }

    }

    function edit() {
        document.forms["userForm"].submit();
    }

    function deleteUser() {

        if(window.confirm("确定删除选择的信息吗？")){
            document.forms["userForm"].action="/EGOV/deleteUser";
            document.forms["userForm"].method="get";
            document.forms["userForm"].submit();
            document.forms["userForm"].target="section";
        }
    }

</script>

<div>
    <img  id="editImg" src="img/editdisabled.png"  width="20" height="20" >
    <img  id="deleteImg" src="img/deletedisabled.png"   width="20" height="20">
</div>
<script type="text/javascript">
    window.onload=function () {
        document.getElementById("addUser").onclick=function () {
            window.location.href="http://localhost:80/EGOV/addUser.jsp";
            window.location.href.target="section";
        }

    }
</script>
<form action="/EGOV/goUpdate?pageNum=<%=curPage%>" target="section" method="post" name="userForm">
    <table border="1">
        <tr>
            <td><input type="checkbox" id="selectAll" onclick="checkAll()"></td>
            <td>序号</td>
            <td>用户代码</td>
            <td>用户名</td>
            <td>用户机构</td>
        </tr>
        <%
            int i=0;
            for (User user : userList) {
        %>
        <tr>
            <td><input type="checkbox" name="usercheck" value="<%=user.getUsercode()%>" onclick="checkboxState()" ></td>
            <td><%=++i%></td>
            <td><%=user.getUsercode()%> </td>
            <td><%=user.getUsername()%></td>
            <td><%=PropertyUtil.proUtil(user.getOrgtype())%></td>
        </tr>
        <%
            }
        %>
    </table>
</form>
<font style="font-size: 12px;color: black">共<%=totalCount%>条记录，当前第<%=curPage%>/<%=totalPage%>页，每页<%=PAGESIZE%>条记录</font>
<%
    boolean isFirstPage=curPage==1;
    boolean isLastPage=curPage==totalPage;

%>

<div>
    <img  src="img/direction-left<%=isFirstPage?"disabled":""%>.png" <%=isFirstPage?"":"style='cursor:hand' onclick='pageChange(1)' "%> width="20" height="20"/>
    <img  src="img/arrow-double-left<%=isFirstPage?"disabled":""%>.png" <%=isFirstPage?" ":"style='cursor:hand' onclick='pageChange("+curPage+"-1)'"%> width="20" height="20"/>
    <img  src="img/arrow-double-right<%=isLastPage?"disabled":""%>.png" <%=isLastPage?"":"style='cursor:hand' onclick='pageChange("+curPage+"+1)' "%> width="20" height="20"/>
    <img  src="img/direction-right<%=isLastPage?"disabled":""%>.png" <%=isLastPage?"":"style='cursor:hand' onclick='pageChange("+totalPage+")' "%> width="20" height="20"/>
</div>
<div>
    <font style="font-size: 12px;color: black">跳转到第</font>
    <input type="text" id="goPageNum" style="width: 20px">
    <font style="font-size: 12px;color: black">页</font>
    <img src="img/goPage.png" width="20" height="20" style="cursor:hand" onclick=goPage() >
</div>
<script type="text/javascript">
    function pageChange(page) {
            window.location.href = "http://localhost:80/EGOV/pageQuery?pageNum=" + page;
            window.location.href.target = "section";
    }
    function goPage(){
        var goPageObj=document.getElementById("goPageNum");
        if(goPageObj.value==""){
            goPageObj.focus();
            return;
        }
        if(isNaN(goPageObj.value)){
            goPageObj.value="";
            goPageObj.focus();
            return;
        }
        var pageno=parseInt(goPageObj.value);
        if(pageno<1||pageno><%=totalPage%>){
            goPageObj.value="";
            goPageObj.focus();
            return;
        }
        window.location.href="http://localhost:80/EGOV/pageQuery?pageNum="+document.getElementById("goPageNum").value;
        window.location.href.target="section";
    }

</script>
</body>
</html>
