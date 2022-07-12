import com.julin.dao.BlogMapper;
import com.julin.pojo.Blog;
import com.julin.utils.IDutils;
import com.julin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class MyTest {
    @Test
    public void addBlogTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("Mybatis");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Java");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Spring");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("微服务");
        mapper.addBlog(blog);

        sqlSession.close();
    }

    @Test
    public void queryBlogIF(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap<String,String>();
        map.put("author","狂神说");
        map.put("title","微服务");
        for (Blog blog : mapper.queryBlogIF(map)) {
            System.out.println(blog);
        }
        sqlSession.close();


    }


    @Test
    public void queryBlogChoose(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap<String,String>();
//        map.put("views",9999);
        map.put("author","狂神说");
        map.put("title","微服务");
        for (Blog blog : mapper.queryBlogChoose(map)) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void updateBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap<String,String>();
//        map.put("views",9999);
        map.put("id","42d722bb6f4843ffbcac0d9e3348f697");
        map.put("author","julin");
        map.put("title","微服务");
        mapper.updateBlog(map);
        sqlSession.close();
    }

    @Test
    public void queryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap<String,List>();
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        map.put("ids",list);

        mapper.queryBlogForeach(map);
        sqlSession.close();
    }
}
