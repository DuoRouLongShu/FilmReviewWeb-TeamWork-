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
 * 影评敏感词检测Servlet
 * @author HTwo2O
 * @date 2020/5/22 11:12
 */
@WebServlet("/filmpage/sensitiveWordDetection")
public class ReviewSensitiveWordDetectionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        String text =  req.getParameter("text");
        FilmPageService filmPageService = new FilmPageServiceImpl();
        String processedText = null;
        try {
            processedText = filmPageService.replaceSensitiveWord(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Result result = new Result();
        result.setData(processedText);
        resp.getWriter().print(JSON.toJSONString(result));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
