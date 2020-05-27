package com.FilmReviewWeb.Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 普通用户中心鉴权过滤器
 * @author HTwo2O
 * @date 2020/5/24 21:12
 */
//@WebFilter(urlPatterns = "个人中心")
public class UserCenterFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;

        int power = (int)req.getSession().getAttribute("power");
        if(power == 0){
            chain.doFilter(request,response);
        }else {
            //提示无权访问
        }

    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
