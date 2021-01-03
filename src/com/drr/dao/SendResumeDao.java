package com.drr.dao;

import com.drr.entity.RecruitBasicInfo;
import com.drr.entity.SendResume;
import com.drr.util.ExceptionCatch;
import com.drr.util.GetSqlConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SendResumeDao {

    /* 将数据写入数据库 */
    public int writeDataToSql(Object...args){
        String sql = "insert into sendresume (applicant_id,company_id,resume_name,resume_sex,resume_school,resume_degree,resume_profession,resume_workExe,resume_email,resume_state) values (?,?,?,?,?,?,?,?,?,?)";
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

    /* 获取指定要求的数据 */
    public List<SendResume> find(Object...args) throws SQLException, IOException, ClassNotFoundException {
        String sql = "select * from sendresume where  company_id = ?";
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<SendResume> books = new ArrayList();
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
                books.add(new SendResume(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getString(5),
                        resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getString(10),resultSet.getString(11)));

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

    /* 更新数据 */
    public int update(Object...args){
        String sql = "update sendresume set resume_state = ? where sendresume_id=?";
        Connection connection = null;
        PreparedStatement ps = null;
        int  resultSet = 0;
        List<SendResume> books = new ArrayList();
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
            resultSet = ps.executeUpdate();
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
        return resultSet;
    }
}
