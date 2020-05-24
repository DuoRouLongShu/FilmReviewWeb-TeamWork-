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
    private Connection connection;
    private PreparedStatement preparedStatement;


    /**
     * 通过电影名向数据库中获得并返回相关影评
     * @param filmName
     * @return
     * @throws Exception
     */
    public ArrayList<Review> getReviewsByFilmName(String filmName) throws Exception{
        connection = JDBCUtils.getConnection();
        String sql = "select * from review where film_name = ? AND (`check` =0 OR pass=1)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,filmName);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Review> reviews = new ArrayList<Review>();
        while (resultSet.next()){
            int reviewId = resultSet.getInt("review_id");
            int check = resultSet.getInt("check");
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
            Review review = new Review( reviewId, check,  pass,  rating, userName, userId,  filmName,  filmId,  creatDate,  text, likes,title);
            reviews.add(review);
        }
        JDBCUtils.close(connection,preparedStatement,resultSet);
        return reviews;
    }

    public boolean insertReview(Review review) throws Exception{
        connection = JDBCUtils.getConnection();
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

    /**
     * 给影评增加点赞数
     * @param reviewId
     * @return
     */
    public int giveThumb_up(Integer reviewId) throws Exception{
        connection = JDBCUtils.getConnection();
        String sql = "UPDATE review SET likes = likes + 1 WHERE review_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,reviewId);
        int updateCount =preparedStatement.executeUpdate();
        JDBCUtils.close(connection,preparedStatement);
        return updateCount;
    }

    /**
     * 给影评减少点赞数
     * @param reviewId
     * @return
     */
    public int cancelLike(Integer reviewId) throws Exception{
        connection = JDBCUtils.getConnection();
        String sql = "UPDATE review SET likes = likes - 1 WHERE review_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,reviewId);
        int updateCount =preparedStatement.executeUpdate();
        JDBCUtils.close(connection,preparedStatement);
        return updateCount;
    }

    /**
     * 查看未审核的影评
     * @return
     * @throws Exception
     */
    public ArrayList<Review> getNonCheckedReviews() throws Exception{
        connection = JDBCUtils.getConnection();
        String sql = "select * from review where `check`=0";
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Review> reviews = new ArrayList<Review>();
        while (resultSet.next()){
            Review review = new Review();
            int reviewId = resultSet.getInt("review_id");
            float rating = resultSet.getFloat("rating");
            String userName = resultSet.getString("user_name");
            int userId = resultSet.getInt("user_id");
            int filmId = resultSet.getInt("film_id");
            String filmName = resultSet.getString("film_name");
            String creatDate = resultSet.getString("creat_date");
            String text = resultSet.getString("text");
            int likes = resultSet.getInt("likes");
            String title = resultSet.getString("title");

            review.setRating(rating);
            review.setText(text);
            review.setTitle(title);
            review.setUserName(userName);
            review.setFilmName(filmName);
            review.setFilmId(filmId);
            review.setCreatDate(creatDate);
            review.setLikes(likes);
            review.setReviewId(reviewId);
            review.setUserId(userId);

            reviews.add(review);
        }
        JDBCUtils.close(connection,preparedStatement,resultSet);
        return reviews;
    }

    /**
     * 审核并更新影评的通过情况
     * @param reviewId
     * @param pass
     * @return
     * @throws Exception
     */
    public boolean updateReviewPass(Integer reviewId, Integer pass) throws Exception {
        connection = JDBCUtils.getConnection();
        String sql = "update review set `check`=1,pass=? where review_id=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, pass);
        preparedStatement.setInt(2, reviewId);
        int update = preparedStatement.executeUpdate();
        return (update == 0? false: true);
    }
}
