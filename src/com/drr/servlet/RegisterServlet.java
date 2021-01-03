package com.drr.servlet;

import com.drr.dao.ApplicantDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/myRegister")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //  获取请求参数
        String userName = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // 通过邮箱判断，该用户是否已经注册过
        try {
            //已被注册，返回注册界面，请求转发
            if(ApplicantDao.ensureForRegister(email)){
                PrintWriter writer = resp.getWriter();
                writer.write("<script>");
                writer.write("alert('该email已被注册');");
                writer.write("window.location.href='register.html'");
                writer.write("</script>");
                writer.flush();
                writer.close();

            }else{  // 未注册，注册成功，调转登录界面，重定向
//                ApplicantDao.writeApplicantDateToSql(userName, email, password);
                resp.sendRedirect("/Web_war_exploded/login.html");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
