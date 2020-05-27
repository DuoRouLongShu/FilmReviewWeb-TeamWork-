package com.FilmReviewWeb.Service.Impl;

import com.FilmReviewWeb.Dao.GetDetailsDao;
import com.FilmReviewWeb.Model.DisplayFilms;
import com.FilmReviewWeb.Model.Page;
import com.FilmReviewWeb.Service.GetDetailsService;


import java.sql.SQLException;
import java.util.List;

public class GetDetailsServiceImpl implements GetDetailsService {

    private GetDetailsDao getDetailsDao = new GetDetailsDao();
    @Override
    public Page pageQuery(int cid, int currentPage, int pageSize){
        //封装Page
        Page page = new Page();
        //设置当前页码
        page.setCurrentPage(currentPage);
        //设置每页显示条数
        page.setPageSize(pageSize);


        try {
            //设置总记录数
            int totalCount = getDetailsDao.findTotalCount(cid);
            page.setTotalCount(totalCount);
            //设置当前页显示的数据集合
            int start = (currentPage - 1) * pageSize;   //开始的记录数
            List<DisplayFilms> list = getDetailsDao.findByPage(cid, start, pageSize);
            page.setList(list);

            //设置总页数=总记录数/每页显示条数
            int totalPage = totalCount%pageSize==0?totalCount/pageSize:(totalCount+pageSize)+1;
            page.setTotalPage(totalPage);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return page;

    }
}
