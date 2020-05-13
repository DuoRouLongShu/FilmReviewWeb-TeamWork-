package com.FilmReviewWeb.Service;

import com.FilmReviewWeb.Model.Film;
import com.FilmReviewWeb.Model.Review;

import java.util.ArrayList;

/**特定电影页面的服务
 * @author HTwo2O
 * @date 2020/5/13 14:26
 */
public interface FilmPageService {

    /**
     * 通过电影名字获得相关影评
     * @param filmName
     * @return
     */
    public ArrayList<Review> getReviewsByFilmName(String filmName) throws Exception;

    /**
     *
     * @param fileNmae
     * @return
     * @throws Exception
     */
    public Film getFilmDataByFilmName(String fileNmae)throws Exception;
}
