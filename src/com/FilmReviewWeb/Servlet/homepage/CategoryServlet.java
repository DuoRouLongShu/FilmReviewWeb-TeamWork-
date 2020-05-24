package com.FilmReviewWeb.Servlet.homepage;

import com.FilmReviewWeb.Model.Category;
import com.FilmReviewWeb.Service.CategoryService;
import com.FilmReviewWeb.Service.Impl.CategoryServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;
@WebServlet("/homepage/category")
public class CategoryServlet extends HttpServlet {
    private CategoryService service = new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        findAll(req,resp);
    }

    /**
     * 查询所有
     * @param req
     * @param resp
     * @throws ServletException
     */
    public void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, UnsupportedEncodingException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        //调用service查询所有
        List<Category> cs = null;
        try {
            cs = service.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //序列化json数据
        try {
            resp.getWriter().print(JSON.toJSONString(cs));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
