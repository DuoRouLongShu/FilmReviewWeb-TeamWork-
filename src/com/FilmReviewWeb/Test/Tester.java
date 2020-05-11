import com.FilmReviewWeb.Utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author HTwo2O
 * @date 2020/5/10 20:37
 */
public class Tester {

    /**
     * 测试junit
     */
    @Test
    public void testJunit(){
        System.out.println("junit可以成功运行");
    }

    /**
     * 测试druid
     */
    @Test
    public void testDruid(){
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            connection = JDBCUtils.getConnection();preparedStatement = connection.prepareStatement("select * from user");
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String name = resultSet.getString("userName");
            JDBCUtils.close(connection,preparedStatement,resultSet);
            System.out.println(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

        }
    }

}
