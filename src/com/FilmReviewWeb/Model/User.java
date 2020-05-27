package com.FilmReviewWeb.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userId;
    private String userName;
    private String password;
    //权限 普通用户为0，管理员为1
    private Integer power;
    private String registDate;
    //最后在线日期
    private String lastOnlineDate;
    private String gender;
}
