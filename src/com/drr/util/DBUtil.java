package com.drr.util;


import java.io.IOException;
import java.sql.*;

public class DBUtil {

    public static boolean queryForApplicant(String sql, Object... args) throws SQLException {
//        ResultSet resultSet = ps.executeQuery();
//        if(resultSet.next()){  // next()方法，如果集合为空，返回false，不为空，返回true，同时指针移动到下一条数据
//            String email = resultSet.getString(2);
//            Date date = resultSet.getDate(4);
//            System.out.println(email + "   " + date);
//        }
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        String resultEmail = null;
        try {
            // 获取连接
            connection = GetSqlConnection.getConnection();
            // 预编译sql语句
            ps = connection.prepareStatement(sql);
            // 填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            // 执行
            // result = ps.execute();
            resultSet = ps.executeQuery();
            while (resultSet.next()){
                resultEmail = resultSet.getString(3);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            ExceptionCatch.closeResource(connection, ps);
        }
        if (resultEmail != null){
            return true;
        }else{
            return false;
        }
    }


    public static boolean update(String sql, Object...args) throws SQLException, IOException, ClassNotFoundException {
        // 获取连接
        Connection connection = GetSqlConnection.getConnection();
        // 预编sql语句，获取PrepareStatement对象
        PreparedStatement ps = connection.prepareStatement(sql);
        // 填充占位符
        for(int i= 0 ; i < args.length ; i++){
            if(args[i] instanceof java.util.Date){  // 判断是否为日期
                java.util.Date data = (java.util.Date)args[i];
                // 转换为java.sql.Date
                args[i] = new Date(data.getTime());
            }
            ps.setObject(i + 1, args[i]);
        }
       /* PreparedStatement.execute()如果第一个结果是 ResultSet 对象，则返回 true；如果第一个结果是更新计数或者没有结果，则返回 false

        意思就是如果是查询的话返回true，如果是更新或插入的话就返回false了 */
        boolean result= ps.execute();
        // 关闭资源
        ps.close();
        connection.close();
        return result;

    }

    /* 通过email判断登录用户是否有简历 */
    public static boolean isExistResume(String email) throws SQLException, IOException, ClassNotFoundException {
        ResultSet resultSet = null;
        String resultEmail = null;

        String sql = "select * from tb_resume_basicinfo where EMAIL=?";
        // 获取连接
        Connection connection = GetSqlConnection.getConnection();
        // 预编sql语句，获取PrepareStatement对象
        PreparedStatement ps = connection.prepareStatement(sql);
        // 填充占位符
        ps.setObject(1, email);
        // 执行
        // result = ps.execute();
        resultSet = ps.executeQuery();
        if (resultSet.next()){
            resultEmail = resultSet.getString(9);
        }
        if (resultEmail != null){
            // 查询到该邮箱对应的信息，即该用户存在简历，返回true
            return true;
        }else{
            return false;
        }
    }

   }


