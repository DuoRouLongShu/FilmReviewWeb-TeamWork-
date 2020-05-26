package com.FilmReviewWeb.Dao;

import com.FilmReviewWeb.Model.User;
import com.FilmReviewWeb.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public User findByUsername(String username) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        User user = new User();
        String sql = "select * from user where user_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,username);
        ResultSet resultSet =  preparedStatement.executeQuery();
        if(resultSet.next()){
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setPassword(resultSet.getString("password"));
                user.setPower(resultSet.getInt("power"));
                user.setCreatDate(resultSet.getString("regist_date"));
        }else{
            user=null;

        }
        JDBCUtils.close(connection,preparedStatement);
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
                "(user_name,password,power,regist_date)" +
                "values (?,LEFT(MD5(?),8),?,now())";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,user.getUserName());
        preparedStatement.setString(2,user.getPassword());
        preparedStatement.setInt(3,user.getPower());
        //数据库更新的条数
        int i = preparedStatement.executeUpdate();
        if (i == 0){
            hasInsert = false;
            return hasInsert;
        }
        String sql1 = "insert information " +
                "(user_name,gender)" +
                "values (?,?)";
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
        preparedStatement1.setString(1,user.getUserName());
        preparedStatement1.setString(2,user.getGender());

        preparedStatement1.executeUpdate();

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
        User user = new User();
        String sql = "select * from user where user_name = ? and password = LEFT(MD5(?),8)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,userName);
        preparedStatement.setString(2,password);
        ResultSet resultSet =  preparedStatement.executeQuery();
        if(resultSet.next()){
            while(resultSet.next()){
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setPassword(resultSet.getString("password"));
                user.setPower(resultSet.getInt("power"));
                user.setCreatDate(resultSet.getString("regist_date"));
            }
        }else{
            user=null;
        }
        JDBCUtils.close(connection,preparedStatement);
        return user;
    }
}
