package com.FilmReviewWeb.Dao;

import com.FilmReviewWeb.Model.Film;
import com.FilmReviewWeb.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 电影数据库
 * @author HTwo2O
 * @date 2020/5/13 15:51
 */
public class FilmDao {
    public Film getFilmDataByFilmName(String filmName) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "select * from film where film_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,filmName);
        ResultSet resultSet = preparedStatement.executeQuery();
        Film film = null;
        while (resultSet.next()){
            int filmId = resultSet.getInt("film_id");
            //String filmName;
            //评分
            float rating = resultSet.getFloat("rating");
            //导演
            String director = resultSet.getString("director");
            String writer = resultSet.getString("writer");
            String performer = resultSet.getString("performer");
            //题材
            String genre = resultSet.getString("genre");
            String area = resultSet.getString("area");
            String language = resultSet.getString("language");
            //片长
            String duration = resultSet.getString("duration");
            //概要
            String synopsis = resultSet.getString("synopsis");
            film = new Film(filmId,  filmName, rating, director, writer, performer,  genre, area, language, duration,  synopsis);  
        }
        return film;
    }
}
