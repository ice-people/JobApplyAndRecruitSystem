package com.drr.dao;

import com.drr.entity.Applicant;
import com.drr.entity.ResumeBasicInfo;
import com.drr.util.DBUtil;
import com.drr.util.ExceptionCatch;
import com.drr.util.GetSqlConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ResumeDao {
    // 将添加的简历信息写入数据库
    public static boolean writeResumeInfoToSql(int applicantId,String name, String sex,String birthday,String telephone,String school,String degree,
                                               String profession,String jobIntention,String workExe,String email) throws SQLException, IOException, ClassNotFoundException {

        String sql = "insert into resume_basicinfo(applicant_id,applicant_name,applicant_sex,applicant_birthday,applicant_telephone,applicant_school,applicant_degree,applicant_profession,applicant_jobIntention," +
                "applicant_workExe,applicant_email)value(?,?,?,?,?,?,?,?,?,?,?)";

        // 将BIRTHDAY日期转换为Date日期
        Date birthday1 = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday1 = simpleDateFormat.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DBUtil.update(sql,applicantId,name, sex,birthday1,telephone,school,degree,
                profession,jobIntention,workExe,email);

        return false;
    }

    /* 按照applicantId查询简历 */
    public ResumeBasicInfo getDataByApplicantId(Object...args){
        String sql = "select * from resume_basicinfo where applicant_id=?";
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        ResumeBasicInfo resumeBasicInfo = null;
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
                resumeBasicInfo = new ResumeBasicInfo(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),
                        resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getString(10),resultSet.getString(11),resultSet.getString(12));
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
        return resumeBasicInfo;
    }
}
