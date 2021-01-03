<%--
  Created by IntelliJ IDEA.
  User: 37.5
  Date: 2020/12/26
  Time: 8:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>课设首页</title>
    <link type="text/css" rel="stylesheet" href="../css/style.css" />
    <link type="text/css" rel="stylesheet" href="../css/footer.css" />
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
                  location.href = "/recruitBasicInfo?page="+currentPage;
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
                  location.href = "/recruitBasicInfo?page="+currentPage;
              }
              /* 对”最后一页“设置点击事件 */
              var lastPage = document.getElementById("last");
              lastPage.onclick = function () {
                  var pages = document.getElementById("pages")
                  var page = parseInt(pages.innerText);
                  location.href = "/recruitBasicInfo?page="+page;
              }
              /* 对”首页“设置点击事件*/
              var firstPage = document.getElementById("first");
              firstPage.onclick = function () {
                  location.href = "/recruitBasicInfo?page=1";
              }
          }
      </script>
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
    <a href="jsp/jobApply.jsp">找工作</a>
    <a href="jobnews.html">收藏中心</a>
    <a href="jsp/personal.jsp">个人中心</a>
    <a href="jsp/jobApplyInfoWrite.jsp">发布求职</a>
  </div>
  <div id="main">
    <div class="navigation">
      当前位置:&nbsp;&nbsp;<a href="book.do">首页</a>
      <div id="readerBlock">欢迎回来&nbsp;:<a href="/book?method=findAllBorrow&page=1">${sessionScope.reader.name }</a>&nbsp;<a href="/logout">注销</a></div>
    </div>
    <div class="img_block">
      <img src="../images/1.gif" class="img" />
    </div>
    <table class="table" cellspacing="0">
      <tr>
        <td>编号</td>
        <td>职位名称</td>
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
