package com.FilmReviewWeb.Service.Impl;

import com.FilmReviewWeb.Dao.UserDao;
import com.FilmReviewWeb.Model.User;
import com.FilmReviewWeb.Service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDao();

    /**
     * 用户名注册校验
     * @param username
     * @return
     */
    public boolean validateUsername(String username){

        try {
            return userDao.validateUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) throws SQLException {
        //1.根据用户名查询用户对象
        User u = userDao.findByUsername(user.getUserName());
        //判断u是否为null
        if(u != null){
            //用户名存在，注册失败
        }
        //2.保存用户信心
        return false;
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @Override
    public User login(User user) throws SQLException {


        return userDao.findByUsernameAndPassword(user.getUserName(), user.getPassword());
    }
}
