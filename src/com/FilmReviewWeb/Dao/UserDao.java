package com.FilmReviewWeb.Dao;

import com.FilmReviewWeb.Model.User;
import com.FilmReviewWeb.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * 用户数据库
 * @author HTwo2O
 * @date 2020/5/24 10:12
 */
public class UserDao {
    private Connection connection;
    private PreparedStatement preparedStatement;

    /**
     * 查找所有普通用户信息
     * @return 用户数据List
     * @throws Exception
     */
    public ArrayList<User> seletAllUser()throws Exception{
        connection = JDBCUtils.getConnection();
        String sql = "SELECT user_id,user_name,regist_date,last_online_date FROM USER WHERE POWER=0 ORDER BY user_name";
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<User> users = new ArrayList<User>();
        while (resultSet.next()){
            User user = new User();
            user.setUserId(resultSet.getInt("user_id"));
            user.setUserName(resultSet.getString("user_name"));
            user.setCreatDate(resultSet.getString("regist_date"));
            user.setLastOnlineDate(resultSet.getString("last_online_date"));
            users.add(user);
        }
        JDBCUtils.close(connection,preparedStatement,resultSet);
        return users;
    }
}
