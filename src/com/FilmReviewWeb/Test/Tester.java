package com.FilmReviewWeb.Test;

import com.FilmReviewWeb.Model.Film;
import com.FilmReviewWeb.Utils.JDBCUtils;
import com.FilmReviewWeb.Utils.SensitiveWordUtils;
import com.FilmReviewWeb.Utils.TimeUtils;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.Set;

/**
 * @author HTwo2O
 * @date 2020/5/10 20:37
 */
public class Tester {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    String sql;
    @Before
    public void before() throws Exception{
        connection = JDBCUtils.getConnection();

    }

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

        try {
            preparedStatement = connection.prepareStatement("select * from user");
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String name = resultSet.getString("user_name");
            JDBCUtils.close(connection,preparedStatement,resultSet);
            System.out.println(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

        }
    }

    @Test
    public void testMysqlDate() throws Exception {
        sql = "insert test (creat_data) values (now())";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
        JDBCUtils.close(connection,preparedStatement);

    }

    @Test
    public void testGetDataTimeFromMySQL() throws Exception{
        sql = "select * from test";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        Timestamp timestamp = resultSet.getTimestamp("creat_data");
        String time = TimeUtils.DBTimestamptoString(timestamp);
        System.out.println(time);
        JDBCUtils.close(connection,preparedStatement,resultSet);
    }


    @Test
    public void testLombok(){
        Film film = new Film();
        film.setArea("xx");
    }

    @Test
    public void sensetiveWordUtilsTest(){
        String s = "傻逼狗逼全家暴毙";
        long beginTime = System.currentTimeMillis();
        Set<String> set = SensitiveWordUtils.getBadWord(s,2);
        long endTime = System.currentTimeMillis();
        System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);
        System.out.println("总共消耗时间为：" + (endTime - beginTime)+ "ms");
    }
}
