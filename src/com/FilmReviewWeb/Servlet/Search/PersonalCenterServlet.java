package com.FilmReviewWeb.Servlet.Search;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HTwo2O
 * @date 2020/5/27 15:54
 */
@WebServlet("/search/personalCenter")
public class PersonalCenterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        int power = (int)req.getSession().getAttribute("power");
        if(power == 0){
            resp.sendRedirect("普通用户");
        }else if(power == 1){
            resp.sendRedirect("管理员");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
