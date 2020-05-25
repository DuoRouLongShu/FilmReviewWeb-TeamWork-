import com.FilmReviewWeb.Model.*;
import com.FilmReviewWeb.Service.AdminPageService;
import com.FilmReviewWeb.Service.Impl.AdminPageServiceImpl;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;

/**
 * 管理员页面Test
 * @author HTwo2O
 * @date 2020/5/24 10:30
 */
public class AdminPageTest {

    @Test
    public void checkAllUserTest() throws Exception{
        Result result = new Result();
        AdminPageServiceImpl adminPageService = new AdminPageServiceImpl();
        ArrayList<User> users = null;
        try {
            users = adminPageService.checkAllUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.setData(users);
        result.setMessage("成功查询用户信息");
        int dataCount = users.size();
        result.setDataCount(dataCount);
        if (dataCount / 4 == 0) {
            result.setPageCount(1);
        } else if (dataCount % 4 > 0) {
            result.setPageCount(dataCount / 4 + 1);
        } else {
            result.setPageCount(dataCount / 4);
        }
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void checkAllFeedbackTest()throws Exception{
        Result result = new Result();
        AdminPageServiceImpl adminPageService = new AdminPageServiceImpl();
        ArrayList<Feedback> feedbacks = null;
        try {
            feedbacks = adminPageService.checkAllFeedback();
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.setData(feedbacks);
        result.setMessage("成功查询用户反馈");
        int dataCount = feedbacks.size();
        result.setDataCount(dataCount);
        if (dataCount / 8 == 0) {
            result.setPageCount(1);
        } else if (dataCount % 8 > 0) {
            result.setPageCount(dataCount / 8 + 1);
        } else {
            result.setPageCount(dataCount / 8);
        }
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void checkNonCheckedReviewTest()throws Exception{
        ArrayList<Review> reviews = new AdminPageServiceImpl().checkNonCheckedReview();
        for (Review r: reviews){
            System.out.println(r);
        }
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
}
