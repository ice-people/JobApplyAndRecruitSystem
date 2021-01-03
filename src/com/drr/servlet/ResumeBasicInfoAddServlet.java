package com.drr.servlet;

import com.drr.dao.ResumeDao;
import com.drr.entity.Applicant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/resumeBasicInfoAdd")
public class ResumeBasicInfoAddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求参数
        String name = req.getParameter("realName");
        String sex = req.getParameter("sex");
        String birthday = req.getParameter("birthday");
        String telephone = req.getParameter("telephone");
        String school = req.getParameter("school");
        String degree = req.getParameter("degree");
        String profession = req.getParameter("profession");
        String jobIntention = req.getParameter("jobIntention");
        String workExe = req.getParameter("workExe");
        String email = req.getParameter("email");
        // 通过email获取该用户注册账号信息
        HttpSession session = req.getSession();
        Applicant applicant = (Applicant) session.getAttribute("applicant");
        System.out.println(applicant);
        Integer applicantId  = applicant.getApplicantID();
        // 将简历信息写到数据库
        try {
            ResumeDao.writeResumeInfoToSql(applicantId,name,sex,birthday,telephone,school,degree,profession,jobIntention,workExe,email);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
