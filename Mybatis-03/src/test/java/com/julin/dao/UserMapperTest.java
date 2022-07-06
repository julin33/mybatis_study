package com.julin.dao;

import com.julin.pojo.User;
import com.julin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void test() {
        //获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();



        //方式一：getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.getUserById(1));
        sqlSession.commit();

        sqlSession.close();
    }

}
