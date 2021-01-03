package com.drr.servlet;

import com.drr.dao.RecruitBasicInfoDao;
import com.drr.entity.RecruitBasicInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/recruitBasicInfo")
public class RecruitBasicInfoServlet extends HttpServlet {

    private RecruitBasicInfoDao recruitBasicInfoDao = new RecruitBasicInfoDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 湖区参数
        String pageStr = req.getParameter("page");    // 获取page参数
        Integer page = Integer.parseInt(pageStr);      //  将String类型装换位为Integer类型
        try {
            List<RecruitBasicInfo> recruitBasicInfoList = recruitBasicInfoDao.findAll(page);   // 获取指定条数据
           /*
           将数据写入request对象中
            */
            req.setAttribute("currentPage",page);
            req.setAttribute("recruitBasicInfoList",recruitBasicInfoList);
            req.setAttribute("pages",recruitBasicInfoDao.getPages());
            req.getRequestDispatcher("jsp/index.jsp?page=1").forward(req,resp);   // 请求转发
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
