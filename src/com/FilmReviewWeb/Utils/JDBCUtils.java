package com.FilmReviewWeb.Utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @author HTwo2O
 * @date 2020/5/10 21:25
 */

/**
 * 抽取JDBC工具类: JDBCUtils
 * 目的: 每次都要写JDBC的步骤,为了方便所以抽取为一个工具类
 *
 * 分析:
 * 1. 注册驱动抽取
 * 2. 抽取一个方法获取连接对象 (使用静态方法,工具类使用方便)
 * 3. 抽取一个方法释放资源
 */
public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    // 资源文件读取. 因为只想加载一次,所以写在静态代码块中, 随类的加载而加载到内存(只加载一次)
    static {
        // 读取资源文件, 获取值
        try {
            //1. 创建properties集合类
            Properties pro = new Properties();

            // 获取src路径下的文件方式 --> ClassLoader 类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL resource = classLoader.getResource("jdbc.properties");
            String path = resource.getPath();
            // System.out.println(path);

            //2. 加载文件
            // pro.load(new FileReader("F:\\JavaEE\\code\\idea_code\\coderZYGui\\day04_jdbc\\src\\jdbc.properties"));
            pro.load(new FileReader(path));

            //3. 获取数据, 赋值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");

            //4. 注册驱动
            Class.forName(driver);

        } catch (IOException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {

        // 写死,不好
        // return DriverManager.getConnection("jdbc:mysql://localhost:3306/zy", "root", "1111");
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 释放资源
     *
     * @param stmt 释放执行sql语句对象
     * @param conn 释放数据库连接对象
     */
    public static void close(Statement stmt, Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 释放资源
     *
     * @param rs   释放结果集对象
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
