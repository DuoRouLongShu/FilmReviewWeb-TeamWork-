package com.FilmReviewWeb.Service.Impl;

import com.FilmReviewWeb.Dao.UserDao;
import com.FilmReviewWeb.Model.User;
import com.FilmReviewWeb.Service.AdminPageService;

import java.util.ArrayList;

/**
 * @author HTwo2O
 * @date 2020/5/24 10:29
 */
public class AdminPageServiceImpl implements AdminPageService {
    @Override
    public ArrayList<User> checkAllUser() throws Exception {
        return new UserDao().seletAllUser();
    }
}
