package com.drr.servlet;


import com.drr.dao.ResumeDao;
import com.drr.dao.SendResumeDao;
import com.drr.entity.Applicant;
import com.drr.entity.ResumeBasicInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sendResume")
public class SendResumeServlet extends HttpServlet {
    private ResumeDao resumeDao = new ResumeDao();
    private SendResumeDao sendResumeDao = new SendResumeDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应和请求编码
        req.setCharacterEncoding("UTf-8");
        resp.setContentType("text/html;charset=UTF-8");

        //  获取请求参数
        Integer companyId = Integer.parseInt(req.getParameter("companyId"));
        // 获取要投递简历的用户的applicantId
        HttpSession session = req.getSession();
        Applicant applicant = (Applicant) session.getAttribute("applicant");
        Integer applicantId = applicant.getApplicantID();

        // 查询该用户的简历
        ResumeBasicInfo resume = resumeDao.getDataByApplicantId(applicantId);

        // 投递简历
        int result = sendResumeDao.writeDataToSql(applicantId,companyId,resume.getApplicantName(),resume.getApplicantSex(),resume.getApplicantSchool(),resume.getApplicantDegree(),resume.getApplicantProfession(),
                resume.getApplicantWorkExe(),resume.getApplicantEmail(),"待通过");
        if (result != 0){   // 写入数据库成功
            PrintWriter writer = resp.getWriter();
            writer.write("<script>");
            writer.write("alert('简历投递成功');");
            writer.write("window.location.href='/recruitBasicInfo?page=1'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }else{    // 写入数据库失败
            PrintWriter writer = resp.getWriter();
            writer.write("<script>");
            writer.write("alert('简历投递失败');");
            writer.write("window.location.href='/recruitBasicInfo?page=1'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
    }
}
