package com.FilmReviewWeb.Service;

import com.FilmReviewWeb.Model.User;

import java.util.ArrayList;

/**
 * 管理员中心Service
 * @author HTwo2O
 * @date 2020/5/24 10:27
 */
public interface AdminPageService {
    /**
     * 查看所有用户
     * @return
     * @throws Exception
     */
    public ArrayList<User> checkAllUser() throws Exception;
}
