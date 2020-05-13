package com.FilmReviewWeb.Dao;

import com.FilmReviewWeb.Model.Review;
import com.FilmReviewWeb.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * 影评数据库
 * @author HTwo2O
 * @date 2020/5/13 15:04
 */
public class ReviewDao {

    public ArrayList<Review> getReviewsByFilmName(String filmName) throws Exception{
        Connection connection = JDBCUtils.getConnection();
        String sql = "select * from review where film_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
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
            String filmId = resultSet.getString("film_id");
            String creatDate = resultSet.getString("creat_date");
            String text = resultSet.getString("text");
            int likes = resultSet.getInt("likes");
            Review review = new Review( reviewId, checkout,  pass,  rating, userName, userId,  filmName,  filmId,  creatDate,  text, likes);
            reviews.add(review);
        }
        return reviews;
    }
}
