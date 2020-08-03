<%--
  Created by IntelliJ IDEA.
  User: xiang
  Date: 2020/7/27
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <li><input type="button" value="登记管理" id="regManager"><br/><br/>
        <input type="button" value="基本信息登记" id="msgManager" style="visibility: hidden"><br/><br/>
        <ol id="msgReg" style="visibility: hidden">
            <li><input type="button" value="企业投资人信息登记" id="invReg">
                <ol id="invInp" style="visibility: hidden">
                    <a target="section" href="http://localhost:80/EGOV/invest/invMsgReg.jsp">录入</a>
                </ol>
            </li>
            <li><input type="button" value="企业外汇登记" id="outReg">
                <ol id="outInp" style="visibility: hidden">
                    <a target="section" href="http://localhost:80/EGOV/invest/enterprise.jsp">录入</a>
                </ol>
            </li>
        </ol>
    </li>
    <li><input type="button" value="核准管理" id="authManager"><br/><br/>
        <ol id="accountManager" style="visibility: hidden">
            <li>
                <a target="section" href="http://localhost:80/EGOV/auth/goAddAuth.jsp">资本金账户核准录入</a>
            </li>
        </ol>
    </li><br/>
    <li><input type="button" value="系统管理" id="sysManager"><br/>
        <ol id="userManager" style="visibility: hidden">
            <li>
                <a target="section" href="http://localhost:80/EGOV/pageQuery?pageNum=1">用户管理</a>
            </li>
        </ol>
    </li>
</ul>

<script type="text/javascript">
    window.onload=function(){

        var isVisAuth=false;
        document.getElementById("authManager").onclick=function(){
            isVisAuth=!isVisAuth;
            if(isVisAuth){
                document.getElementById("accountManager").style.visibility="visible";
            }else{
                document.getElementById("accountManager").style.visibility="hidden";
            }
        }

        var isVisSys=false;
        document.getElementById("sysManager").onclick=function(){
            isVisSys=!isVisSys;
            if(isVisSys){
                document.getElementById("userManager").style.visibility="visible";
            }else{
                document.getElementById("userManager").style.visibility="hidden";
            }

        }
        var isVisReg=false;
        document.getElementById("regManager").onclick=function(){
            isVisReg=!isVisReg;
            if(isVisReg){
                document.getElementById("msgManager").style.visibility="visible";
            }else{
                document.getElementById("msgManager").style.visibility="hidden";
            }

        }
        var isVisMsg=false;
        document.getElementById("msgManager").onclick=function(){
            isVisMsg=!isVisMsg;
            if(isVisMsg){
                document.getElementById("msgReg").style.visibility="visible";
            }else{
                document.getElementById("msgReg").style.visibility="hidden";
            }
        }
        var isVisInv=false;
        document.getElementById("invReg").onclick=function(){
            isVisInv=!isVisInv;
            if(isVisInv){
                document.getElementById("invInp").style.visibility="visible";
            }else{
                document.getElementById("invInp").style.visibility="hidden";
            }
        }
        var isVisOut=false;
        document.getElementById("outReg").onclick=function(){
            isVisOut=!isVisOut;
            if(isVisOut){
                document.getElementById("outInp").style.visibility="visible";
            }else{
                document.getElementById("outInp").style.visibility="hidden";
            }
        }
    }
</script>
</body>
</html>
