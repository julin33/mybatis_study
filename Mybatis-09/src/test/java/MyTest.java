import com.julin.dao.UserMapper;
import com.julin.pojo.User;
import com.julin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
        sqlSession.clearCache();//手动清理缓存
        System.out.println("==============================");
        User user2 = mapper.queryUserById(1);
        System.out.println(user2);
        sqlSession.close();
    }
}
