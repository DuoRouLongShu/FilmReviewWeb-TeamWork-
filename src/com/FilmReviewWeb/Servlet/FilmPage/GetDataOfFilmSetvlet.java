package com.FilmReviewWeb.Servlet.FilmPage;

import com.FilmReviewWeb.Model.Film;
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
 * 获得电影数据Servlet
 * @author HTwo2O
 * @date 2020/5/13 15:52
 */
@WebServlet("/filmpage/getData")
public class GetDataOfFilmSetvlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        //resp.setHeader("Access-Control-Allow-Origin", "*");
        Result result = new Result();
        String filmName = req.getParameter("filmName");
        System.out.println(filmName);
        try {

            FilmPageService filmPageService = new FilmPageServiceImpl();
            Film data = filmPageService.getFilmDataByFilmName(filmName);
            if (data == null){
                result.setDataCount(0);
                result.setData(null);
                result.setMessage("无电影数据");
                result.setPageCount(0);
            }else {
                result.setDataCount(1);
                result.setData(data);
                result.setMessage("成功返回电影数据");
                result.setPageCount(1);
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
