package com.FilmReviewWeb.Servlet.homepage;

import com.FilmReviewWeb.Model.Page;
import com.FilmReviewWeb.Service.GetDetailsService;
import com.FilmReviewWeb.Service.Impl.GetDetailsServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/homepage/getDetails")
public class GetDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        //接受参数
        String currentPageStr = req.getParameter("curentPage");
        String pageSizeStr = req.getParameter("pageSize");
        String cidStr = req.getParameter("cid");

        int cid = 0;//类别id
        //处理参数
        if(cidStr != null && cidStr.length() > 0){
            cid = Integer.parseInt(cidStr);
        }

        int pageSize = 0;//每页显示条数，如果不传递，默认每页显示5条记录
        //处理参数
        if(pageSizeStr != null && pageSizeStr.length() > 0){
            pageSize = Integer.parseInt(pageSizeStr);
        }else{
            pageSize=1;
        }

        int currentPage = 0;//当前页码，如果不传递，则默认为第一页
        //处理参数
        if(currentPageStr != null && currentPageStr.length() > 0){
            currentPage = Integer.parseInt(currentPageStr);
        }else{
            currentPage=1;
        }

        GetDetailsService getDetailsService = new GetDetailsServiceImpl();
        Page page = getDetailsService.pageQuery(cid,currentPage,pageSize);
        resp.getWriter().print(JSON.toJSONString(page));



    }
}
