package com.FilmReviewWeb.Service;

import com.FilmReviewWeb.Model.Page;

public interface GetDetailsService {
    public Page pageQuery(int cid, int currentPage, int pageSize);
}
