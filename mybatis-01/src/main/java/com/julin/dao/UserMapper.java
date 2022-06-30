package com.julin.dao;

import com.julin.pojo.User;

import java.util.List;

public interface UserMapper {
    //查询全部用户
    List<User> getUserList();
    //根据id查询
    User getUserById(int id);
}
