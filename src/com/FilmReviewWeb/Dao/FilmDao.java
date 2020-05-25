package com.FilmReviewWeb.Dao;

import com.FilmReviewWeb.Model.Film;
import com.FilmReviewWeb.Utils.JDBCUtils;

import java.sql.*;
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

    /**
     * 添加电影
     * @param film
     * @return是否成功添加电影
     */
    public boolean insertFilm(Film film)throws Exception{
        connection = JDBCUtils.getConnection();
        String sql = "insert film (film_name,director,writer,performer," +
                "genre,area,language,duration,synopsis,release_date,image_source) " +
                "values " +
                "(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, film.getFilmName());
        String row;
        //导演
        if((row = film.getDirector()) != null){
            preparedStatement.setString(2,row);
        }else {
            preparedStatement.setNull(2, Types.VARCHAR);
        }
        //编辑
        if((row = film.getWriter()) != null){
            preparedStatement.setString(3,row);
        }else {
            preparedStatement.setNull(3, Types.VARCHAR);
        }
        //演员
        if((row = film.getPerformer()) != null){
            preparedStatement.setString(4,row);
        }else {
            preparedStatement.setNull(4, Types.VARCHAR);
        }
        //题材
        if((row = film.getGenre()) != null){
            preparedStatement.setString(5,row);
        }else {
            preparedStatement.setNull(5, Types.VARCHAR);
        }
        //地区
        if((row = film.getArea()) != null){
            preparedStatement.setString(6,row);
        }else {
            preparedStatement.setNull(6, Types.VARCHAR);
        }
        //语言
        if((row = film.getLanguage()) != null){
            preparedStatement.setString(7,row);
        }else {
            preparedStatement.setNull(7, Types.VARCHAR);
        }
        //片长
        if((row = film.getDuration()) != null){
            preparedStatement.setString(8,row);
        }else {
            preparedStatement.setNull(8, Types.VARCHAR);
        }
        //概要
        if((row = film.getSynopsis()) != null){
            preparedStatement.setString(9,row);
        }else {
            preparedStatement.setNull(9, Types.VARCHAR);
        }
        //发行时间
        if((row = film.getReleaseDate()) != null){
            preparedStatement.setString(10,row);
        }else {
            preparedStatement.setNull(10, Types.VARCHAR);
        }
        //图片资源
        if((row = film.getImageSource()) != null){
            preparedStatement.setString(11,row);
        }else {
            preparedStatement.setNull(11, Types.VARCHAR);
        }
        int insertCount = preparedStatement.executeUpdate();
        if (insertCount == 1){
            return true;
        }else {
            return false;
        }
    }
}
