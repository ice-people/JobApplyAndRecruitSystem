package com.drr.servlet;

import com.drr.dao.ApplicantDao;
import com.drr.entity.Applicant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/myLogin")
public class LoginServlet extends HttpServlet {
    ApplicantDao applicantDao = new ApplicantDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // 设置响应和请求编码
//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html;charset=UTF-8");

        //  获取请求参数
        String userName = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // 验证邮箱、密码和用户名是否正确
        Applicant applicant = applicantDao.ensureForLogin(userName,email,password);
        if (applicant != null){    // 密码、邮箱和用户名验证成功
            // 将用户信息存入session
            HttpSession session = req.getSession();
            session.setAttribute("applicant",applicant);
            // 验证成功，跳转主页
            PrintWriter writer0 = resp.getWriter();
            resp.sendRedirect("/recruitBasicInfo?page=1");
            writer0.flush();
            writer0.close();
            return;
        }
        PrintWriter writer = resp.getWriter();
        writer.write("<script>");
        writer.write("alert('密码或邮箱或用户名错误');");
        writer.write("window.location.href='login.html'");
        writer.write("</script>");
        writer.flush();
        writer.close();


    }
}
