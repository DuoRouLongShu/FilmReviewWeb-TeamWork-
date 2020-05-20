package com.FilmReviewWeb.Dao;

import com.FilmReviewWeb.Model.Review;
import com.FilmReviewWeb.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 影评数据库
 * @author HTwo2O
 * @date 2020/5/13 15:04
 */
public class ReviewDao {
    private static Connection connection;
    private PreparedStatement preparedStatement;

    static {
        try {
            connection = JDBCUtils.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过电影名向数据库中获得并返回相关影评
     * @param filmName
     * @return
     * @throws Exception
     */
    public ArrayList<Review> getReviewsByFilmName(String filmName) throws Exception{
        String sql = "select * from review where film_name = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,filmName);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Review> reviews = new ArrayList<Review>();
        while (resultSet.next()){
            int reviewId = resultSet.getInt("review_id");
            int checkout = resultSet.getInt("check");
            int pass = resultSet.getInt("pass");
            float rating = resultSet.getFloat("rating");
            String userName = resultSet.getString("user_name");
            int userId = resultSet.getInt("user_id");
            //String filmName;
            int filmId = resultSet.getInt("film_id");
            String creatDate = resultSet.getString("creat_date");
            String text = resultSet.getString("text");
            int likes = resultSet.getInt("likes");
            String title = resultSet.getString("title");
            Review review = new Review( reviewId, checkout,  pass,  rating, userName, userId,  filmName,  filmId,  creatDate,  text, likes,title);
            reviews.add(review);
        }
        JDBCUtils.close(connection,preparedStatement,resultSet);
        return reviews;
    }

    public boolean insertReview(Review review) throws Exception{
        boolean hasInsert = true;
        String sql = "insert review " +
                "(user_name,film_name,text,title,rating,creat_date)" +
                "values (?,?,?,?,?,now())";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,review.getUserName());
        preparedStatement.setString(2,review.getFilmName());
        preparedStatement.setString(3,review.getText());
        preparedStatement.setString(4,review.getTitle());
        preparedStatement.setFloat(5,review.getRating());
        //数据库更新的条数
        int i = preparedStatement.executeUpdate();
        if (i == 0){
            hasInsert = false;
        }
        JDBCUtils.close(connection,preparedStatement);
        return hasInsert;
    }
}
