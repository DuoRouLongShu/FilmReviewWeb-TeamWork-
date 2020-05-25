package com.FilmReviewWeb.Servlet.FilmPage;

import com.FilmReviewWeb.Model.Result;
import com.FilmReviewWeb.Utils.SensitiveWordUtils;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录用户名敏感词检测Servlet
 * @author HTwo2O
 * @date 2020/5/22 11:12
 */
@WebServlet("/filmpage/RegistUserNameDetection")
public class RegistUserNameDetectionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        String text =  req.getParameter("userName");
        Result result = new Result();
        try {
            boolean isViolation ;
            isViolation = SensitiveWordUtils.isContaintBadWord(text,1);
            if(isViolation == true){
                result.setMessage("文本违规");
            }else {
                result.setMessage("文本未违规");
            }
            result.setData(isViolation);
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
