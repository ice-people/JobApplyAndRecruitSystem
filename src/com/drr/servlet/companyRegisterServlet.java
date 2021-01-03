package com.drr.servlet;

import com.drr.dao.ApplicantDao;
import com.drr.dao.CompanyDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/companyRegister")
public class companyRegisterServlet extends HttpServlet {
    private CompanyDao companyDao = new CompanyDao();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //  获取请求参数
        String companyName = req.getParameter("companyName");
        String telephone = req.getParameter("telephone");
        String password = req.getParameter("password");
        String address = req.getParameter("address");

        // 通过联系电话判断，该公司用户是否已经注册过
        try {
            //已被注册，返回注册界面，请求转发
            if(ApplicantDao.ensureForRegister(telephone)){
                PrintWriter writer = resp.getWriter();
                writer.write("<script>");
                writer.write("alert('该公司用户已被注册');");
                writer.write("window.location.href='companyRegister.html'");
                writer.write("</script>");
                writer.flush();
                writer.close();

            }else{  // 未注册，注册成功，调转登录界面，重定向
                companyDao.writeApplicantDateToSql(companyName,address,telephone,password);
                resp.sendRedirect("companyLogin.html");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
