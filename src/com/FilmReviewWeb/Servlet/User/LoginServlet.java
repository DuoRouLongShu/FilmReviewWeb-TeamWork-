package com.FilmReviewWeb.Servlet.User;

import com.FilmReviewWeb.Model.ResultInfo;
import com.FilmReviewWeb.Model.User;
import com.FilmReviewWeb.Service.Impl.UserServiceImpl;
import com.FilmReviewWeb.Service.UserService;
import com.alibaba.fastjson.JSON;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        //获取用户名和密码数据
        Map<String, String[]> map = req.getParameterMap();
        //封装User对象
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用Service查询
        UserService service = new UserServiceImpl();
        User u = null;
        try {
            u = service.login(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultInfo info = new ResultInfo();
        //判断用户对象是否为null
        if(u==null){
            //用户名或密码错误
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误");

        }

        //判断登录成功
        if(u!=null){
            //登录成功
            info.setFlag(true);
        }
        //响应数据
        resp.getWriter().print(JSON.toJSONString(info));

    }
}

