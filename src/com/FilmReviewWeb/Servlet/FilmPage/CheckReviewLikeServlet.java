package com.FilmReviewWeb.Servlet.FilmPage;

import com.FilmReviewWeb.Model.Result;
import com.FilmReviewWeb.Service.FilmPageService;
import com.FilmReviewWeb.Service.Impl.FilmPageServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 查看是否点赞影评Servlet
 * @author HTwo2O
 * @date 2020/5/21 17:15
 */
@WebServlet("/filmpage/checkReviewLike")
public class CheckReviewLikeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        String userName = req.getParameter("userName");
        Integer reviewId = Integer.valueOf(req.getParameter("reviewId"));
        FilmPageService filmPageService = new FilmPageServiceImpl();
        Result result = null;
        try {
            result = filmPageService.checkReviewLike(reviewId, userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.getWriter().print(JSON.toJSONString(result));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
