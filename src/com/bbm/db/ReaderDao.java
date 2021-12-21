package com.bbm.db;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bbm.model.Reader;
/*读者管理*/
public class ReaderDao {
    //查看读者信息
    public static List<Reader> selectReader() {
        List<Reader> list = new ArrayList<Reader>();
        String sql = "select readerid,type,name,major,gender,phone,dept,regdate,typename,maxborrownum,limit  from reader join readertype on reader.type=readertype.id";
        ResultSet rs = Dao.executeQuery(sql);
        try {
            while (rs.next()) {
                Reader reader = new Reader();
                reader.setReaderid(rs.getString("readerid"));
                reader.setType(rs.getInt("type"));
                reader.setName(rs.getString("name"));
                reader.setMajor(rs.getString("major"));
                reader.setGender(rs.getString("gender"));
                //reader.setgender(rs.getString("name"));
                reader.setPhone(rs.getString("phone"));
                reader.setDept(rs.getString("dept"));
                reader.setRegdate(rs.getDate("regdate"));
                reader.setTypename(rs.getString("typename"));
                reader.setMaxborrownum(rs.getInt("maxborrownum"));
                reader.setLimit(rs.getInt("limit"));
                list.add(reader);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return list;
    }
    //
    public static List<Reader> selectReaderById(String id) {
        List<Reader> list = new ArrayList<Reader>();
        String sql = "select readerid,type,name,major,gender,phone,dept,regdate,typename,maxborrownum,limit  from reader join readertype on reader.type=readertype.id where readerid='"+id+"'";
        ResultSet rs = Dao.executeQuery(sql);
        try {
            while (rs.next()) {
                Reader reader = new Reader();
                reader.setReaderid(rs.getString("readerid"));
                reader.setType(rs.getInt("type"));
                reader.setName(rs.getString("name"));
                reader.setMajor(rs.getString("major"));
                reader.setGender(rs.getString("gender"));
                reader.setPhone(rs.getString("phone"));
                reader.setDept(rs.getString("dept"));
                reader.setRegdate(rs.getDate("regdate"));
                reader.setTypename(rs.getString("typename"));
                reader.setMaxborrownum(rs.getInt("maxborrownum"));
                reader.setLimit(rs.getInt("limit"));
                list.add(reader);
            }
            System.out.println(list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return list;
    }
    public static List<Reader> selectReaderByName(String Name) {
        List<Reader> list = new ArrayList<Reader>();
        String sql = "select readerid,type,name,major,gender,phone,dept,regdate,typename,maxborrownum,limit  from reader join readertype on reader.type=readertype.id and name like '%"+Name+"%'";
        ResultSet rs = Dao.executeQuery(sql);
        try {
            while (rs.next()) {
                Reader reader = new Reader();
                reader.setReaderid(rs.getString("readerid"));
                reader.setType(rs.getInt("type"));
                reader.setName(rs.getString("name"));
                reader.setMajor(rs.getString("major"));
                reader.setGender(rs.getString("gender"));
                reader.setPhone(rs.getString("phone"));
                reader.setDept(rs.getString("dept"));
                reader.setRegdate(rs.getDate("regdate"));
                reader.setTypename(rs.getString("typename"));
                reader.setMaxborrownum(rs.getInt("maxborrownum"));
                reader.setLimit(rs.getInt("limit"));
                list.add(reader);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return list;
    }
    public static List<Reader> selectReaderByDept(String dept) {
        List<Reader> list = new ArrayList<Reader>();
        String sql = "select readerid,type,name,major,gender,phone,dept,regdate,typename,maxborrownum,limit  from reader join readertype on reader.type=readertype.id and dept like '%"+dept+"%'";
        ResultSet rs = Dao.executeQuery(sql);
        try {
            while (rs.next()) {
                Reader reader = new Reader();
                reader.setReaderid(rs.getString("readerid"));
                reader.setType(rs.getInt("type"));
                reader.setName(rs.getString("name"));
                reader.setMajor(rs.getString("major"));
                reader.setGender(rs.getString("gender"));
                reader.setPhone(rs.getString("phone"));
                reader.setDept(rs.getString("dept"));
                reader.setRegdate(rs.getDate("regdate"));
                reader.setTypename(rs.getString("typename"));
                reader.setMaxborrownum(rs.getInt("maxborrownum"));
                reader.setLimit(rs.getInt("limit"));
                list.add(reader);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return list;
    }
    public static List<Reader> selectReaderByType(String type) {
        List<Reader> list = new ArrayList<Reader>();
        String sql = "select readerid,type,name,major,gender,phone,dept,regdate,typename,maxborrownum,limit from reader join readertype on reader.type=readertype.id and readertype.typename like '%"+type+"%'";
        ResultSet rs = Dao.executeQuery(sql);
        try {
            while (rs.next()) {
                Reader reader = new Reader();
                reader.setReaderid(rs.getString("readerid"));
                reader.setType(rs.getInt("type"));
                reader.setName(rs.getString("name"));
                reader.setMajor(rs.getString("major"));
                reader.setGender(rs.getString("gender"));
                reader.setPhone(rs.getString("phone"));
                reader.setDept(rs.getString("dept"));
                reader.setRegdate(rs.getDate("regdate"));
                reader.setTypename(rs.getString("typename"));
                reader.setMaxborrownum(rs.getInt("maxborrownum"));
                reader.setLimit(rs.getInt("limit"));
                list.add(reader);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return list;
    }
    //添加读者
    public static int insertReader(String id,String type,String name,String major,String gender,String phone, String dept, String reg) {
        int typeid = 0,i=0;
        try {
            String sql1="select * from readertype where typename='"+type+"'";
            ResultSet rs = Dao.executeQuery(sql1);
            try {
                while (rs.next()) {
                    typeid=rs.getInt("id");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            String sql = "insert into reader(readerid,type,name,major,gender,phone,dept,regdate) values('" + id + "','" +typeid + "','"+ name+"','"
                    + major + "','" + gender + "','" + phone + "','" + dept + "','" + reg + "')";
            i = Dao.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return i;
    }
    //修改读者信息
    public static int updateReader(String id, String type, String name, String major, String gender, String phone, String dept, String reg) {
        int typeid=0,i = 0;
        try {
            String sql1="select * from readertype where typename='"+type+"'";
            ResultSet rs = Dao.executeQuery(sql1);
            try {
                while (rs.next()) {
                    typeid=rs.getInt("id");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            String sql = "update reader set readerid='"+id+"',type="+typeid+",name='"+name+"',major='"+major+
                    "',gender='"+gender+"',phone='"+phone+"',dept='"+dept+"',regdate='"+reg+"'"+ " where readerid='" + id + "'";
            System.out.println(sql);
            i = Dao.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return i;
    }
    public static void main(String[] args){
        ReaderDao.selectReaderById("00000001");
    }
}
