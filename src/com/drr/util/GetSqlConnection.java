package com.drr.util;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GetSqlConnection {
    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        Connection connection = null;
        try {
            // 获取配置文件流
            Reader reader = new FileReader("F:\\Users\\37.5\\Desktop\\Web课设\\src\\jdbc.properties");
            // 创建Properties对象
            Properties properties = new Properties();
            // 把文件数据读到properties集合中
            properties.load(reader);
            // 获取集合数据
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driverClass = properties.getProperty("driverClass");
            // 加载驱动
            Class.forName(driverClass);
            // 获取连接
            connection = DriverManager.getConnection(url,user,password);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return connection;
//        // 获取配置文件流
//        Reader reader = new FileReader("F:\\IDE代码\\src\\jdbc.properties");
//        // 创建Properties对象
//        Properties properties = new Properties();
//        // 把文件数据读到properties集合中
//        properties.load(reader);
//        // 获取集合数据
//        String user = properties.getProperty("user");
//        String password = properties.getProperty("password");
//        String url = properties.getProperty("url");
//        String driverClass = properties.getProperty("driverClass");
//        // 加载驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        // 获取连接
//        Connection connection = DriverManager.getConnection(url,user,password);
//        return connection;
    }
}
