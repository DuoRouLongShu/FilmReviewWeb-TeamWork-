package com.FilmReviewWeb.Dao;

import com.FilmReviewWeb.Model.Feedback;
import com.FilmReviewWeb.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

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
    public HashMap<String, Object> selectAllFeedback(Integer currentPageNumber, Integer pageSize)throws Exception{
        connection = JDBCUtils.getConnection();
        String sql = "SELECT * FROM feedback ORDER BY `read`,creat_date DESC LIMIT ?,?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, (currentPageNumber-1)*pageSize);
        preparedStatement.setInt(2, pageSize);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Feedback> feedbacks = new ArrayList<Feedback>();
        while (resultSet.next()){
            Feedback feedback = new Feedback();
            feedback.setCreatDate(resultSet.getString("creat_date"));
            feedback.setText(resultSet.getString("text"));
            feedback.setFeedbackId(resultSet.getInt("feedback_id"));
            feedback.setUserId(resultSet.getInt("user_id"));
            feedback.setUserName(resultSet.getString("user_name"));
            feedback.setRead(resultSet.getInt("read"));
            feedbacks.add(feedback);
        }
        sql = "SELECT COUNT(*) FROM feedback  ";
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int totalDataCount = resultSet.getInt(1);
        JDBCUtils.close(connection, this.preparedStatement,resultSet);
        HashMap<String, Object> map = new HashMap();
        map.put("feedbacks", feedbacks);
        map.put("totalDataCount",totalDataCount);
        return map;
    }

    /**
     * 将影评置为已读
     * @param feedbackId
     * @return 是否成功更新
     * @throws Exception
     */
    public boolean readFeedback(Integer feedbackId) throws Exception {
        connection = JDBCUtils.getConnection();
        String sql = "update feedback set `read`=1 where feedback_id=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, feedbackId);
        int update = preparedStatement.executeUpdate();
        return (update == 0? false: true);
    }

    /**
     * 删除反馈
     * @param feedbackId
     * @return 是否删除成功
     * @throws Exception
     */
    public boolean deleteFeedback(Integer feedbackId) throws Exception {
        connection = JDBCUtils.getConnection();
        String sql = "DELETE FROM feedback  where feedback_id=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, feedbackId);
        int update = preparedStatement.executeUpdate();
        return (update == 0? false: true);
    }
}
