import com.FilmReviewWeb.Model.*;
import com.FilmReviewWeb.Service.AdminPageService;
import com.FilmReviewWeb.Service.Impl.AdminPageServiceImpl;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 管理员页面Test
 * @author HTwo2O
 * @date 2020/5/24 10:30
 */
public class AdminPageTest {

    @Test
    public void checkAllUserTest() throws Exception{
        int currentPageNumber = 1;

        PageResult pageResult = new PageResult();
        AdminPageServiceImpl adminPageService = new AdminPageServiceImpl();

        HashMap<String, Object> map = new HashMap<>();
        ArrayList<User> users = new ArrayList<User>();
        int totalDataCount = 0;
        try {
            map = adminPageService.checkAllUser(currentPageNumber, 8);
            users = (ArrayList<User>) map.get("users");
            totalDataCount = (int) map.get("totalDataCount");
        } catch (Exception e) {
            e.printStackTrace();
        }
        pageResult.setMessage("成功查询未审核影评");
        pageResult.setData(users);
        int dataCount = users.size();
        pageResult.setCurrentDataCount(dataCount);
        pageResult.setTotalDataCount(totalDataCount);
        pageResult.setCurrentPageNumber(currentPageNumber);
        if (dataCount / 8 == 0) {
            pageResult.setTotalPageCount(1);
        } else if (dataCount % 8 > 0) {
            pageResult.setTotalPageCount(dataCount / 8 + 1);
        } else {
            pageResult.setTotalPageCount(dataCount / 8);
        }

        System.out.println(JSON.toJSONString(pageResult));
    }

    @Test
    public void checkAllFeedbackTest()throws Exception{
        int currentPageNumber = 1;

        PageResult pageResult = new PageResult();
        AdminPageServiceImpl adminPageService = new AdminPageServiceImpl();

        HashMap<String, Object> map = new HashMap<>();
        ArrayList<Feedback> feedbacks = new ArrayList<Feedback>();
        int totalDataCount = 0;
        try {
            map = adminPageService.checkAllFeedback(currentPageNumber, 8);
            feedbacks = (ArrayList<Feedback>) map.get("feedbacks");
            totalDataCount = (int) map.get("totalDataCount");
        } catch (Exception e) {
            e.printStackTrace();
        }
        pageResult.setMessage("成功查询未审核影评");
        pageResult.setData(feedbacks);
        int dataCount = feedbacks.size();
        pageResult.setCurrentDataCount(dataCount);
        pageResult.setTotalDataCount(totalDataCount);
        pageResult.setCurrentPageNumber(currentPageNumber);
        if (dataCount / 8 == 0) {
            pageResult.setTotalPageCount(1);
        } else if (dataCount % 8 > 0) {
            pageResult.setTotalPageCount(dataCount / 8 + 1);
        } else {
            pageResult.setTotalPageCount(dataCount / 8);
        }

        System.out.println(JSON.toJSONString(pageResult));
    }

