package com.bbm.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bbm.model.Book;
//import com.bbm.model.BookType;

public class BookDao {
    /* 添加图书相关信息*/
    public static int insertBook(String ISBN, String typename, String Bookname, String author, String publish, String publicationdate,String edition,Double price) {
        int id = 0,i=0;
        try {
            String sql1="select * from booktype where typename='"+typename+"'";
            ResultSet rs = Dao.executeQuery(sql1);
            //BookType booktype=new BookType();
            try {
                while (rs.next()) {
                    id=rs.getInt("id");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            String sql = "insert into Book(ISBN,typeId,Bookname,author,press,publicationdate,edition,price) values('" + ISBN + "','" + id + "','"
                    + Bookname + "','" + author + "','" + publish + "','" + publicationdate + "','" + edition + "'," + price + ")";
            i = Dao.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return i;
    }


    /* 查询图书相关信息*/

    public static List<Book> selectBook() {
        List<Book> list = new ArrayList<Book>();
        String sql = "select ISBN,typeid,bookname,author,press,publicationdate,Edition,price,typename from book join booktype on book.typeid=booktype.id";
        ResultSet rs = Dao.executeQuery(sql);
        try {
            while (rs.next()) {
                Book Book = new Book();
                Book.setISBN(rs.getString("ISBN"));
                Book.setTypeid(rs.getInt("typeid"));
                Book.setBookname(rs.getString("Bookname"));
                Book.setAuthor(rs.getString("author"));
                Book.setPress(rs.getString("press"));
                Book.setPublicationdate(rs.getDate("publicationdate"));
                Book.setEdition(rs.getString("Edition"));
                Book.setPrice(rs.getDouble("price"));
                Book.setTypename(rs.getString("typename"));
                list.add(Book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return list;
    }
    //按图书编号查询图书
    public static List<Book> selectBookByISBN(String ISBN) {
        List<Book> list = new ArrayList<Book>();
        String sql = "select ISBN,typeid,bookname,author,press,publicationdate,Edition,price,typename from book join booktype on book.typeid=booktype.id and ISBN='" + ISBN + "'";
        ResultSet rs = Dao.executeQuery(sql);
        try {
            while (rs.next()) {
                Book Book = new Book();
                Book.setISBN(rs.getString("ISBN"));
                Book.setTypeid(rs.getInt("typeid"));
                Book.setBookname(rs.getString("Bookname"));
                Book.setAuthor(rs.getString("author"));
                Book.setPress(rs.getString("press"));
                Book.setPublicationdate(rs.getDate("publicationdate"));
                Book.setEdition(rs.getString("edition"));
                Book.setPrice(rs.getDouble("price"));
                Book.setTypename(rs.getString("typename"));
                list.add(Book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return list;
    }
    //按类别查询图书--模糊查询
    public static List<Book> selectBookByType(String Type) {
        List<Book> list = new ArrayList<Book>();

        String sql = "select ISBN,typeid,bookname,author,press,publicationdate,Edition,price,typename from book join booktype on book.typeid=booktype.id and typename like '%" + Type + "%'";
        ResultSet rs = Dao.executeQuery(sql);
        try {
            while (rs.next()) {
                Book Book = new Book();
                Book.setISBN(rs.getString("ISBN"));
                Book.setTypeid(rs.getInt("typeid"));
                Book.setBookname(rs.getString("bookname"));
                Book.setAuthor(rs.getString("author"));
                Book.setPress(rs.getString("press"));
                Book.setPublicationdate(rs.getDate("publicationdate"));
                Book.setEdition(rs.getString("edition"));
                Book.setPrice(rs.getDouble("price"));
                Book.setTypename(rs.getString("typename"));
                list.add(Book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return list;
    }
    //按作者查询图书-模糊查询
    public static List<Book> selectBookByAuthor(String author) {
        List<Book> list = new ArrayList<Book>();
        String sql = "select ISBN,typeid,bookname,author,press,publicationdate,edition,price,typename from book join booktype on book.typeid=booktype.id and author like '%" + author + "%'";
        ResultSet rs = Dao.executeQuery(sql);
        try {
            while (rs.next()) {
                Book Book = new Book();
                Book.setISBN(rs.getString("ISBN"));
                Book.setTypeid(rs.getInt("typeid"));
                Book.setBookname(rs.getString("Bookname"));
                Book.setAuthor(rs.getString("author"));
                Book.setPress(rs.getString("press"));
                Book.setPublicationdate(rs.getDate("publicationdate"));
                Book.setEdition(rs.getString("edition"));
                Book.setPrice(rs.getDouble("price"));
                Book.setTypename(rs.getString("typename"));
                list.add(Book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return list;
    }
    //按照书名查询-模糊查询
    public static List<Book> selectBookByName(String Bookname) {
        List<Book> list = new ArrayList<Book>();
        String sql = "select ISBN,typeid,bookname,author,press,publicationdate,edition,price,typename from book join booktype on book.typeid=booktype.id and Bookname like '%" + Bookname + "%'";
        ResultSet rs = Dao.executeQuery(sql);
        try {
            while (rs.next()) {
                Book Book = new Book();
                Book.setISBN(rs.getString("ISBN"));
                Book.setTypeid(rs.getInt("typeid"));
                Book.setBookname(rs.getString("Bookname"));
                Book.setAuthor(rs.getString("author"));
                Book.setPress(rs.getString("press"));
                Book.setPublicationdate(rs.getDate("publicationdate"));
                Book.setEdition(rs.getString("edition"));
                Book.setPrice(rs.getDouble("price"));
                Book.setTypename(rs.getString("typename"));
                list.add(Book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }
    //按出版社查询-模糊查询
    public static List<Book> selectBookByPress(String Publish) {
        List<Book> list = new ArrayList<Book>();
        String sql = "select ISBN,typeid,bookname,author,press,publicationdate,edition,price,typename from book join booktype on book.typeid=booktype.id and publish like '%" +Publish + "%'";
        ResultSet rs = Dao.executeQuery(sql);
        try {
            while (rs.next()) {
                Book Book = new Book();
                Book.setISBN(rs.getString("ISBN"));
                Book.setTypeid(rs.getInt("typeid"));
                Book.setBookname(rs.getString("Bookname"));
                Book.setAuthor(rs.getString("author"));
                Book.setPress(rs.getString("press"));
                Book.setPublicationdate(rs.getDate("publicationdate"));
                Book.setEdition(rs.getString("edition"));
                Book.setPrice(rs.getDouble("price"));
                Book.setTypename(rs.getString("typename"));
                list.add(Book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }
    //图书修改
    public static int updatebook(String ISBN, String typename,String bookname, String author, String press, String publicationdate, String edition, Double price) {
        int typeid=0,i = 0;
        try {
            String sql1="select * from booktype where typename='"+typename+"'";
            ResultSet rs = Dao.executeQuery(sql1);
            //BookType booktype=new BookType();
            try {
                while (rs.next()) {
                    typeid=rs.getInt("id");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            String sql = "update book set ISBN='" + ISBN + "',typeid='" + typeid + "',bookname='" + bookname + "',author='" + author + "',press='"
                    + press + "',publicationdate='" + publicationdate + "',edition='" + edition + "',price=" + price + " where ISBN='" + ISBN + "'";
            System.out.print(sql1);
            i = Dao.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return i;
    }


    //图书删除
    public static int deleteBook(String ISBN) {
        int typeid=0,i = 0;
        try {
            String sql="delete from book where ISBN='"+ISBN+"'";
            i = Dao.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return i;
    }
}
