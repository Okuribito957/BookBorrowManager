package com.bbm.db;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bbm.model.BookType;
//import com.bbm.model.ReaderType;

public class BookTypeDao {
    /*
     * 查询图书类别方法
     */
    public static List<BookType> selectBookType() {
        List<BookType> list = new ArrayList<BookType>();
        String sql = "select *  from booktype";
        ResultSet rs = Dao.executeQuery(sql);
        try {
            while (rs.next()) {
                BookType booktype = new BookType();
                booktype.setTypeid(rs.getInt("id"));
                booktype.setTypename(rs.getString("typename"));
                list.add(booktype);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return list;

    }
    //按照类型编号查找图书类型
    public static List<BookType> selectBookType(String name) {
        List<BookType> list = new ArrayList<BookType>();
        String sql = "select *  from booktype where typename like '%"+name+"%'";
        ResultSet rs = Dao.executeQuery(sql);
        try {
            while (rs.next()) {
                BookType booktype = new BookType();
                booktype.setTypeid(rs.getInt("id"));
                booktype.setTypename(rs.getString("typename"));
                list.add(booktype);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return list;

    }
    //插入图书类型
    public static int insertBookType(Integer id,String typename) {
        int i = 0;
        try {
            //List<ReaderType> list = new ArrayList<ReaderType>();
            String sql = "insert into booktype values("+id+",'"+typename+"')";
            i = Dao.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return i;
    }
    //修改图书类型
    public static int updateBookType(Integer id,String typename) {
        int i = 0;
        try {
            String sql = "update booktype set typename='"+typename+"' where id="+id+"";
            System.out.print(sql);
            i = Dao.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return i;
    }
    //删除图书类型
    public static int deleteBookType(Integer id) {
        int i = 0;
        try {
            String sql = "delete from booktype where id="+id+"";
            i = Dao.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return i;
    }

}
