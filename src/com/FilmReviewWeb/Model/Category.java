package com.FilmReviewWeb.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 首页分类条目
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {
    //cid为分类条目id,cname为分类条目名
    private int cid;
    private String cname;


}
