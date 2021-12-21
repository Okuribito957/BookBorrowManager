package com.bbm.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
    String dbclassName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=db_bookborrow";
    String dbUser = "sa";
    String dbPWD = "123456";
    static Connection conn = null;
    //构造函数
    public Dao(){
        try {
            Class.forName(dbclassName).newInstance();
            conn = DriverManager.getConnection(dbURL,dbUser,dbPWD);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    //查询函数
    public static ResultSet executeQuery(String sql){
        try {
            if (conn == null){
                new Dao();
            }
            return conn.createStatement().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    //更新函数
    static int executeUpdate(String sql){
        try {
            if (conn == null){
                new Dao();
            }
            return conn.createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    //关闭数据库
    public static void close(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn = null;
        }
    }
}
