package com.drr.servlet;

import com.drr.dao.JobApplyBasicInfoDao;
import com.drr.entity.Applicant;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/releaseJobApplyInfo")
public class releaseJobApplyInfoServlet extends HttpServlet {
    private JobApplyBasicInfoDao jobApplyBasicInfoDao = new JobApplyBasicInfoDao();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应和请求编码
        req.setCharacterEncoding("UTf-8");
        resp.setContentType("text/html;charset=UTF-8");

        //  获取请求参数
        String jobApplyType = req.getParameter("jobApplyType");
        Integer jobApplySalary = Integer.parseInt(req.getParameter("jobApplySalary"));
        String jobApplyForAddress = req.getParameter("jobApplyForAddress");

        // 通过session获取登录的用户的applicantId
        HttpSession session = req.getSession();
        Applicant applicant = (Applicant) session.getAttribute("applicant");
        Integer applicantId = applicant.getApplicantID();

        // 将数据写入数据库
        int result = jobApplyBasicInfoDao.writeJobApplyInfoToSql(applicantId,jobApplyType,jobApplySalary,jobApplyForAddress);
        if(result != 0){   // 数据写入成功
            PrintWriter writer = resp.getWriter();
            writer.write("<script>");
            writer.write("alert('发布成功');");
            writer.write("window.location.href='/recruitBasicInfo?page=1'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }else{
            PrintWriter writer = resp.getWriter();
            writer.write("<script>");
            writer.write("alert('发布失败');");
            writer.write("window.location.href='jsp/jobApplyInfoWrite.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
    }
}
