package com.drr.dao;

import com.drr.entity.RecruitBasicInfo;
import com.drr.util.ExceptionCatch;
import com.drr.util.GetSqlConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecruitBasicInfoDao {
    private final int LIMIT = 5;

    /* 获取指定行的数据 */
    public List<RecruitBasicInfo> findAll(Integer page) throws SQLException, IOException, ClassNotFoundException {
        String sql = "select * from recruit_basicinfo limit ?,?";
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<RecruitBasicInfo> books = new ArrayList();
        try {
            // 获取连接
            connection = GetSqlConnection.getConnection();
            // 预编译sql语句
            ps = connection.prepareStatement(sql);
            ps.setObject(1,(page -1)*LIMIT);
            ps.setObject(2,LIMIT);
            // 执行
            // result = ps.execute();
            resultSet = ps.executeQuery();
            while (resultSet.next()){
                books.add(new RecruitBasicInfo(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),
                        resultSet.getInt(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(8)));

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

        return books;
    }

    /* 获取表中记录的总个数 */
    public int getPages(){
        String sql = "select count(*) from recruit_basicinfo";
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        int count = 0;
        try {
            // 获取连接
            connection = GetSqlConnection.getConnection();
            // 预编译sql语句
            ps = connection.prepareStatement(sql);
            // 执行
            // result = ps.execute();
            resultSet = ps.executeQuery();
            while (resultSet.next()){
                count = resultSet.getInt(1);
            }
            if(count % LIMIT == 0){
                count = count / LIMIT;
            }else{
                count = count / LIMIT + 1;
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

        return count;
    }

    /* 获取符合条件的数据 */
    public List<RecruitBasicInfo> find(Object...args) throws SQLException, IOException, ClassNotFoundException {
        String sql = "select * from recruit_basicinfo where jobName like ? and jobType like ? and workAddress like ? ";
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<RecruitBasicInfo> books = new ArrayList();
        try {
            // 获取连接
            connection = GetSqlConnection.getConnection();
            // 预编译sql语句
            ps = connection.prepareStatement(sql);
            // 填充占位符
            ps.setObject(1,"%" + args[0] + "%");   // 为了进行模糊查询
            ps.setObject(2,"%" + args[1] + "%");   // 为了进行模糊查询
            ps.setObject(3,"%" + args[2] + "%");   // 为了进行模糊查询

//
//            // 执行
            // result = ps.execute();
            resultSet = ps.executeQuery();
            while (resultSet.next()){
                books.add(new RecruitBasicInfo(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),
                        resultSet.getInt(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9)));

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

        return books;
    }

    /* 将招聘信息写入数据库 */
    public int writeRecruitInfoToSql(Object...args){
        String sql = "insert into recruit_basicinfo (company_id,jobName,jobType,recruitForNumber,salary,recruitForDegree,workAddress,jobDescription) values (?,?,?,?,?,?,?,?)";
        Connection connection = null;
        PreparedStatement ps = null;
        int result = 0;
        try {
            // 获取连接
            connection = GetSqlConnection.getConnection();
            // 预编译sql语句
            ps = connection.prepareStatement(sql);
            // 填充占位符
            for(int i = 0;i< args.length;i++){
                ps.setObject(i+ 1,args[i]);
            }
//
            // 执行
            /*
            INSERT、UPDATE 或 DELETE 语句的效果是修改表中零行或多行中的一列或多列。
            executeUpdate 的返回值是一个整数（int），指示受影响的行数（即更新计数）。
            对于 CREATE TABLE 或 DROP TABLE 等不操作行的语句，
            executeUpdate 的返回值总为零。
             */
            result = ps.executeUpdate();
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
        return result;
    }
}
