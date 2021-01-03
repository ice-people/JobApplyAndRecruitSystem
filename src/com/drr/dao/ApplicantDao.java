package com.drr.dao;

import com.drr.entity.Applicant;
import com.drr.util.DBUtil;
import com.drr.util.ExceptionCatch;
import com.drr.util.GetSqlConnection;

import java.io.IOException;
import java.sql.*;

public class ApplicantDao {

    /* 对登录的用户进行密码、邮箱验证 */
    public Applicant ensureForLogin(Object...args){
        String sql = "select * from applicant where username=? and applicant_email=? and applicant_pwd=?";
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Applicant applicant = null;
        try {
            // 获取连接
            connection = GetSqlConnection.getConnection();
            // 预编译sql语句
            ps = connection.prepareStatement(sql);
            // 填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            resultSet = ps.executeQuery();
            while (resultSet.next()){
                applicant = new Applicant(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getDate(5));
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
        return applicant;
    }
    //验证是否已经注册
    public static boolean ensureForRegister(String applicantEmail) throws SQLException, IOException, ClassNotFoundException {
        String sql = "select * from applicant where applicant_email=?";
        boolean flag = DBUtil.queryForApplicant(sql, applicantEmail);
        return flag;
    }
    // 未注册，将注册数据写入数据库
    public static void writeApplicantDateToSql(String userName,String applicantEmail, String applicantPwd) throws SQLException, IOException, ClassNotFoundException {
        String sql = "insert into applicant(username,applicant_email,applicant_pwd,applicant_registerdata)values(?,?,?,?)";
        DBUtil.update(sql,userName,applicantEmail,applicantPwd, new Date(System.currentTimeMillis()));
    }
}
