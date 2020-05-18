import com.FilmReviewWeb.Model.Film;
import com.FilmReviewWeb.Model.Review;
import com.FilmReviewWeb.Service.FilmPageService;
import com.FilmReviewWeb.Service.Impl.FilmPageServiceImpl;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author HTwo2O
 * @date 2020/5/13 15:29
 */
public class FilmPageTest {

    @Test
    public void getReviewByFilmNameTest() throws Exception{
        FilmPageService filmPageService = new FilmPageServiceImpl();
        ArrayList<Review> reviews = filmPageService.getReviewsByFilmName("早");
        for(Review review : reviews){
            System.out.println(review);
        }
    }

    @Test
    public void getFilmDataByFilmNameTest() throws Exception{
        FilmPageService filmPageService = new FilmPageServiceImpl();
        Film film = filmPageService.getFilmDataByFilmName("倾国倾城");
        System.out.println(film);
    }
}
