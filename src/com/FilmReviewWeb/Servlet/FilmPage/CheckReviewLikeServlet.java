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
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        String userName = (String) req.getSession().getAttribute("userName");
        String[] reviewId = req.getParameterValues("reviewId[]");
        /*String[] rr = reviewId.split(",");*/
        Integer[] reviewIds = new Integer[reviewId.length];
        for(int i=0; i<reviewId.length; i++){
            System.out.println(i+" "+reviewId[i]);
            reviewIds[i] = Integer.valueOf(reviewId[i]);
        }
        FilmPageService filmPageService = new FilmPageServiceImpl();
        Result result = null;
        try {
            result = filmPageService.checkReviewLike(reviewIds, userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.getWriter().print(JSON.toJSONString(result));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
