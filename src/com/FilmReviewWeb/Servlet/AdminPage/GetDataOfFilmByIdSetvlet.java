package com.FilmReviewWeb.Servlet.AdminPage;

import com.FilmReviewWeb.Model.Film;
import com.FilmReviewWeb.Model.Result;
import com.FilmReviewWeb.Service.AdminPageService;
import com.FilmReviewWeb.Service.Impl.AdminPageServiceImpl;
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
@WebServlet("/adminPage/getFilmDataById")
public class GetDataOfFilmByIdSetvlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        //resp.setHeader("Access-Control-Allow-Origin", "*");
        Result result = new Result();
        Integer filmId = Integer.valueOf(req.getParameter("filmId"));
        System.out.println(filmId);
        try {

            AdminPageService adminPageService = new AdminPageServiceImpl();
            Film film = adminPageService.checkFilmByFilmId(filmId);
            if (film == null){
                result.setMessage("无电影数据");
            }else {
                result.setData(film);
                result.setMessage("成功返回电影数据");
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
