package com.FilmReviewWeb.Service.Impl;

import com.FilmReviewWeb.Dao.PersonalReviewDao;
import com.FilmReviewWeb.Model.Review;
import com.FilmReviewWeb.Service.ReviewService;

import java.util.List;

public class ReviewServiceImpl implements ReviewService {
    private PersonalReviewDao reviewDao = new PersonalReviewDao();
    @Override
    public List<Review> findReview(String userName) {
        try {
            return reviewDao.getReviewsByUserName(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
