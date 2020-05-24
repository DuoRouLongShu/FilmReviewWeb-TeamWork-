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
@WebServlet("/user/registUser")
public class RegistUserServlet extends HttpServlet {
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
            return;
        }
        //获取数据
        Map<String, String[]> map = req.getParameterMap();
        //封装对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user);
        //调用service完成注册
        UserService service = new UserServiceImpl();
        boolean flag = false;
        try {
            flag = service.regist(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultInfo info = new ResultInfo();
        //4响应结果
        if(flag){
            //注册成功
            info.setFlag(true);
        }else{
            //注册失败
            info.setFlag(false);
            info.setErrorMsg("用户已存在，注册失败!");
        }
/*        //将info对象序列化为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);
        //将json数据写回客户端
        //设置content-type
        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().write(json);*/
        resp.getWriter().print(JSON.toJSONString(info));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
