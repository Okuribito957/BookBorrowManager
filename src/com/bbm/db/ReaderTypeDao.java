package com.bbm.db;

import com.bbm.model.ReaderType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReaderTypeDao {
    //查询所有读者类型信息
    public static List<ReaderType> selectReaderType(){
        List<ReaderType> list = new ArrayList<>();
        String sql = "select * from readertype";
        ResultSet rs = Dao.executeQuery(sql);
        try {
            while (rs.next()){
                ReaderType readertype = new ReaderType();
                readertype.setId(rs.getInt("id"));
                readertype.setLimit(rs.getInt("limit"));
                readertype.setMaxborrownum(rs.getInt("maxborrownum"));
                readertype.setName(rs.getString("typename"));
                list.add(readertype);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Dao.close();
        return list;
    }
    //查询指定读者类型名的读者类型信息
    public static List<ReaderType> selectReaderType(String type){
        List<ReaderType> list = new ArrayList<>();
        String sql = "select * from readertype where typename like '%"+type+"%'";
        ResultSet rs = Dao.executeQuery(sql);
        try {
            while (rs.next()){
                ReaderType readertype = new ReaderType();
                readertype.setId(rs.getInt("id"));
                readertype.setName(rs.getString("typename"));
                readertype.setMaxborrownum(rs.getInt("maxborrownum"));
                readertype.setLimit(rs.getInt("limit"));
                list.add(readertype);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Dao.close();
        return list;
    }
    //添加读者类型信息
    public static int insertReaderType(Integer id, String typename, String num, Integer limit){
        int readertypeid = 0,i = 0;
        try {
            String sql1 = "select * from readertype where typename='"+typename+"'";
            ResultSet rs = Dao.executeQuery(sql1);
            while (rs.next()){
                readertypeid = rs.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql = "insert into readertype values("+id+",'"+typename+"',"+num+","+limit+")";
        i = Dao.executeUpdate(sql);
        Dao.close();
        return i;
    }
    //修改读者类型信息
    public static int updateReaderType(Integer id,String typename,Integer num,Integer limit){
        int readertypeid = 0,i = 0;
        String sql = "update readertype set typename='"+typename+"',maxborrownum="+num+",limit="+limit+" where id="+id;
        i = Dao.executeUpdate(sql);
        Dao.close();
        return i;
    }
    //删除读者类型信息
    public static int deleteReaderType(Integer id){
        int readertypeid = 0,i = 0;
        String sql = "delete from readertype where id="+id;
        i = Dao.executeUpdate(sql);
        Dao.close();
        return i;
    }
}