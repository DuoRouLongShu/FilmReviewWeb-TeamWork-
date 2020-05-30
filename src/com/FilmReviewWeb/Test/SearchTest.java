package com.FilmReviewWeb.Test;

import com.FilmReviewWeb.Model.Film;
import com.FilmReviewWeb.Model.Result;
import com.FilmReviewWeb.Service.Impl.SearchServiceImpl;
import com.FilmReviewWeb.Service.SearchService;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

/**
 * @author HTwo2O
 * @date 2020/5/20 20:29
 */
public class SearchTest {

    @Test
    public void searchFuctionTest() throws Exception {
        String keyword = "早";
        SearchService searchService = new SearchServiceImpl();
        List<Film> films = searchService.searchFilmByKeyword(keyword);
        Result result = new Result();
        int size = films.size();
        if(size == 0){
            result.setMessage("无搜索结果");
        }else {
            result.setMessage("成功返回搜索结果");
        }
        result.setDataCount(size);
        result.setData(films);
        if(size / 6 == 0){
            result.setPageCount(1);
        }else if(size % 6 >0){
            result.setPageCount(size / 6 + 1);
        }else {
            result.setPageCount(size/6);
        }
        System.out.println(JSON.toJSONString(result));
    }
}
