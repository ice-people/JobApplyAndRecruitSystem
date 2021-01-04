<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.drr.entity.RecruitBasicInfo" %><%--
  Created by IntelliJ IDEA.
  User: 37.5
  Date: 2020/12/30
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>找工作</title>
    <link type="text/css" rel="stylesheet" href="../css/style.css" />
    <link type="text/css" rel="stylesheet" href="../css/jobApplySearch.css" />
    <script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="../js/my.js"></script>
    <script>
        window.onload = function () {
            /* 对“下一页“点击事件 */
            var nextPage = document.getElementById("next");
            nextPage.onclick = function () {
                var page = document.getElementById("currentPage");
                var currentPage = parseInt(page.innerText);
                var pages = document.getElementById("pages");

                if (currentPage == parseInt(pages.innerText)){
                    return;
                }
                currentPage++;
                location.href = "jobApply.jsp?page="+currentPage;
            }
            /* 对”上一页“设置点击事件 */
            var previousPage = document.getElementById("previous");
            previousPage.onclick = function () {
                var currentPage = document.getElementById("currentPage");
                var currentPage = parseInt(currentPage.innerText);
                if (currentPage == 1){
                    return;
                }
                currentPage--;
                location.href = "jobApply.jsp?page="+currentPage;
            }
            /* 对”最后一页“设置点击事件 */
            var lastPage = document.getElementById("last");
            lastPage.onclick = function () {
                var pages = document.getElementById("pages")
                var page = parseInt(pages.innerText);
                location.href = "jobApply.jsp?page="+page;
            }
            /* 对”首页“设置点击事件*/
            var firstPage = document.getElementById("first");
            firstPage.onclick = function () {
                location.href = "jobApply.jsp?page=1";
            }

            /* 修改“找工作div的背景颜色 */
            var temp = document.querySelector('a[href="jobApply.jsp"]');
            temp.style.backgroundColor = '#FA5F00';
            temp.style.color = '#FFF';
            /* 修改“首页”div的背景颜色 */
            var temp1 = document.querySelector('a[class="onnav"]')
            temp1.style.backgroundColor ='#FFF';
            temp1.style.color = '#000';
        }
    </script>
</head>
<body>
<%@include file="top.jsp"%>
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
    <a href="../recruitBasicInfo?page=1" class="onnav">首页</a>
    <a href="javascript:void(0)">找工作</a>
    <a href="javascript:void(0)">收藏中心</a>
    <a href="personal.jsp">个人中心</a>
    <a href="jsp/jobApplyInfoWrite.jsp">发布求职</a>
</div>
<div class="jobApplySearch">
    <form action="../jobApplyFind" method="post" enctype="application/x-www-form-urlencoded">
        <input type="text" placeholder="请选择职位类别" list="jobTypeList" name="jobType">
        <datalist id="jobTypeList">
            <option value="IT"></option>
            <option value="平面设计"></option>
            <option value="动漫设计"></option>
            <option value="企业管理"></option>
        </datalist>
        <input type="text" placeholder="请职位工作省份" list="provinceList" name="workAddress">
        <datalist id="provinceList">
            <option value="山东省"></option>
            <option value="江苏省"></option>
            <option value="安徽省"></option>
            <option value="浙江省"></option>
            <option value="福建省"></option>
            <option value="上海市"></option>
            <option value="广东省"></option>
            <option value="广西省"></option>
            <option value="海南省"></option>
            <option value="湖北省"></option>
            <option value="湖南省"></option>
            <option value="河南省"></option>
            <option value="江西省"></option>
            <option value="北京市"></option>
            <option value="天津省"></option>
            <option value="河北省"></option>
            <option value="山西省"></option>
            <option value="内蒙古"></option>
            <option value="宁夏省"></option>
            <option value="新疆维吾尔自治区"></option>
            <option value="青海省"></option>
            <option value="陕西省"></option>
            <option value="甘肃省"></option>
            <option value="四川省"></option>
            <option value="云南省"></option>
            <option value="贵州省"></option>
            <option value="西藏"></option>
            <option value="重庆市"></option>
            <option value="辽宁省"></option>
            <option value="吉林省"></option>
            <option value="黑龙江省"></option>
        </datalist>
        <input type="text" placeholder="请输入职位名等关键字" name="jobName">
        <input type="submit" value="找工作" class="submit">
    </form>
</div>
<div id="main">
    <table class="table" cellspacing="0">
        <tr>
            <td>职位名称</td>
            <td>职位类别</td>
            <td>招聘人数</td>
            <td>每月薪资</td>
            <td>学历要求</td>
            <td>工作地址</td>
            <td>职位描述</td>
            <td>操作</td>
        </tr>
        <%
        ArrayList<RecruitBasicInfo> lists = (ArrayList<RecruitBasicInfo>)session.getAttribute("recruitBasicInfoList");
        Integer limit = null;
        limit = (Integer) session.getAttribute("LIMIT");
        List<RecruitBasicInfo> tempList = new ArrayList<>();
        if (limit != null){
            Integer currentPage = Integer.parseInt(request.getParameter("page"));
            session.setAttribute("currentPage",currentPage);
            int temp = (currentPage - 1)*(int)session.getAttribute("LIMIT");
            for(int i = temp;i < lists.size();i++ ){
                if(i >= (temp + limit)){
                    break;
                }else{
                    tempList.add(lists.get(i));
                }
            }
        }else{
            session.removeAttribute("currentPage");
        }
        session.setAttribute("lists1",tempList);

    %>
        <c:forEach items="${lists1}" var="recruitBasicInfo">
            <tr>
                <td>${recruitBasicInfo.jobName}</td>
                <td>${recruitBasicInfo.jobType}</td>
                <td>${recruitBasicInfo.recruitForNumber}</td>
                <td>${recruitBasicInfo.salary}</td>
                <td>${recruitBasicInfo.degree}</td>
                <td>${recruitBasicInfo.workAddress}</td>
                <td>${recruitBasicInfo.jobDecription}</td>
                <td>
                    <a href="../sendResume?companyId=${recruitBasicInfo.companyId}&recruitBasicInfoID=${recruitBasicInfo.recruitBasicInfoID}">投递简历</a>
                </td>
            </tr>
        </c:forEach>

    </table>
    <hr class="hr"/>
    <div id="pageControl">
        <div class="pageControl_item">每页<font id="dataPrePage">${dataPrePage }</font>条数据</div>
        <div class="pageControl_item" id="last">最后一页</div>
        <div class="pageControl_item" id="next">下一页</div>
        <div class="pageControl_item"><font id="currentPage">${currentPage }</font>/<font id="pages">${pages }</font></div>
        <div class="pageControl_item" id="previous">上一页</div>
        <div class="pageControl_item" id="first">首页</div>
    </div>

</div>
<%@ include file="footer.jsp" %>
</body>
</html>
