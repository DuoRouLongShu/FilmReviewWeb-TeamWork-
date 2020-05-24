package com.FilmReviewWeb.Dao;

import com.FilmReviewWeb.Model.Feedback;
import com.FilmReviewWeb.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * 反馈数据库
 * @author HTwo2O
 * @date 2020/5/24 14:06
 */
public class FeedbackDao {
    private Connection connection;
    private PreparedStatement preparedStatement;

    /**
     * 查看所有反馈
     * @return
     * @throws Exception
     */
    public ArrayList<Feedback> selectAllFeedback()throws Exception{
        connection = JDBCUtils.getConnection();
        String sql = "select * from feedback order by feedback_id desc";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Feedback> feedbacks = new ArrayList<Feedback>();
        while (resultSet.next()){
            Feedback feedback = new Feedback();
            feedback.setCreatDate(resultSet.getString("creat_date"));
            feedback.setText(resultSet.getString("text"));
            feedback.setFeedbackId(resultSet.getInt("feedback_id"));
            feedback.setUserId(resultSet.getInt("user_id"));
            feedback.setUserName(resultSet.getString("user_name"));
            feedbacks.add(feedback);
        }
        JDBCUtils.close(connection,preparedStatement,resultSet);
        return feedbacks;
    }
}
