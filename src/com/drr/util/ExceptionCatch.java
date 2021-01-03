package com.drr.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExceptionCatch {

    /*
     * 关闭资源时的异常处理一
     *
     * @author 37.5
     */
    public static void closeResource(Connection connection, PreparedStatement ps) { // 关闭连接
        try {
            if(ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
