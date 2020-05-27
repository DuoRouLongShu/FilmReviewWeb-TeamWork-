package com.FilmReviewWeb.Dao;


import com.FilmReviewWeb.Model.Slideshow;
import com.FilmReviewWeb.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

;

public class SlideshowDao {
    /**
     * 查询所有
     * @return
     */
    public List<Slideshow> findAll() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        List<Slideshow> slideshows = new ArrayList<>();
        String sql = "select * from slideshow";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet =  preparedStatement.executeQuery();
        while(resultSet.next()){
            Slideshow slideshow = new Slideshow();
            slideshow.setId(resultSet.getInt("id"));
            slideshow.setImageSource(resultSet.getString("img_src"));
            slideshows.add(slideshow);
        }


        JDBCUtils.close(connection,preparedStatement,resultSet);
        return slideshows;
    }
}
