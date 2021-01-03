package com.drr.servlet;

import com.drr.dao.RecruitBasicInfoDao;
import com.drr.entity.RecruitBasicInfo;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/jobApplyFind")
public class jobApplyFindServlet extends HttpServlet {
    private RecruitBasicInfoDao recruitBasicInfoDao = new RecruitBasicInfoDao();
    private final  int LIMIT = 1;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* 获取参数 */
        String jobType = req.getParameter("jobType");
        String workAddress = req.getParameter("workAddress");
        String jobName = req.getParameter("jobName");

        /* 在数据库查找符合条件的招聘信息 */
        try {
            List<RecruitBasicInfo> recruitBasicInfoList = recruitBasicInfoDao.find(jobName,jobType,workAddress);
            int dataSize = recruitBasicInfoList.size();      // 存储查询到的数据的条数
            HttpSession session = req.getSession();
            if(dataSize == 0){    // 未查询到指定数据
                /* 移除上一次上一次的查询结果信息 */
                session.removeAttribute("LIMIT");
                session.removeAttribute("pages");
                PrintWriter writer = resp.getWriter();
                writer.write("<script>");
                writer.write("alert('未查询到指定结果');");
                writer.write("window.location.href='jsp/jobApply.jsp'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }else{    // 查询到指定的数据

                session.setAttribute("LIMIT",LIMIT);
                session.setAttribute("recruitBasicInfoList",recruitBasicInfoList);
                /* 获取分页的数目 */
                if(dataSize % LIMIT == 0){
                    session.setAttribute("pages",dataSize / LIMIT);
                    req.getRequestDispatcher("jsp/jobApply.jsp?page=1").forward(req,resp);
                }else{
                    session.setAttribute("pages",dataSize / LIMIT + 1);
                    req.getRequestDispatcher("jsp/jobApply.jsp?page=1").forward(req,resp);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
