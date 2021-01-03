package com.drr.servlet;

import com.drr.dao.RecruitBasicInfoDao;
import com.drr.entity.Applicant;
import com.drr.entity.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/releaseRecruitInfo")
public class releaseRecruitInfoServlet extends HttpServlet {
    private RecruitBasicInfoDao recruitBasicInfoDao = new RecruitBasicInfoDao();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应和请求编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //  获取请求参数
        String jobName = req.getParameter("jobName");
        String jobType = req.getParameter("jobType");
        Integer recruitForNumber = Integer.parseInt(req.getParameter("recruitForNumber"));
        Integer salary = Integer.parseInt(req.getParameter("salary"));
        String degree = req.getParameter("degree");
        String workAddress = req.getParameter("workAddress");
        String jobDescription = req.getParameter("jobDescription");

        // 通过session获取登录的用户的applicantId
        HttpSession session = req.getSession();
        Company company = (Company) session.getAttribute("company");
        Integer companyId = company.getCompanyId();

        // 将数据写入数据库
        int result = recruitBasicInfoDao.writeRecruitInfoToSql(companyId,jobName,jobType,recruitForNumber,salary,
                degree,workAddress,jobDescription);
        if(result != 0){   // 数据写入成功
            PrintWriter writer = resp.getWriter();
            writer.write("<script>");
            writer.write("alert('发布成功');");
            writer.write("window.location.href='/jobApplyBasicInfo?page=1'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }else{
            PrintWriter writer = resp.getWriter();
            writer.write("<script>");
            writer.write("alert('发布失败');");
            writer.write("window.location.href='jsp/recruitInfoWrite.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }

    }
}
