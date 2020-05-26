package com.FilmReviewWeb.Service;

import com.FilmReviewWeb.Model.Slideshow;

import java.sql.SQLException;
import java.util.List;

public interface SlideshowService {
    /**
     * 查询所有
     * @return
     */
    public List<Slideshow> findAll() throws SQLException;
}
