package com.FilmReviewWeb.Dao;

import com.FilmReviewWeb.Model.DisplayFilms;
import com.FilmReviewWeb.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetDetailsDao {
    /**
     * 根据cid查询总记录数
     */
    public int findTotalCount(int cid) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "select count(*) from display_films where cid = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,cid);
        ResultSet resultSet =  preparedStatement.executeQuery();
        int i = 0;
        while(resultSet.next()){
           i = resultSet.getInt(1);

        }
        return i;
    }

    /**
     * 根据cid, start, pageSize查询当前页的数据集合
     */
    public List<DisplayFilms> findByPage(int cid, int start, int pageSize) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "select * from display_films where cid = ? limit ?, ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,cid);
        preparedStatement.setInt(2,start);
        preparedStatement.setInt(3,pageSize);
        ResultSet resultSet =  preparedStatement.executeQuery();
        List<DisplayFilms> displayFilmsList= new ArrayList<DisplayFilms>();
        if(resultSet.next()){
            while(resultSet.next()){
                DisplayFilms displayFilms = new DisplayFilms();
                displayFilms.setCid(resultSet.getInt("cid"));
                displayFilms.setRotation(resultSet.getInt("rotation"));
                displayFilms.setContent(resultSet.getString("content"));
                displayFilms.setFilmName(resultSet.getString("film_name"));
                displayFilms.setImageSource(resultSet.getString("img_src"));
                displayFilmsList.add(displayFilms);
            }
        }
        return displayFilmsList;
    };
}
