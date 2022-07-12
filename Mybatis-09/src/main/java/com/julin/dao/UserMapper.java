package com.julin.dao;

import com.julin.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    User queryUserById(@Param("id") int id);
}
