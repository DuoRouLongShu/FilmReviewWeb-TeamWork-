package com.FilmReviewWeb.Service;

import com.FilmReviewWeb.Model.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryService {
    /**
     * 查询所有
     * @return
     */
    public List<Category> findAll() throws SQLException;
}
