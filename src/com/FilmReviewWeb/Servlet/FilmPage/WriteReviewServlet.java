package com.FilmReviewWeb.Servlet.FilmPage;

import com.FilmReviewWeb.Model.Result;
import com.FilmReviewWeb.Model.Review;
import com.FilmReviewWeb.Service.FilmPageService;
import com.FilmReviewWeb.Service.Impl.FilmPageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 写影评Servlet
 * @author HTwo2O
 * @date 2020/5/16 0:14
 */
@WebServlet("/filmpage/writeReview")
public class WriteReviewServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        /*Review review = new Review();
        review.setFilmName(req.getParameter("filmName"));
        review.setUserName(req.getParameter("userName"));
        review.setTitle(req.getParameter("title"));
        review.setText(req.getParameter("text"));
        float rating = Float.valueOf(req.getParameter("rating"));
        review.setRating(rating);*/
        Review review = new Review(Float.valueOf(req.getParameter("rating")),
                req.getParameter("userName"),
                req.getParameter("filmName"),
                req.getParameter("text"),
                req.getParameter("title"));
        FilmPageService filmPageService = new FilmPageServiceImpl();
        Result result = new Result();
        try {
            boolean hasWrite = filmPageService.writeAReview(review);
            if(hasWrite == true){
                result.setMessage("成功");
            }else {
                result.setMessage("失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("../Movie.html");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
