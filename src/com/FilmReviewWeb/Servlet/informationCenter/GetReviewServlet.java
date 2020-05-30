package com.FilmReviewWeb.Servlet.informationCenter;

import com.FilmReviewWeb.Model.Result;
import com.FilmReviewWeb.Model.Review;
import com.FilmReviewWeb.Service.Impl.ReviewServiceImpl;
import com.FilmReviewWeb.Service.ReviewService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/information/getReview")
public class GetReviewServlet extends HttpServlet {
    private ReviewService reviewService = new ReviewServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        //从session中获取登录用户
        Object user = req.getSession().getAttribute("userName");
        Result result = new Result();
        //1.根据用户名查询用户影评
        List<Review> reviews;
        reviews = reviewService.findReview((String)user);
        if (reviews.isEmpty()){
            result.setDataCount(0);
            result.setData(null);
            result.setMessage("无影评");
            result.setPageCount(0);
        }else {
            result.setDataCount(reviews.size());
            result.setData(reviews);
            result.setMessage("成功获取影评");

            int reviewsCount = reviews.size();
            if(reviewsCount / 5 == 0){
                result.setPageCount(1);
            }else if(reviewsCount % 5 >0){
                result.setPageCount(reviews.size() / 5 + 1);
            }else {
                result.setPageCount(reviews.size()/5);
            }

        }

        resp.getWriter().print(JSON.toJSONString(result));
    }
}
