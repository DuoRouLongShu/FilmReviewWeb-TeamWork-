package com.FilmReviewWeb.Service.Impl;

import com.FilmReviewWeb.Dao.SlideshowDao;
import com.FilmReviewWeb.Model.Category;
import com.FilmReviewWeb.Model.Slideshow;
import com.FilmReviewWeb.Service.SlideshowService;

import java.sql.SQLException;
import java.util.List;

public class SlideshowServiceImpl implements SlideshowService {

    private SlideshowDao slideshowDao = new SlideshowDao();
    /**
     * 查询所有
     * @return
     */
    public List<Slideshow> findAll() throws SQLException{
        return slideshowDao.findAll();
    };
}
