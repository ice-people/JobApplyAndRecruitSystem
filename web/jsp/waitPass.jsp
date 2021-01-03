<%--
  Created by IntelliJ IDEA.
  User: 37.5
  Date: 2021/1/2
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>待审批申请</title>
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
<div id="main">
    <div class="navigation">
        待审批信息
        <div id="readerBlock">欢迎回来&nbsp;:<a href="/book?method=findAllBorrow&page=1">${sessionScope.reader.name }</a>&nbsp;<a href="/logout">注销</a></div>
    </div>
    <div class="img_block">
        <img src="../images/1.gif" class="img" />
    </div>
    <table class="table" cellspacing="0">
        <tr>
            <td>投递的职位</td>
            <td>投递的公司</td>
            <td>职位类别</td>
            <td>招聘人数</td>
            <td>每月薪资</td>
            <td>学历要求</td>
            <td>工作地址</td>
            <td>职位描述</td>
            <td>操作</td>
        </tr>

        <c:forEach items="${recruitBasicInfoList}" var="recruitBasicInfo">
            <tr>
                <td>${recruitBasicInfo.recruitBasicInfoID}</td>
                <td>${recruitBasicInfo.jobName}</td>
                <td>${recruitBasicInfo.jobType}</td>
                <td>${recruitBasicInfo.recruitForNumber}</td>
                <td>${recruitBasicInfo.salary}</td>
                <td>${recruitBasicInfo.degree}</td>
                <td>${recruitBasicInfo.workAddress}</td>
                <td>${recruitBasicInfo.jobDecription}</td>
                <td>
                    <a href="/sendResume?companyId=${recruitBasicInfo.companyId}&recruitBasicInfoID=${recruitBasicInfo.recruitBasicInfoID}">撤回</a>
                </td>
            </tr>
        </c:forEach>

    </table>
    <hr class="hr"/>
    </div>
</body>
</html>
