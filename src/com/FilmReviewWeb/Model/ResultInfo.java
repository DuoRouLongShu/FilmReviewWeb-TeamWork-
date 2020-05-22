package com.FilmReviewWeb.Model;

import java.io.Serializable;

public class ResultInfo implements Serializable {

    private boolean flag;   //后端返回结果正常为true，发生异常返回false
    private Object data;    //后端返回结果数据对象
    private String errorMsg;//发生异常的错误消息

    public ResultInfo(){

    }

    public ResultInfo(boolean flag){ this.flag = flag; }

    public ResultInfo(boolean flag, String errorMsg){
        this.flag = flag;
        this.errorMsg = errorMsg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
