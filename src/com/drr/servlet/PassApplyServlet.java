package com.drr.servlet;

import com.drr.dao.SendResumeDao;
import com.drr.entity.Company;
import com.drr.entity.RecruitBasicInfo;
import com.drr.entity.SendResume;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/passApply")
public class PassApplyServlet extends HttpServlet {
    private SendResumeDao sendResumeDao = new SendResumeDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取session
        HttpSession session = req.getSession();
        Company company = (Company) session.getAttribute("company");
        Integer companyId = company.getCompanyId();

        //  从职位申请表sendresume中获取该公司对应的求职申请信息
        try {
            List<SendResume> sendResumeList = sendResumeDao.find(companyId);
            req.setAttribute("sendResumeList",sendResumeList);
            req.getRequestDispatcher("jsp/companyPersonal.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
