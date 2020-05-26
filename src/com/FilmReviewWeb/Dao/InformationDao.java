package com.FilmReviewWeb.Dao;

import com.FilmReviewWeb.Model.Information;
import com.FilmReviewWeb.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InformationDao {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public Information findByUsername(String username) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        Information information = new Information();
        String sql = "select  user.user_name, petName, gender, birthday, hobby, email,signature,imageResource from information LEFT OUTER JOIN user on (user.user_name=information.user_name) and user.user_name=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            information.setUserName(resultSet.getString("user.user_name"));
            information.setPetName(resultSet.getString("petName"));
            information.setGender(resultSet.getString("gender"));
            information.setBirthday(resultSet.getString("birthday"));
            information.setHobby(resultSet.getString("hobby"));
            information.setEmail(resultSet.getString("email"));
            information.setImageResource(resultSet.getString("imageResource"));
            information.setSignature(resultSet.getString("signature"));
        }
        JDBCUtils.close(connection, preparedStatement);
        return information;
    }


    /**
     * 用户信息保存
     * @param information
     * @return
     * @throws SQLException
     */
    public boolean saveInformation(Information information) throws SQLException{
        boolean hasInsert = true;
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert information " +
                "(user_name,petName,birthday,hobby,email,signature,imageResource,gender)" +
                "values (?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,information.getUserName());
        preparedStatement.setString(2,information.getPetName());
        preparedStatement.setString(3,information.getBirthday());
        preparedStatement.setString(4,information.getHobby());
        preparedStatement.setString(5,information.getEmail());
        preparedStatement.setString(6,information.getSignature());
        preparedStatement.setString(7,information.getImageResource());
        preparedStatement.setString(8,information.getGender());
        //数据库更新的条数
        int i = preparedStatement.executeUpdate();
        if (i == 0){
            hasInsert = false;
        }
        JDBCUtils.close(connection,preparedStatement);
        return hasInsert;
    }
}
