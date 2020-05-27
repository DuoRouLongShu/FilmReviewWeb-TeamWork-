package com.FilmReviewWeb.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HTwo2O
 * @date 2020/5/24 21:12
 */
@WebFilter(urlPatterns = "/*")
public class CrossOriginFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        // 响应标头指定 指定可以访问资源的URI路径
        response.setHeader("Access-Control-Allow-Origin", "*");

        //响应标头指定响应访问所述资源到时允许的一种或多种方法
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");

        //设置 缓存可以生存的最大秒数
        response.setHeader("Access-Control-Max-Age", "3600");

        //设置  受支持请求标头
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");

        // 指示的请求的响应是否可以暴露于该页面。当true值返回时它可以被暴露
        response.setHeader("Access-Control-Allow-Credentials","true");

        chain.doFilter(request, response);

    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
