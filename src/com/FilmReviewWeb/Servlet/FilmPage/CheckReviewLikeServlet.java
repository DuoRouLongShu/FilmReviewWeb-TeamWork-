package com.FilmReviewWeb.Servlet.FilmPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 查看是否点赞影评Servlet
 * @author HTwo2O
 * @date 2020/5/21 17:15
 */
@WebServlet("/filmpage/checkReviewLike")
public class CheckReviewLikeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        String userName = req.getParameter("userName");
        String[] reviewIds1 = req.getParameterValues("reviewId[]");
        System.out.println(reviewIds1[0]);
        System.out.println(reviewIds1[2]);
//        String[] rr = reviewId.split(",");
//        Integer[] reviewIds = new Integer[rr.length];
//        for(int i=0; i<rr.length; i++){
//            System.out.println(i+" "+rr[i]);
//            reviewIds[i] = Integer.valueOf(rr[i]);
//        }
//        FilmPageService filmPageService = new FilmPageServiceImpl();
//        Result result = null;
//        try {
//            result = filmPageService.checkReviewLike(reviewIds, userName);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        resp.getWriter().print(JSON.toJSONString(result));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
