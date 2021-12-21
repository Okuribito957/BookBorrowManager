package com.bbm.db;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bbm.model.Users;

public class UserDao {
    /*
     * 管理员登录方法
     */

    public static Users check(String name, String password) {
        Users users = new Users();
        String sql = "select *  from users where name='" + name + "' and password='" + password + "'";
        ResultSet rs = Dao.executeQuery(sql);
        try {
            while (rs.next()) {
                users.setId(rs.getInt("id"));
                users.setName(rs.getString("name"));
                users.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return users;
    }
    //浏览用户
    public static List<Users>  selectUser() {
        List<Users> list = new ArrayList<Users>();
        String sql = "select *  from users" ;
        ResultSet rs = Dao.executeQuery(sql);
        try {
            while (rs.next()) {
                Users user=new Users();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return list;
    }
    //删除用户
    public static int deleteUser(Integer id) {
        int i = 0;
        try {
            String sql = "delete from users where id="+id+"" ;
            i = Dao.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return i;
    }
    //修改用户密码
    public static int updateUserPWD(Integer id,String pwd){
        int i = 0;
        try {
            String sql = "update users set password='"+pwd+"' where id="+id+"";
            i = Dao.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return i;
    }
    //添加用户
    public static int insertUser(String name,String pwd){
        int i = 0;
        try {
            String sql = "insert into users(name,password) values('"+name+"','"+pwd+"')";
            i = Dao.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dao.close();
        return i;
    }
}
