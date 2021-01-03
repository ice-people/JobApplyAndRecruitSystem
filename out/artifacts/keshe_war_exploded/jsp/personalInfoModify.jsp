<%--
  Created by IntelliJ IDEA.
  User: 37.5
  Date: 2021/1/1
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人资料设置</title>
    <link rel="stylesheet" href="../css/personalInfoModify.css" type="text/css">
    <link type="text/css" rel="stylesheet" href="../css/style.css" />
</head>
<body>
<%@ include file="top.jsp"%>
<div class="loginDiv">
    <div class="loginL">
        <img src="../images/LOGO.png" />
        <img src="../images/view_logo40.png" />
    </div>
    <div class="loginAddress">
        <div class="add1">
            <span class="span1">河北</span>
            <span class="span2"></span>
        </div>
    </div>
    <div class="loginR">
        <img src="../images/spirit_40.png" />
    </div>
</div>
<div id="personalInfo">
    <div class="updatePersonalInfo">
        个人资料设置
        <hr>
        <ul>
            <form action="">
                <li>&nbsp;&nbsp;&nbsp;&nbsp;用户名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="请输入用户名"></li>
                <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;邮箱&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="输入邮箱"></li>
                <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="请输入密码"></li>
                <li>确认密码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="请再次输入密码"></li>
                <li><input type="submit" value="确认修改" class="modifyButton"></li>
            </form>
        </ul>
    </div>
</div>
</body>
</html>
