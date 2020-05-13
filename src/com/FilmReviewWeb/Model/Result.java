package com.FilmReviewWeb.Model;

import java.io.Serializable;

/**
 * 返回前端的封装类
 * @author HTwo2O
 * @date 2020/5/13 14:13
 */
public class Result implements Serializable {

    private String message;
    private Object data;
    private int dataCount;
    //需要分页时的页数
    private int pageCount;

    public Result(){

    }
    public Result(String message, Object data, int pageCount, int dataCount){
        this.data = data;
        this.message = message;
        this.pageCount = pageCount;
        this.dataCount = dataCount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    @Override
    public String toString() {
        return "Result{" +
                "message='" + message + '\'' +
                ", data=" + data +
                ", dataCount=" + dataCount +
                ", pageCount=" + pageCount +
                '}';
    }
}
