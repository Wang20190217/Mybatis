package cn.curleyg.utils;

import java.sql.*;

/**
 * 城南花已开<br>
 *
 * @Description: <p>JDBC工具类代码演示:“获得数据库连接”操作，将在以后的增删改查所有功能中都存在，
 * 可以封装工具类JDBCUtils。提供获取连接对象的方法，从而达到代码的重复利用。</p>
 * @Project: <br>
 * @CreateDate: Created in 2022/5/8 19:09 <br>
 * @Author: Wang
 */

public class JDBCUtils {

    //私有构造方法,防止外界创建对象调用方法
    private JDBCUtils() {
    }

    //定义Connectionn变量
    private static Connection conn;

    //保证代码只执行一次,可以放入静态代码块中
    static {
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            String url = "jdbc:mysql://127.0.0.1:3306/mybase4";
            String user = "root";
            String password = "root";
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            //注意,如果连接数据库失败,停止程序
            throw new RuntimeException(e + "连接数据库失败");
        }
    }

    //创建一个静态方法,获取数据库连接对象,并返回
    public static Connection getConnection() {
        return conn;
    }

    /*
     * 创建一个静态方法,对资源进行释放
     * ResultSet rs
     * Statement stat
     * Connection conn
     */
    public static void close(ResultSet rs, Statement stat, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (stat != null) {
                stat.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
