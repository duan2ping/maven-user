package com.duan2ping.my;



import com.duan2ping.my.entity.User;

import java.util.List;

/**
 * 用户业务相关
 * Created by duan2ping on 2017/9/11.
 */
public interface UserService {

    // 查询所有用户
    List<User> query();

}
