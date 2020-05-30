package com.FilmReviewWeb.Dao;


import com.FilmReviewWeb.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 影评点赞数据库
 * @author HTwo2O
 * @date 2020/5/21 17:18
 */
public class ReviewLikeDao {
    private Connection connection;
    private PreparedStatement preparedStatement;


    /**
     * 查找是否存在用户和某影评直接是否存在点赞数据,true代表有,false代表无
     * @param reviewId
     * @param userName
     */
    public boolean selectLike(Integer reviewId, String userName) throws SQLException {
        connection = JDBCUtils.getConnection();
        ResultSet resultSet = null;
        boolean hasLike ;
        String sql = "select * from review_like where review_id = ? and user_name = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, reviewId);
        preparedStatement.setString(2, userName);
        resultSet = preparedStatement.executeQuery();
        hasLike = resultSet.next();
        JDBCUtils.close(connection,preparedStatement,resultSet);
         return hasLike;
    }

    public int insertReviewLike(Integer reviewId, String userName) throws Exception{
        connection = JDBCUtils.getConnection();
        String sql = "insert review_like (review_id, user_name) values (?, ?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, reviewId);
        preparedStatement.setString(2,userName);
        int updateCount = preparedStatement.executeUpdate();
        JDBCUtils.close(connection,preparedStatement);
        return updateCount;
    }

    public int deleteReviewLike(Integer reviewId, String userName) throws Exception{
        connection = JDBCUtils.getConnection();
        String sql = "DELETE FROM review_like where review_id = ? and user_name = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, reviewId);
        preparedStatement.setString(2,userName);
        int updateCount = preparedStatement.executeUpdate();
        JDBCUtils.close(connection,preparedStatement);
        return updateCount;
    }
}
