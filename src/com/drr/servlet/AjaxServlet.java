package com.drr.servlet;

import com.drr.dao.ApplicantDao;
import com.drr.dao.CompanyDao;
import com.drr.entity.Applicant;
import com.drr.entity.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ajax")
public class AjaxServlet extends HttpServlet {
    private ApplicantDao applicantDao = new ApplicantDao();
    private CompanyDao companyDao = new CompanyDao();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应和请求编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        // 获取请求参数
        String method = req.getParameter("method");
        String name = req.getParameter("name");

        if(method.equals("applicant")){
            Applicant applicant = applicantDao.query(name);
            if (applicant != null){
                PrintWriter printWriter = resp.getWriter();
                printWriter.write("正确");
            }else{
                PrintWriter printWriter = resp.getWriter();
                printWriter.write("错误");
            }
        }else if(method.equals("company")){
            Company company = companyDao.query(name);
            if (company != null){
                PrintWriter printWriter = resp.getWriter();
                printWriter.write("正确");
            }else{
                PrintWriter printWriter = resp.getWriter();
                printWriter.write("错误");
            }
        }
    }
}
