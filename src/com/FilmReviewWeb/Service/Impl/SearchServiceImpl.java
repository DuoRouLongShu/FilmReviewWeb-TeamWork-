package com.FilmReviewWeb.Service.Impl;

import com.FilmReviewWeb.Dao.FilmDao;
import com.FilmReviewWeb.Model.Film;
import com.FilmReviewWeb.Service.SearchService;

import java.util.List;

/**
 * @author HTwo2O
 * @date 2020/5/19 0:05
 */
public class SearchServiceImpl implements SearchService {
    @Override
    public List<Film> searchFilmByKeyword(String keyword) throws Exception {
        return new FilmDao().getFilmsByKeyword(keyword);
    }
}
