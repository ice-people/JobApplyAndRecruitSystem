package com.drr.servlet;

import com.drr.dao.SendResumeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pass")
public class PassServlet extends HttpServlet {
    private SendResumeDao sendResumeDao = new SendResumeDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String method = req.getParameter("method");
        Integer sendResumeId = Integer.parseInt(req.getParameter("id"));
        if(method.equals("pass")){
            int result = sendResumeDao.update("通过",sendResumeId);
            req.getRequestDispatcher("/passApply").forward(req,resp);

        }else if(method.equals("nopass")){
            int result = sendResumeDao.update("驳回",sendResumeId);
            req.getRequestDispatcher("/passApply").forward(req,resp);
        }
    }
}
