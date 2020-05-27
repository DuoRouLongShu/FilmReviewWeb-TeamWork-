package com.FilmReviewWeb.Dao;

import com.FilmReviewWeb.Model.Category;
import com.FilmReviewWeb.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

    /**
     * 查询所有
     * @return
     */
    public List<Category> findAll() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        List<Category> categoryList = new ArrayList<>();
        String sql = "select * from category";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet =  preparedStatement.executeQuery();

        while(resultSet.next()){
            Category category = new Category();
            category.setCid(resultSet.getInt("cid"));
            category.setCname(resultSet.getString("cname"));
            categoryList.add(category);
        }


        JDBCUtils.close(connection,preparedStatement,resultSet);
        return categoryList;
    }
}
