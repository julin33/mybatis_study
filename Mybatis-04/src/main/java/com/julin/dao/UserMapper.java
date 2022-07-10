package com.julin.dao;

import com.julin.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询全部用户
    List<User> getUserList();
    //分页实现查询
    List<User> getUserByLimit(Map<String,Object> map);
    //分页2
    List<User> getUserByRowBounds();

}
