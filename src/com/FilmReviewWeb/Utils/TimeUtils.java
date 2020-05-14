package com.FilmReviewWeb.Utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * 时间操作工具类
 * @author HTwo2O
 * @date 2020/5/12 18:16
 */
public class TimeUtils {

    /**
     * 将数据库中时间属性转化成String
     * @return String
     */
    public static String DBTimestamptoString(Timestamp timestamp){
        Date time1=new Date(timestamp.getTime());//java.util.Date
        SimpleDateFormat formattime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formattime.format(time1);
    }
}
