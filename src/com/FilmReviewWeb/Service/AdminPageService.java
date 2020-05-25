package com.FilmReviewWeb.Service;

import com.FilmReviewWeb.Model.Feedback;
import com.FilmReviewWeb.Model.Film;
import com.FilmReviewWeb.Model.Review;
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

    /**
     * 查看所有反馈
     * @return
     * @throws Exception
     */
    public ArrayList<Feedback> checkAllFeedback() throws Exception;

    /**
     * 查看为审核影评
     * @return
     * @throws Exception
     */
    public ArrayList<Review> checkNonCheckedReview() throws Exception;

    /**
     * 审核影评
     * @param reviewId
     * @param pass
     * @return 是否审核成功
     * @throws Exception
     */
    public boolean auditReview(Integer reviewId, Integer pass) throws Exception;

    /**
     * 添加电影
     * @param film
     * @return 是否添加成功
     * @throws Exception
     */
    public boolean addFilm(Film film) throws Exception;
}
