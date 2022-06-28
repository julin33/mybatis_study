package com.julin.dao;

import com.julin.pojo.User;
import com.julin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void test() {
        //获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行Sql
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        for (User user : userDao.getUserList()) {
            System.out.println(user);
        }

        //关闭SqlSession
        sqlSession.close();
    }
}