    @Test
    public void checkNonCheckedReviewTest()throws Exception{
        Integer currentPageNumber = 1;

        PageResult pageResult = new PageResult();
        AdminPageServiceImpl adminPageService = new AdminPageServiceImpl();

        HashMap<String, Object> map = new HashMap<>();
        ArrayList<Review> reviews = new ArrayList<Review>();
        int totalDataCount = 0;

        try {
            map = adminPageService.checkNonCheckedReview(currentPageNumber, 8);
            reviews = (ArrayList<Review>) map.get("reviews");
            totalDataCount = (int) map.get("totalDataCount");
        } catch (Exception e) {
            e.printStackTrace();
        }

        pageResult.setMessage("成功查询未审核影评");
        pageResult.setData(reviews);
        int dataCount = reviews.size();
        pageResult.setCurrentDataCount(dataCount);
        pageResult.setTotalDataCount(totalDataCount);
        pageResult.setCurrentPageNumber(currentPageNumber);
        if (dataCount / 8 == 0) {
            pageResult.setTotalPageCount(1);
        } else if (dataCount % 8 > 0) {
            pageResult.setTotalPageCount(dataCount / 8 + 1);
        } else {
            pageResult.setTotalPageCount(dataCount / 8);
        }

        System.out.println(JSON.toJSONString(pageResult));
    }
    @Test
    public void auditReview()throws Exception{
        Integer reviewId = 9;
        Integer pass = 1;
        Result result = new Result();
        AdminPageServiceImpl adminPageService = new AdminPageServiceImpl();
        try {
            boolean hasAudit = adminPageService.auditReview(reviewId, pass);
            result.setMessage("审核成功");
            if(pass == 0){
                result.setData("不通过");
            }else {
                result.setData("通过");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(JSON.toJSONString(result));
    }
    @Test
    public void addFilmTest()throws Exception{
        Film film = new Film();
        film.setFilmName("阿凡达");
        film.setWriter("卡梅隆");
        /*film.setPerformer("鹿晗、舒淇");
        film.setArea("中国");
        film.setDuration("120min");
        film.setSynopsis("很多年以后，外星入侵了地区...");
        film.setLanguage("中文/英文");
        boolean b = new AdminPageServiceImpl().addFilm(film);
        System.out.println(b);*/



        Result result = new Result();
        try {
            AdminPageService adminPageService = new AdminPageServiceImpl();
            boolean hasAdd = adminPageService.addFilm(film);
            if(hasAdd == true){
                result.setData(true);
                result.setMessage("添加电影成功");
            }else {
                result.setData(false);
                result.setMessage("添加电影失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void dealFeedbackTest(){
        Integer feedbackId = 1;
        Integer deal = 0;
        Result result = new Result();
        AdminPageServiceImpl adminPageService = new AdminPageServiceImpl();
        try {
            boolean hasDeal = adminPageService.dealFeedback(feedbackId, deal);
            if (hasDeal == true){
                result.setMessage("处理反馈成功");
                result.setData(true);
            }else {
                result.setMessage("处理反馈失败");
                result.setData(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void checkAllFilmTest(){
        PageResult pageResult = new PageResult();
        AdminPageServiceImpl adminPageService = new AdminPageServiceImpl();
        int currentPageNumber = 1;
        HashMap<String, Object> map = new HashMap<>();
        ArrayList<Film> films = new ArrayList<Film>();
        int totalDataCount = 0;
        try {
            map = adminPageService.checkAllFilm(currentPageNumber, 8);
            films = (ArrayList<Film>) map.get("films");
            totalDataCount = (int) map.get("totalDataCount");
        } catch (Exception e) {
            e.printStackTrace();
        }
        pageResult.setMessage("成功查询未审核影评");
        pageResult.setData(films);
        int dataCount = films.size();
        pageResult.setCurrentDataCount(dataCount);
        pageResult.setTotalDataCount(totalDataCount);
        pageResult.setCurrentPageNumber(currentPageNumber);
        if (dataCount / 8 == 0) {
            pageResult.setTotalPageCount(1);
        } else if (dataCount % 8 > 0) {
            pageResult.setTotalPageCount(dataCount / 8 + 1);
        } else {
            pageResult.setTotalPageCount(dataCount / 8);
        }

        System.out.println(JSON.toJSONString(pageResult));
    }

    @Test
    public void deleteFilmTest(){
        Integer filmId = 1;
        Result result = new Result();
        AdminPageServiceImpl adminPageService = new AdminPageServiceImpl();
        try {
            boolean hasDelete = adminPageService.deleteFilmById(filmId);
            if(hasDelete == false){
                result.setData(false);
                result.setMessage("未删除");
            }else {
                result.setData(true);
                result.setMessage("已删除");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void updateFilmTest(){
        Integer filmId = 3;
        String filmName = "明日边缘";
        String director = null;
        String writer = null;
        String performer = "汤姆克鲁斯";
        String genre = "悬疑";
        String area = "美国";
        String language = "英文";
        String duration = null;
        String synopsis = null;
        String releaseDate = null;
        String imageSource = null;
        Result result = new Result();
        Film film = new Film(filmId,filmName,null, director, writer, performer, genre,  area, language, duration, synopsis, releaseDate, imageSource);
        try {
            AdminPageService adminPageService = new AdminPageServiceImpl();
            boolean hasUpdate = adminPageService.updateFilm(film);
            if(hasUpdate == true){
                result.setData(true);
                result.setMessage("修改电影成功");
            }else {
                result.setData(false);
                result.setMessage("修改电影失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void selectFilmById(){
        Result result = new Result();
        Integer filmId = 3;
        System.out.println(filmId);
        try {

            AdminPageService adminPageService = new AdminPageServiceImpl();
            Film film = adminPageService.checkFilmByFilmId(filmId);
            if (film == null){
                result.setMessage("无电影数据");
            }else {
                result.setData(film);
                result.setMessage("成功返回电影数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(JSON.toJSONString(result));
    }
}
