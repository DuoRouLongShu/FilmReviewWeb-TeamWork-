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
 * 审核影评Servlet
 *
 * @author HTwo2O
 * @date 2020/5/24 10:10
 */
@WebServlet("/adminPage/auditReview")
public class AuditReviewServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//告诉输出流
        resp.setContentType("text/html;charset=UTF-8");//告诉浏览器
        Integer reviewId = Integer.valueOf(req.getParameter("reviewId"));
        Integer pass = Integer.valueOf(req.getParameter("pass"));
        Result result = new Result();
        AdminPageServiceImpl adminPageService = new AdminPageServiceImpl();
        try {
            boolean hasAudit = adminPageService.auditReview(reviewId, pass);
            result.setMessage("审核成功");
            if(pass == 0){
                result.setData("不通过");
            }else {
                result.setData("通过");
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
