package com.julin.dao;

import com.julin.pojo.User;
import com.julin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

   static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void test() {
        //获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();



        //方式一：getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();

        //方式二：(不推荐）
//        List<User> userList = sqlSession.selectList("com.julin.dao.UserDao.getUserList");


        for (User user : userList) {
            System.out.println(user);
        }
        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void testLog4j(){
        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");
    }

}
