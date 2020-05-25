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
 * 添加电影Servlet
 * @author HTwo2O
 * @date 2020/5/24 10:10
 */
@WebServlet("/adminPage/addFilm")
public class AddFilmServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//告诉输出流
        resp.setContentType("text/html;charset=UTF-8");//告诉浏览器

        /*film_name,director,writer,performer," +
        "genre,area,language,duration,synopsis,release_date,image_source;*/
        Result result = new Result();
        String filmName = req.getParameter("filmName");
        if(filmName == null){
            result.setMessage("未添加用户名");
            result.setData(0);
            resp.getWriter().print(JSON.toJSONString(result));
        }
        String director = req.getParameter("director");
        String writer = req.getParameter("writer");
        String performer = req.getParameter("performer");
        String genre = req.getParameter("genre");
        String area = req.getParameter("area");
        String language = req.getParameter("language");
        String duration = req.getParameter("duration");
        String synopsis = req.getParameter("synopsis");
        String releaseDate = req.getParameter("releaseDate");
        String imageSource = req.getParameter("imageSource");
        Film film = new Film(null,filmName,null, director, writer, performer, genre,  area, language, duration, synopsis, releaseDate, imageSource);
        try {
            AdminPageService adminPageService = new AdminPageServiceImpl();
            boolean hasAdd = adminPageService.addFilm(film);
            if(hasAdd == true){
                result.setData(true);
                result.setMessage("添加电影成功");
            }else {
                result.setData(false);
                result.setMessage("添加电影失败");
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
