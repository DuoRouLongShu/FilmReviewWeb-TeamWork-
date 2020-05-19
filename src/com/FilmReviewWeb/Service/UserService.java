package com.FilmReviewWeb.Service;

import com.FilmReviewWeb.Model.User;

import java.sql.SQLException;

public interface UserService {
    /**
     * 注册用户
     * @param user
     * @return
     */
    boolean regist(User user) throws SQLException;

    User login(User user);
}
