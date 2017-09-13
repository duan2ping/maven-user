package com.duan2ping.my.dao.impl;

import com.duan2ping.my.dao.UserDao;
import com.duan2ping.my.base.BaseDao;
import com.duan2ping.my.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户接口实现
 * Created by daun2ping on 2017/9/11.
 */
public class UserDaoImpl extends BaseDao implements UserDao {


    // 查询所有用
    public List<User> getUsers() {
        String sql = "select * from m_user";
        rs = executeQuery(sql,null);
        List<User> ulist = new ArrayList<User>();
        try {
            User user = null;
            while (rs.next()){
                user = new User();
                user.setName(rs.getString(3));
                user.setPhone(rs.getString(4));
                ulist.add(user);
            }
        } catch (SQLException e) {
            System.err.println("×：执行getUser方法错误--"+e.getMessage());
        }finally {
            close();
        }
        return ulist;
    }
}
