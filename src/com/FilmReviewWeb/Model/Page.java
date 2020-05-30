package com.FilmReviewWeb.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page implements Serializable {

    int totalCount; //总记录数
    int totalPage;  //总页数
    int currentPage;//当前页码
    int pageSize;   //每页显示条数
    List list;      //每页展示的数据集合


}
