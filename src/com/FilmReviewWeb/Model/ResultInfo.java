package com.FilmReviewWeb.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultInfo implements Serializable {

    private boolean flag;   //后端返回结果正常为true，发生异常返回false
    private Object data;    //后端返回结果数据对象
    private String errorMsg;//发生异常的错误消息


}
