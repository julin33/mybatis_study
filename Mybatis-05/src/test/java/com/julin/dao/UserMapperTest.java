package com.julin.dao;


import com.julin.pojo.User;
import com.julin.utils.MybatisUtils;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserMapperTest {

  @Test
    public void getUsers() {
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    for (User user : mapper.getUsers()) {
      System.out.println(user);
    }

    sqlSession.close();
  }

  @Test
  public void getUserById() {
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    System.out.println(mapper.getUserById(1));
    sqlSession.close();
  }

  @Test
  public void addUser() {
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    mapper.addUser(new User(6,"半吊子","123456"));
    sqlSession.commit();
    sqlSession.close();
  }

  @Test
  public void updateUser() {
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    mapper.updateUser(new User(6,"半信","654321"));
    sqlSession.commit();
    sqlSession.close();
  }

  @Test
  public void deleteUser() {
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    mapper.deleteUser(6);
    sqlSession.commit();
    sqlSession.close();
  }
}
