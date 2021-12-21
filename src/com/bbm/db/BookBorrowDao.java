package com.bbm.db;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bbm.model.BorrowBook;

public class BookBorrowDao {
    //查看读者借书信息
    public static List<BorrowBook> selectBorrowBookByReaderId(String readerid){
        List<BorrowBook> list = new ArrayList<BorrowBook>();
        String sql = "select * from borrowbook where readerid='"+readerid+"' and returndate is null";
        ResultSet rs = Dao.executeQuery(sql);
        try {
            while (rs.next()) {
                BorrowBook borrowbook = new BorrowBook();
                borrowbook.setReaderid(rs.getString("readerid"));
                borrowbook.setISBN(rs.getString("ISBN"));
                borrowbook.setBorrowdate(rs.getDate("borrowdate"));
                borrowbook.setReturndate(rs.getDate("returndate"));
                borrowbook.setFine(rs.getDouble("fine"));
                list.add(borrowbook);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return list;
    }
    //图书借阅
    public static int borrowBook(String readerid,String ISBN,Date borrowdate){
        int i = 0;
        try {
            String sql = "insert into borrowbook(readerid,ISBN,borrowdate) values('"+readerid+"','"+ISBN+"','"+borrowdate+"')";
            i = Dao.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return i;
    }
    //图书归还
    public static int returnBook(String readerid,String ISBN,Date returndate){
        int i = 0;
        try {
            String sql = "update borrowbook set returndate='"+returndate+"' where readerid='"+readerid+"' and ISBN='"+ISBN+"'";
            i = Dao.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return i;
    }
}

