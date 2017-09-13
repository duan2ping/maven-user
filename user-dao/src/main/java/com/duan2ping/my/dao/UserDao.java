package com.duan2ping.my.dao;

import com.duan2ping.my.entity.User;

import java.util.List;

/**
 * 用户相关接口
 * Created by duan2ping on 2017/9/11.
 */
public interface UserDao {

    /**
     * 查询所有用户
     * @return     用户列表
     */
    List<User> getUsers();

}
