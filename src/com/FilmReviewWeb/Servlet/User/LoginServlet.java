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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=UTF-8");
        //验证校验
        String check = req.getParameter("checkcode");

        //从session中获取验证码
        HttpSession session = req.getSession();
        String checkcode_server = (String)session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//保证验证码只使用一次

        //比较
        if(checkcode_server==null||!checkcode_server.equalsIgnoreCase(check)){
            //验证码错误
            ResultInfo info = new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
            resp.getWriter().print(JSON.toJSONString(info));
            System.out.println(checkcode_server+"---"+check);
            return;
        }

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
        System.out.println(user);

        //调用Service查询
        UserService service = new UserServiceImpl();
        User u = null;
        try {
            u = service.login(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(u);
        ResultInfo info = new ResultInfo();
        //判断用户对象是否为null
        if(u==null){
            //用户名或密码错误
            System.out.println("登录失败");
            info.setFlag(false);
            info.setErrorMsg("用户名不存在或密码错误");

        }

        //判断登录成功
        if(u!=null){
            //登录成功
            System.out.println("登录成功");
            info.setFlag(true);
            // 将用户名,id保存在session中
            session.setAttribute("userName", user.getUserName());
            session.setAttribute("userId",user.getUserId());
        }
        //响应数据
        resp.getWriter().print(JSON.toJSONString(info));

    }
}

