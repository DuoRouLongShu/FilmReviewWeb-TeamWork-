package com.FilmReviewWeb.Service;

import com.FilmReviewWeb.Model.Review;

import java.util.List;

public interface ReviewService {
    public List<Review> findReview(String userName);
}
