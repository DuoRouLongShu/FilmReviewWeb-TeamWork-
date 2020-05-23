package com.FilmReviewWeb.Servlet.Search;

import com.FilmReviewWeb.Model.Film;
import com.FilmReviewWeb.Model.Result;
import com.FilmReviewWeb.Service.Impl.SearchServiceImpl;
import com.FilmReviewWeb.Service.SearchService;
import com.alibaba.fastjson.JSON;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 搜索Servlet
 *
 * @author HTwo2O
 * @date 2020/5/13 14:34
 */
@WebServlet("/search/searchFilm")
public class SearchServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        String keyword = req.getParameter("keyword");
        SearchService searchService = new SearchServiceImpl();
        List<Film> films = searchService.searchFilmByKeyword(keyword);
        Result result = new Result();
        int size = films.size();
        if (size == 0) {
            result.setMessage("无搜索结果");
        } else {
            result.setMessage("成功返回搜索结果");
        }
        result.setDataCount(size);
        result.setData(films);
        if (size / 6 == 0) {
            result.setPageCount(1);
        } else if (size % 6 > 0) {
            result.setPageCount(size / 6 + 1);
        } else {
            result.setPageCount(size / 6);
        }
        resp.getWriter().print(JSON.toJSONString(result));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

}
