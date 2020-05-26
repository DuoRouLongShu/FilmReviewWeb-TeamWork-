package com.FilmReviewWeb.Servlet.AdminPage;

import com.FilmReviewWeb.Model.Result;
import com.FilmReviewWeb.Service.Impl.AdminPageServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除电影Servlet
 *
 * @author HTwo2O
 * @date 2020/5/24 10:10
 */
@WebServlet("/adminPage/deleteFilm")
public class DeleteFilmServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//告诉输出流
        resp.setContentType("text/html;charset=UTF-8");//告诉浏览器
        Integer filmId = Integer.valueOf(req.getParameter("filmId"));
        System.out.println(filmId);
        Result result = new Result();
        AdminPageServiceImpl adminPageService = new AdminPageServiceImpl();
        try {
            boolean hasDelete = adminPageService.deleteFilmById(filmId);

            if(hasDelete == false){
                result.setData(false);
                result.setMessage("未删除");
            }else {
                result.setData(true);
                result.setMessage("已删除");
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
