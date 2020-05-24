package com.FilmReviewWeb.Servlet.AdminPage;

import com.FilmReviewWeb.Model.Result;
import com.FilmReviewWeb.Model.Review;
import com.FilmReviewWeb.Service.Impl.AdminPageServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 查看未审核影评Servlet
 *
 * @author HTwo2O
 * @date 2020/5/24 10:10
 */
@WebServlet("/adminPage/checkNonCheckedReview")
public class CheckNonCheckedReviewServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//告诉输出流
        resp.setContentType("text/html;charset=UTF-8");//告诉浏览器
        Result result = new Result();
        AdminPageServiceImpl adminPageService = new AdminPageServiceImpl();
        ArrayList<Review> reviews = null;
        try {
            reviews = adminPageService.checkNonCheckedReview();
            System.out.println(reviews);
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.setData(reviews);
        result.setMessage("成功查询未审核影评");
        int dataCount = reviews.size();
        result.setDataCount(dataCount);
        if (dataCount / 8 == 0) {
            result.setPageCount(1);
        } else if (dataCount % 8 > 0) {
            result.setPageCount(dataCount / 8 + 1);
        } else {
            result.setPageCount(dataCount / 8);
        }
        resp.getWriter().print(JSON.toJSONString(result));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
