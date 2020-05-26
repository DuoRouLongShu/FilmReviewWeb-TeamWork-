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
 * 处理反馈Servlet
 *
 * @author HTwo2O
 * @date 2020/5/24 10:10
 */
@WebServlet("/adminPage/dealFeedback")
public class DealFeedbackServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//告诉输出流
        resp.setContentType("text/html;charset=UTF-8");//告诉浏览器
        Integer feedbackId = Integer.valueOf(req.getParameter("feedbackId"));
        Integer deal = Integer.valueOf(req.getParameter("deal"));
        Result result = new Result();
        AdminPageServiceImpl adminPageService = new AdminPageServiceImpl();
        try {
            boolean hasDeal = adminPageService.dealFeedback(feedbackId, deal);
            if (hasDeal == true){
                result.setMessage("处理反馈成功");
                if(deal == 0){
                    result.setData("已删除");
                }else {
                    result.setData("已读");
                }
            }else {
                result.setMessage("处理反馈失败");
                result.setData(false);
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
