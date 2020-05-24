import com.FilmReviewWeb.Model.User;
import com.FilmReviewWeb.Service.Impl.AdminPageServiceImpl;
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
        ArrayList<User> list = new AdminPageServiceImpl().checkAllUser();
        for (User u: list){
            System.out.println(u);
        }
    }
}
