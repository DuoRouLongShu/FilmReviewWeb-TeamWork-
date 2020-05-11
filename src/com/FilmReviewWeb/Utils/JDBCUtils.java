package com.FilmReviewWeb.Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author HTwo2O
 * @date 2020/5/10 21:25
 * JDBC工具类
 */


public class JDBCUtils {

    private static DataSource dataSource;
    static {
        try {
            //druid 的连接池
            Properties pro = new Properties();//加载配置文件
            pro.load(JDBCUtils.class.getResourceAsStream("/druid.properties"));//使用ClassLoad加载配置文件，获取字节输入流
            dataSource = DruidDataSourceFactory.createDataSource(pro);//初始化连接池对象
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static Connection getConnection() throws SQLException {//获取Connection 对象
        return dataSource.getConnection();
    }
    //释放资源
    public static void close(Connection conn,Statement sta){
        if (sta != null){
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Connection conn, Statement sta, ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (sta != null){
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
