package com.FilmReviewWeb.Dao;

import com.FilmReviewWeb.Model.User;
import com.FilmReviewWeb.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

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
    public HashMap<String, Object> seletAllUser(Integer currentPageNumber, Integer pageSize)throws Exception{
        connection = JDBCUtils.getConnection();
        String sql = "SELECT user_id,user_name,regist_date,last_online_date FROM USER WHERE power=0  ORDER BY user_name LIMIT ?,?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, (currentPageNumber-1)*pageSize);
        preparedStatement.setInt(2, pageSize);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<User> users = new ArrayList<User>();
        while (resultSet.next()){
            User user = new User();
            user.setUserId(resultSet.getInt("user_id"));
            user.setUserName(resultSet.getString("user_name"));
            user.setRegistDate(resultSet.getString("regist_date"));
            user.setLastOnlineDate(resultSet.getString("last_online_date"));
            users.add(user);
        }
        sql = "SELECT COUNT(*) FROM user WHERE POWER=0 ";
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int totalDataCount = resultSet.getInt(1);
        JDBCUtils.close(connection, this.preparedStatement,resultSet);
        HashMap<String, Object> map = new HashMap();
        map.put("users", users);
        map.put("totalDataCount",totalDataCount);
        return map;
    }
}
