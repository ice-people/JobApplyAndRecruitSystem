<%@ page import="com.drr.entity.SendResume" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 37.5
  Date: 2020/12/31
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>个人中心</title>
    <link rel="stylesheet" href="../css/personal.css" type="text/css">
    <link rel="stylesheet" href="../css/style.css" type="text/css">
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
<div class="menuDiv">
    <a href="jsp/indexForCompany" class="onnav">首页</a>
    <a href="meetingJob.html">招聘</a>
    <a href="javascript:void(0)">个人中心</a>
    <a href="jsp/recruitInfoWrite.jsp" class="mobile">发布招聘</a>
</div>
<div id="personal">
    <div class="updatePersonalInfo">
        修改个人资料
        <hr>
        <table>
            <tr>
                <td>公司名：${company.companyName}</td>
                <td class="modifyButton"><a href="jsp/personalInfoModify.jsp">修改</a></td>
            </tr>
            <tr>
                <td>联系电话：${company.companyTelephone}</td>
                <td class="modifyButton"><a href="jsp/personalInfoModify.jsp">修改</a></td>
            </tr>
            <tr>
                <td>公司地址：${company.companyAddress}</td>
                <td class="modifyButton"><a href="jsp/personalInfoModify.jsp">修改</a></td>
            </tr>
        </table>
    </div>
    <div class="updateResume">
        待审批信息
        <hr>
        <table class="table" cellspacing="0">
            <tr>
                <td>申请人姓名</td>
                <td>性别</td>
                <td>毕业学校</td>
                <td>学历</td>
                <td>专业</td>
                <td>工作经历</td>
                <td>邮箱</td>
                <td>状态</td>
                <td>操作</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${sendResumeList}" var="sendResume">
                <tr>
                    <td>${sendResume.resumeName}</td>
                    <td>${sendResume.resumeSex}</td>
                    <td>${sendResume.resumeSchool}</td>
                    <td>${sendResume.resumeDegree}</td>
                    <td>${sendResume.resumeProfession}</td>
                    <td>${sendResume.resumeWorkExe}</td>
                    <td>${sendResume.resumeEmail}</td>
                    <td class="state">${sendResume.resumeState}</td>
                    <td>
                        <a href="/pass?method=pass&id=${sendResume.sendResumeId}">通过申请</a>
                    </td>
                    <td>
                        <a href="/pass?method=nopass&id=${sendResume.sendResumeId}">驳回申请</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <hr class="hr"/>
    </div>
</div>
</body>
</html>
