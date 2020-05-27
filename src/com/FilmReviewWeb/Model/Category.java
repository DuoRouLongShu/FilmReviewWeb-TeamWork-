package com.FilmReviewWeb.Model;

import java.io.Serializable;

/**
 * 首页分类条目
 */
public class Category implements Serializable {
    //cid为分类条目id,cname为分类条目名
    private int cid;
    private String cname;

    public Category(){

    }
    public Category(int cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
