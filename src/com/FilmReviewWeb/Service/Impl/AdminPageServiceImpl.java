package com.FilmReviewWeb.Service.Impl;

import com.FilmReviewWeb.Dao.FeedbackDao;
import com.FilmReviewWeb.Dao.ReviewDao;
import com.FilmReviewWeb.Dao.UserDao;
import com.FilmReviewWeb.Model.Feedback;
import com.FilmReviewWeb.Model.Review;
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

    @Override
    public ArrayList<Feedback> checkAllFeedback() throws Exception {
        return new FeedbackDao().selectAllFeedback();
    }

    @Override
    public ArrayList<Review> checkNonCheckedReview() throws Exception {
        return new ReviewDao().getNonCheckedReviews();
    }

    @Override
    public boolean auditReview(Integer reviewId, Integer pass) throws Exception {
        return new ReviewDao().updateReviewPass(reviewId, pass);
    }


}
