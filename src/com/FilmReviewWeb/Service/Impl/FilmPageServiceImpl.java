//package com.FilmReviewWeb.Service.Impl;
//
//import com.FilmReviewWeb.Dao.FilmDao;
//import com.FilmReviewWeb.Dao.ReviewDao;
//import com.FilmReviewWeb.Model.Film;
//import com.FilmReviewWeb.Model.Review;
//import com.FilmReviewWeb.Service.FilmPageService;
//
//import java.util.ArrayList;
//
///**
// * @author HTwo2O
// * @date 2020/5/13 15:03
// */
//public class FilmPageServiceImpl implements FilmPageService {
//    @Override
//    public boolean writeAReview(Review review) throws Exception {
//        return new ReviewDao().insertReview(review);
//    }
//
//    @Override
//    public ArrayList<Review> getReviewsByFilmName(String filmName) throws Exception{
//        return new ReviewDao().getReviewsByFilmName(filmName);
//    }
//
//    @Override
//    public Film getFilmDataByFilmName(String fileNmae) throws Exception {
//        return new FilmDao().getFilmDataByFilmName(fileNmae);
//    }
//}
