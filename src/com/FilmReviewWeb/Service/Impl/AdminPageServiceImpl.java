package com.FilmReviewWeb.Service.Impl;

import com.FilmReviewWeb.Dao.FeedbackDao;
import com.FilmReviewWeb.Dao.FilmDao;
import com.FilmReviewWeb.Dao.ReviewDao;
import com.FilmReviewWeb.Dao.UserDao;
import com.FilmReviewWeb.Model.Film;
import com.FilmReviewWeb.Service.AdminPageService;

import java.util.HashMap;

/**
 * @author HTwo2O
 * @date 2020/5/24 10:29
 */
public class AdminPageServiceImpl implements AdminPageService {
    @Override
    public HashMap<String, Object> checkAllUser(Integer currentPageNumber, Integer pageSize) throws Exception {
        return new UserDao().seletAllUser(currentPageNumber, pageSize);
    }

    @Override
    public HashMap<String, Object> checkAllFeedback(Integer currentPageNumber, Integer pageSize) throws Exception {
        return new FeedbackDao().selectAllFeedback(currentPageNumber, pageSize);
    }

    @Override
    public HashMap<String, Object> checkNonCheckedReview(Integer currentPageNumber, Integer pageSize) throws Exception {
        return new ReviewDao().getNonCheckedReviews(currentPageNumber,  pageSize);
    }

    @Override
    public boolean auditReview(Integer reviewId, Integer pass) throws Exception {
        return new ReviewDao().updateReviewPass(reviewId, pass);
    }

    @Override
    public boolean addFilm(Film film) throws Exception {
        return new FilmDao().insertFilm(film);
    }

    @Override
    public boolean dealFeedback(Integer feedbackId, Integer deal) throws Exception {
        if(deal.equals(0)){
            FeedbackDao feedbackDao = new FeedbackDao();
            boolean hasDelete = feedbackDao.deleteFeedback(feedbackId);
            return hasDelete;
        }else {
            FeedbackDao feedbackDao = new FeedbackDao();
            boolean hasRead = feedbackDao.readFeedback(feedbackId);
            return hasRead;
        }

    }

    @Override
    public HashMap<String, Object> checkAllFilm(Integer currentPageNumber, Integer pageSize) throws Exception {
        return new FilmDao().seletAllFilm(currentPageNumber, pageSize);
    }

    @Override
    public boolean deleteFilmById(Integer filmId) throws Exception {
        return new FilmDao().deleteFilmById(filmId);
    }

    @Override
    public boolean updateFilm(Film film) throws Exception {
        return new FilmDao().updateFilm(film);
    }

    @Override
    public Film checkFilmByFilmId(Integer filmId) throws Exception {
        return new FilmDao().getFilmDataByFilmId(filmId);
    }
}
