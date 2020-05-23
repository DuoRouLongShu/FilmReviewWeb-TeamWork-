package com.FilmReviewWeb.Service.Impl;

import com.FilmReviewWeb.Dao.FilmDao;
import com.FilmReviewWeb.Dao.ReviewDao;
import com.FilmReviewWeb.Dao.ReviewLikeDao;
import com.FilmReviewWeb.Model.Film;
import com.FilmReviewWeb.Model.Result;
import com.FilmReviewWeb.Model.Review;
import com.FilmReviewWeb.Service.FilmPageService;
import com.FilmReviewWeb.Utils.SensitiveWordUtils;

import java.util.ArrayList;

/**
 * @author HTwo2O
 * @date 2020/5/13 15:03
 */
public class FilmPageServiceImpl implements FilmPageService {
    @Override
    public boolean writeAReview(Review review) throws Exception {
        return new ReviewDao().insertReview(review);
    }

    @Override
    public ArrayList<Review> getReviewsByFilmName(String filmName) throws Exception{
        return new ReviewDao().getReviewsByFilmName(filmName);
    }

    @Override
    public Film getFilmDataByFilmName(String fileNmae) throws Exception {
        return new FilmDao().getFilmDataByFilmName(fileNmae);
    }

    @Override
    public Result giveReviewLike(Integer reviewId, String userName) throws Exception {
        ReviewLikeDao reviewLikeDao = new ReviewLikeDao();
        //flag为true代表已经点赞，flase代表未点赞
        boolean flag = reviewLikeDao.selectLike(reviewId, userName);
        Result result = new Result();
        ReviewDao reviewDao = new ReviewDao();
        if(flag == true){
            //取消点赞
            reviewLikeDao.deleteReviewLike(reviewId, userName);
            reviewDao.cancelLike(reviewId);
            result.setMessage("成功取消点赞");
            result.setData(false);
        }else {
            reviewLikeDao.insertReviewLike(reviewId, userName);
            reviewDao.giveThumb_up(reviewId);
            result.setMessage("成功点赞");
            result.setData(true);
        }
        return result;
    }

    @Override
    public String replaceSensitiveWord(String text) throws Exception {
        String processedText = SensitiveWordUtils.replaceBadWord(text, 2, "*");
        return processedText;
    }

    @Override
    public Result checkReviewLike(Integer reviewId, String userName) throws Exception {
        Result result = new Result();
        ReviewLikeDao reviewLikeDao = new ReviewLikeDao();
        boolean hasLike = reviewLikeDao.selectLike(reviewId, userName);
        if (hasLike == true){
            result.setMessage("已经点赞");
            result.setData(true);
        }else {
            result.setMessage("未点赞");
            result.setData(false);
        }
        return result;
    }
}
