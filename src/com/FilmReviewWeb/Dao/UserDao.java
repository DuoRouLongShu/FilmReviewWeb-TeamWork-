package com.FilmReviewWeb.Dao;


import com.FilmReviewWeb.Model.User;
import com.FilmReviewWeb.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public HashMap<String, Object> seletAllUser(Integer currentPageNumber, Integer pageSize)throws Exception {
        connection = JDBCUtils.getConnection();
        String sql = "SELECT user_id,user_name,regist_date,last_online_date FROM USER WHERE power=0  ORDER BY user_name LIMIT ?,?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, (currentPageNumber - 1) * pageSize);
        preparedStatement.setInt(2, pageSize);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<User> users = new ArrayList<User>();
        while (resultSet.next()) {
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
        JDBCUtils.close(connection, this.preparedStatement, resultSet);
        HashMap<String, Object> map = new HashMap();
        map.put("users", users);
        map.put("totalDataCount", totalDataCount);
        return map;
    }
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public User findByUsername(String username) throws SQLException {
        connection = JDBCUtils.getConnection();
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
                user.setRegistDate(resultSet.getString("regist_date"));
        }else{
            user=null;

        }
        JDBCUtils.close(connection,preparedStatement);
        return user;
    }

    /**
     * 用户保存
     * @param user
     */
    public boolean save(User user) throws SQLException{
        boolean hasInsert = true;
        connection = JDBCUtils.getConnection();
        String sql = "insert user " +
                "(user_name,password,power,regist_date)" +
                "values (?,LEFT(MD5(?),8),?,now())";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,user.getUserName());
        preparedStatement.setString(2,user.getPassword());
        preparedStatement.setInt(3,0);
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
        System.out.println("hasinset"+hasInsert);
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
        connection = JDBCUtils.getConnection();
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
                user.setRegistDate(resultSet.getString("regist_date"));
            }
        }else{
            user=null;
        }
        JDBCUtils.close(connection,preparedStatement);
        System.out.println("dao:"+user);
        return user;
    }
}
