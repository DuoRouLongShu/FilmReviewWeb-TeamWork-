package com.FilmReviewWeb.Dao;

import com.FilmReviewWeb.Model.User;
import com.FilmReviewWeb.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public User findByUsername(String username) throws SQLException {

        Connection connection = JDBCUtils.getConnection();
        String sql = "select * from user where username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,username);
        User user = (User) preparedStatement.executeQuery();

        return user;
    };

    /**
     * 用户保存
     * @param user
     */
    public boolean save(User user) throws SQLException{
        boolean hasInsert = true;
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert user " +
                "(user_id,user_name,password,power)" +
                "values (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,user.getUserId());
        preparedStatement.setString(2,user.getUserName());
        preparedStatement.setString(3,user.getPassword());
        preparedStatement.setInt(4,user.getPower());
        //数据库更新的条数
        int i = preparedStatement.executeUpdate();
        if (i == 0){
            hasInsert = false;
        }
        JDBCUtils.close(connection,preparedStatement);
        return hasInsert;
    }

    /**
     * 根据用户名查询密码
     * @param userName
     * @param password
     * @return
     */
    public User findByUsernameAndPassword(String userName, String password) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "select * from user where username = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,userName);
        User user = (User) preparedStatement.executeQuery();

        return user;
    }
}
