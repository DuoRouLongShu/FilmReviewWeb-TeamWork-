package com.FilmReviewWeb.Servlet.informationCenter;

import com.FilmReviewWeb.Model.Information;
import com.FilmReviewWeb.Service.Impl.InformationServiceImpl;
import com.FilmReviewWeb.Service.InformationService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/information/getInformation")
public class GetInformationServlet extends HttpServlet {

    private InformationService informationService = new InformationServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //从session中获取登录用户
        Object user = req.getSession().getAttribute("userName");

        //1.根据用户名查询用户信息
        Information information;
        information = informationService.findInformation((String)user);

        resp.getWriter().print(JSON.toJSONString(information));
    }
}
