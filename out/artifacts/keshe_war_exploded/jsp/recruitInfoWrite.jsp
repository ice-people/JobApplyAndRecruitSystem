<%--
  Created by IntelliJ IDEA.
  User: 37.5
  Date: 2021/1/1
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>填写招聘信息</title>
    <link rel="stylesheet" href="../css/recruitInfoWrite.css" type="text/css">
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
<dvi id="recruitInfo">
    <div class="recruitInfoWrite">
        职位信息
        <hr>
        <ul>
            <form action="../releaseRecruitInfo" method="POST">
                <li>职位名称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="jobName" type="text" placeholder="请输入职位名称"></li>
                <li>职位类别&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="jobType" type="text" placeholder="请选择发布类别"></li>
                <li>招聘人数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="recruitForNumber" type="text" placeholder="请输入人数">人</li>
                <li>每月薪资&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="salary" type="text" placeholder="请输入薪资"></li>
                <li>学历要求&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="degree" type="text"></li>
                <li>工作地址&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="workAddress" type="text"></li>
                <li>工作描述&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="jobDescription" type="text" placeholder="请输入工作描述"></li>
                <li><input type="submit" value="发布招聘" class="releaseRecruitButton"></li>

            </form>
        </ul>
    </div>
</dvi>
</body>
</html>
