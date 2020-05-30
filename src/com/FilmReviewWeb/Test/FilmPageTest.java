package com.FilmReviewWeb.Test;

import com.FilmReviewWeb.Model.Film;
import com.FilmReviewWeb.Model.Result;
import com.FilmReviewWeb.Model.Review;
import com.FilmReviewWeb.Service.AdminPageService;
import com.FilmReviewWeb.Service.FilmPageService;
import com.FilmReviewWeb.Service.Impl.AdminPageServiceImpl;
import com.FilmReviewWeb.Service.Impl.FilmPageServiceImpl;
import com.FilmReviewWeb.Utils.SensitiveWordUtils;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author HTwo2O
 * @date 2020/5/13 15:29
 */
public class FilmPageTest {

    @Test
    public void getReviewByFilmNameTest() throws Exception{
        Integer filmId = 6;
        Result result = new Result();
        FilmPageService filmPageService = new FilmPageServiceImpl();
        try {

            ArrayList<Review> reviews = filmPageService.getReviewsByFilmId(filmId);
            if (reviews.isEmpty()){
                result.setDataCount(0);
                result.setData(null);
                result.setMessage("无影评");
                result.setPageCount(0);
            }else {
                result.setDataCount(reviews.size());
                result.setData(reviews);
                result.setMessage("成功获取影评");

                int reviewsCount = reviews.size();
                if(reviewsCount / 5 == 0){
                    result.setPageCount(1);
                }else if(reviewsCount % 5 >0){
                    result.setPageCount(reviews.size() / 5 + 1);
                }else {
                    result.setPageCount(reviews.size()/5);
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(JSON.toJSONString(result));

        /*ArrayList<Review> reviews = new FilmPageServiceImpl().getReviewsByFilmName("早");
        for(Review review : reviews){
            System.out.println(review);
        }*/
    }

    @Test
    public void getFilmDataByFilmNameTest() throws Exception{

        Result result = new Result();
        Integer filmId = Integer.valueOf(6);
        System.out.println(filmId);
        try {

            AdminPageService adminPageService = new AdminPageServiceImpl();
            Film data = adminPageService.checkFilmByFilmId(filmId);
            if (data == null){
                result.setDataCount(0);
                result.setData(null);
                result.setMessage("无电影数据");
                result.setPageCount(0);
            }else {
                result.setDataCount(1);
                result.setData(data);
                result.setMessage("成功返回电影数据");
                result.setPageCount(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void checkLikeTest() throws Exception{
        String userName = "javk";
        String reviewId = "2,3,4,5";
        String[] rr = reviewId.split(",");
        Integer[] reviewIds = new Integer[rr.length];
        for(int i=0; i<rr.length; i++){
            System.out.println(i+" "+rr[i]);
            reviewIds[i] = Integer.valueOf(rr[i]);
        }
        FilmPageService filmPageService = new FilmPageServiceImpl();
        Result result = null;
        try {
            result = filmPageService.checkReviewLike(reviewIds, userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void giveReviewLikeTest() throws Exception{
        FilmPageService filmPageService = new FilmPageServiceImpl();
        Result result = filmPageService.giveReviewLike(2,"javk");
        System.out.println(result);
    }

    @Test
    public void registWordTest(){
        String text =  "傻逼";

        Result result = new Result();
        try {
            boolean isViolation ;
            isViolation = SensitiveWordUtils.isContaintBadWord(text,1);
            System.out.println(isViolation);
            if(isViolation == true){
                result.setMessage("文本违规");
            }else {
                result.setMessage("文本未违规");
            }
            result.setData(isViolation);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(JSON.toJSONString(result));
    }
}
