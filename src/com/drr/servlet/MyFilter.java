package com.drr.servlet;

import com.drr.entity.Applicant;
import com.drr.entity.Company;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/jsp/*",
        dispatcherTypes = DispatcherType.REQUEST,
        servletNames = {"com.drr.servlet.jobApplyBasicInfoServlet",
                        "com.drr.servlet.RecruitBasicInfoServlet",
                        "com.drr.servlet.jobApplyFindServlet",
                        "com.drr.servlet.PassApplyServlet",
                        "com.drr.servlet.PassServlet",
                        "com.drr.servlet.ResumeBasicInfoAddServlet"
                        })
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        /* 用户权限设置*/
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        Applicant applicant = (Applicant) session.getAttribute("applicant");
        Company company = (Company) session.getAttribute("company");
        if(applicant != null || company != null){   // 已经登录
            filterChain.doFilter(servletRequest,servletResponse);
        }else{   // 未登录，跳转登录界面
            servletRequest.getRequestDispatcher("../login.html").forward(servletRequest,servletResponse);
            return;
        }
    }

}
