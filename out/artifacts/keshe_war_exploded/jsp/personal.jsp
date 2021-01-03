<%--
  Created by IntelliJ IDEA.
  User: 37.5
  Date: 2020/12/31
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <a href="javascript:void(0)" class="onnav">首页</a>
    <a href="jobApply.jsp">找工作</a>
    <a href="javascript:void(0)">收藏中心</a>
    <a href="javascript:void(0)">个人中心</a>
    <a href="jobApplyInfoWrite.jsp">发布求职</a>
</div>
<div id="personal">
    <div class="uploadPicture">
        <img src="../images/userImg.png" alt="" class="user_img">
        <div class="uploadButton">上传头像</div>
    </div>
    <div class="updatePersonalInfo">
        修改个人资料
        <hr>
        <table>
            <tr>
                <td>用户名：${applicant.userName}</td>
                <td class="modifyButton"><a href="jsp/personalInfoModify.jsp">修改</a></td>
            </tr>
            <tr>
                <td>邮箱：${applicant.applicantEmail}</td>
                <td class="modifyButton"><a href="jsp/personalInfoModify.jsp">修改</a></td>
            </tr>
            <tr>
                <td>密码：${applicant.applicantPwd}</td>
                <td class="modifyButton"><a href="jsp/personalInfoModify.jsp">修改</a></td>
            </tr>
        </table>
    </div>
    <div class="updateResume">
        简历信息
        <hr>
        <table>
            <tr>
                <td>姓名：ddr</td>
            </tr>
            <tr>
                <td>性别：男</td>
            </tr>
            <tr>
                <td>生日：2000-1-1</td>
            </tr>
            <tr>
                <td>手机号：15272954870</td>
            </tr>
            <tr>
                <td>毕业学校：吉首大学</td>
            </tr>
            <tr>
                <td>专业名称：软件工程</td>
            </tr>
            <tr>
                <td>求职意向：系统架构师</td>
            </tr>
            <tr>
                <td>工作经验：1年</td>
            </tr>
        </table>
    </div>
</div>
<%@ include file="footer.jsp"%>
</body>
</html>
