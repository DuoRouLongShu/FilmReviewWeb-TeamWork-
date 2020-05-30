package com.FilmReviewWeb.Servlet.AdminPage;


import com.FilmReviewWeb.Model.PageResult;
import com.FilmReviewWeb.Model.User;
import com.FilmReviewWeb.Service.Impl.AdminPageServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 查看所有用户数据Servlet
 *
 * @author HTwo2O
 * @date 2020/5/24 10:10
 */
@WebServlet("/adminPage/checkAllUser")
public class CheckAllUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//告诉输出流
        resp.setContentType("text/html;charset=UTF-8");//告诉浏览器

        int currentPageNumber = Integer.valueOf(req.getParameter("pageNumber"));

        PageResult pageResult = new PageResult();
        AdminPageServiceImpl adminPageService = new AdminPageServiceImpl();

        HashMap<String, Object> map = new HashMap<>();
        ArrayList<User> users = new ArrayList<User>();
        int totalDataCount = 0;
        try {
            map = adminPageService.checkAllUser(currentPageNumber, 8);
            users = (ArrayList<User>) map.get("users");
            totalDataCount = (int) map.get("totalDataCount");
        } catch (Exception e) {
            e.printStackTrace();
        }
        pageResult.setMessage("成功查询未审核影评");
        pageResult.setData(users);
        int dataCount = users.size();
        pageResult.setCurrentDataCount(dataCount);
        pageResult.setTotalDataCount(totalDataCount);
        pageResult.setCurrentPageNumber(currentPageNumber);
        if (totalDataCount / 8 == 0) {
            pageResult.setTotalPageCount(1);
        } else if (totalDataCount % 8 > 0) {
            pageResult.setTotalPageCount(totalDataCount / 8 + 1);
        } else {
            pageResult.setTotalPageCount(totalDataCount / 8);
        }

        resp.getWriter().print(JSON.toJSONString(pageResult));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
