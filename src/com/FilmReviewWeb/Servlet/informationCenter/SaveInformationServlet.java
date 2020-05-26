package com.FilmReviewWeb.Servlet.informationCenter;

import com.FilmReviewWeb.Model.Information;
import com.FilmReviewWeb.Model.ResultInfo;
import com.FilmReviewWeb.Service.Impl.InformationServiceImpl;
import com.FilmReviewWeb.Service.InformationService;
import com.alibaba.fastjson.JSON;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/information/saveInformation")
public class SaveInformationServlet extends HttpServlet {
    private InformationService informationService = new InformationServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        //获取数据
        Map<String, String[]> map = req.getParameterMap();
        //封装对象
        Information information = new Information();
        try {
            BeanUtils.populate(information,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        boolean flag = informationService.saveInformation(information);
        ResultInfo info = new ResultInfo();
        //4响应结果
        if(flag){
            //保存成功
            info.setFlag(true);
        }else{
            //保存失败
            info.setFlag(false);
            info.setErrorMsg("保存数据失败!");
        }
        resp.getWriter().print(JSON.toJSONString(info));
    }
}
