package com.FilmReviewWeb.Servlet.FilmPage;

import com.FilmReviewWeb.Model.Result;
import com.FilmReviewWeb.Model.Review;
import com.FilmReviewWeb.Service.FilmPageService;
import com.FilmReviewWeb.Service.Impl.FilmPageServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**获取影评servlet
 * @author HTwo2O
 * @date 2020/5/13 14:30
 */
@WebServlet("/filmpage/getReviews")
public class GetReviewsOfAFilmServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        //resp.setHeader("Access-Control-Allow-Origin", "*");
        String filmName = req.getParameter("filmName");
        Result result = new Result();
        FilmPageService filmPageService = new FilmPageServiceImpl();
        try {

            ArrayList<Review> reviews = filmPageService.getReviewsByFilmName(filmName);
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


        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.getWriter().print(JSON.toJSONString(result));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
