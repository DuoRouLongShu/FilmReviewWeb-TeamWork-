package com.FilmReviewWeb.Dao;

import com.FilmReviewWeb.Model.Film;
import com.FilmReviewWeb.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 电影数据库
 * @author HTwo2O
 * @date 2020/5/13 15:51
 */
public class FilmDao {
    private Connection connection;
    private PreparedStatement preparedStatement;


    /**
     * 通过电影名获得并返回电影相关数据
     * @param filmName
     * @return
     * @throws SQLException
     */
    public Film getFilmDataByFilmName(String filmName) throws SQLException {
        connection = JDBCUtils.getConnection();
        String sql = "select * from film where film_name = ?";
        preparedStatement = connection.prepareStatement(sql);
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
            String releaseDate = resultSet.getString("release_date");
            String imageSource = resultSet.getString("image_source");
            film = new Film(filmId,  filmName, rating, director, writer, performer,  genre, area, language, duration,  synopsis, releaseDate,imageSource);
        }
        JDBCUtils.close(connection,preparedStatement,resultSet);
        return film;
    }

    /**
     * 通过关键词搜索电影数据库
     * @param keyword
     * @return
     * @throws Exception
     */
    public List<Film> getFilmsByKeyword(String keyword)throws Exception{
        connection = JDBCUtils.getConnection();
        String sql = "SELECT * FROM film WHERE LOCATE(?,film_name) = 1 " +
                "UNION " +
                "SELECT * FROM film WHERE LOCATE(?,film_name) > 1 " +
                "UNION " +
                "SELECT * FROM film WHERE LOCATE(?, CONCAT(IFNULL(`director`,''),IFNULL(`writer`,''),IFNULL(`performer`,''))) > 0; ";

        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,keyword);
        preparedStatement.setString(2,keyword);
        preparedStatement.setString(3,keyword);
        ResultSet resultSet =preparedStatement.executeQuery();
        Film film ;
        ArrayList<Film> films = new ArrayList<Film>() ;
        while (resultSet.next()){
            int filmId = resultSet.getInt("film_id");
            String filmName = resultSet.getString("film_name");
            //评分
            float rating =  resultSet.getFloat("rating");
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
            //发布日期
            String releaseDate = resultSet.getString("release_date");
            //海报图片地址
            String imageSource = resultSet.getString("image_source");
            film = new Film(filmId,  filmName, rating, director, writer, performer,  genre, area, language, duration,  synopsis, releaseDate,imageSource);
            films.add(film);
        }
        JDBCUtils.close(connection,preparedStatement,resultSet);
        return films;
    }
}
