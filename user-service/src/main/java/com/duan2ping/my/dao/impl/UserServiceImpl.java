package com.duan2ping.my.dao.impl;

import com.duan2ping.my.UserService;
import com.duan2ping.my.dao.UserDao;
import com.duan2ping.my.entity.User;

import java.util.List;

/**
 * 用户业务实现
 * Created by duan2ping on 2017/9/11.
 */
public class UserServiceImpl implements UserService{

    UserDao dao = new UserDaoImpl();

    // 查询所有用户
    public List<User> query(){

        return dao.getUsers();
    }

}
