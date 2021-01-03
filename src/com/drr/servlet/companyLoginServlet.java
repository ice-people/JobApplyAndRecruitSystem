package com.drr.servlet;

import com.drr.dao.CompanyDao;
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

@WebServlet("/companyLogin")
public class companyLoginServlet extends HttpServlet {
    CompanyDao  companyDao = new CompanyDao();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应和请求编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        //  获取请求参数
        String companyName = req.getParameter("companyName");
        String companyTelephone = req.getParameter("companyTelephone");
        String password = req.getParameter("password");

        // 验证邮箱、密码和用户名是否正确
        Company company= companyDao.ensureForLogin(companyName,companyTelephone,password);
        if (company != null){    // 密码、邮箱和用户名验证成功
            // 将用户信息存入session
            HttpSession session = req.getSession();
            session.setAttribute("company",company);
            // 验证成功，跳转主页
            PrintWriter writer0 = resp.getWriter();
            resp.sendRedirect("/jobApplyBasicInfo?page=1");
            writer0.flush();
            writer0.close();
            return;
        }
        PrintWriter writer = resp.getWriter();
        writer.write("<script>");
        writer.write("alert('公司名或联系电话或密码错误');");
        writer.write("window.location.href='companyLogin.html'");
        writer.write("</script>");
        writer.flush();
        writer.close();


    }
}
