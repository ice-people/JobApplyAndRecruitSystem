package com.drr.dao;

import com.drr.entity.Applicant;
import com.drr.entity.Company;
import com.drr.util.DBUtil;
import com.drr.util.ExceptionCatch;
import com.drr.util.GetSqlConnection;

import java.io.IOException;
import java.sql.*;

public class CompanyDao {
    /* 对登录的公司用户进行密码、公司名、联系电话验证验证 */
    public Company ensureForLogin(Object...args){
        String sql = "select * from company where company_name=? and company_telephone=? and company_pwd=?";
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Company company = null;
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
                company = new Company(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));
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
        return company;
    }

    //验证是否已经注册
    public  boolean ensureForRegister(String companyTelephone) throws SQLException, IOException, ClassNotFoundException {
        String sql = "select * from company where company_telephone=?";
        boolean flag = DBUtil.queryForApplicant(sql, companyTelephone);
        return flag;
    }
    // 未注册，将注册数据写入数据库
    public  void writeApplicantDateToSql(String companyName,String companyAddress, String companyTelephone,String companyPwd) throws SQLException, IOException, ClassNotFoundException {
        String sql = "insert into company(company_name,company_address,company_telephone,company_pwd)values(?,?,?,?)";
        DBUtil.update(sql,companyName,companyAddress,companyTelephone,companyPwd);
    }
}
