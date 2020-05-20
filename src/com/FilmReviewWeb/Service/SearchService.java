package com.FilmReviewWeb.Service;

import com.FilmReviewWeb.Model.Film;

import java.util.List;

/**搜索框的服务
 * @author HTwo2O
 * @date 2020/5/13 14:26
 */
public interface SearchService {
    /**
     * 通过关键字返回相关电影
     * @param keyword
     * @return
     * @throws Exception
     */
    public List<Film> searchFilmByKeyword(String keyword)throws Exception;
}
