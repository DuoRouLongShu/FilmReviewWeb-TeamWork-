package com.FilmReviewWeb.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 个人中心、点赞、写影评等需要登录的情景
 * @author HTwo2O
 * @date 2020/5/24 21:12
 */
@WebFilter(urlPatterns = {"/search/personalCenter"})
public class LoginFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        // 获得访问界面的url文件地址

        String requestURI = req.getRequestURI();
        String queryString = req.getQueryString();
        HttpSession session = req.getSession();
        // 获取登录状态
        String userName = (String) session.getAttribute("userName");

        if (userName != null) {
            //已经登录
            chain.doFilter(request, response);
        } else {
            // 登录失败，跳转到登录页，并保证当前网页的url文件路径
            StringBuilder returnUri = new StringBuilder("requestURI");
            if(queryString != null){
                returnUri.append("?"+queryString);
            }
            req.setAttribute("returnUri", returnUri.toString());
            resp.sendRedirect("Login.html");
        }

    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
