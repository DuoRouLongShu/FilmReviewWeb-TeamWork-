package com.FilmReviewWeb.Service;

import com.FilmReviewWeb.Model.Film;

import java.util.HashMap;

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
    public HashMap<String, Object> checkAllUser(Integer currentPageNumber, Integer pageSize) throws Exception;

    /**
     * 查看所有反馈
     * @return
     * @throws Exception
     */
    public HashMap<String, Object> checkAllFeedback(Integer currentPageNumber, Integer pageSize) throws Exception;

    /**
     * 分页查看为审核影评
     * @return 存放reviews和totalDataCount的Map
     * @throws Exception
     */
    public HashMap<String, Object> checkNonCheckedReview(Integer currentPageNumber, Integer pageSize) throws Exception;

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

    /**
     * 处理反馈
     * @return
     * @throws Exception
     */
    public boolean dealFeedback(Integer feedbackId, Integer deal) throws Exception;

    /**
     * 查看所有电影
     * @param currentPageNumber
     * @param pageSize
     * @return
     * @throws Exception
     */
    public HashMap<String, Object> checkAllFilm(Integer currentPageNumber, Integer pageSize) throws Exception;

    /**
     * 根据filmId删除film
     * @param filmId
     * @return
     * @throws Exception
     */
    public boolean deleteFilmById(Integer filmId) throws Exception;

    /**
     * 根据id修改film
     * @param film
     * @return
     * @throws Exception
     */
    public boolean updateFilm(Film film) throws Exception;
}
