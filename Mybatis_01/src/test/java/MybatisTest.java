import cn.curleyg.dao.UserMapper;
import cn.curleyg.domain.User;
import cn.curleyg.enums.Sex;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 城南花已开<br>
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created in 2022/5/8 18:24 <br>
 * @Author: Wang
 */
public class MybatisTest {
    static SqlSession sqlSession = null;

    static {
        //读取MyBatis的核心配置文件
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            //创建SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            //创建SqlSession对象，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
            sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void AddTest() throws IOException {

        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配 映射文件中的SQL标签，并执行标签中的SQL语句
        User user = new User();
        user.setName("丹丹2");
        user.setAddress("江西南昌");
        user.setPhone("15698762325");
        user.setSex(Sex.FEMALE);
        user.setAge(80);
        int result = userMapper.insertUser(user);
        System.out.println(user.getId());
        sqlSession.commit();
    }

    @Test
    public void selectOneTest() throws IOException {

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配 映射文件中的SQL标签，并执行标签中的SQL语句
        User user = userMapper.selectOne(1);
        System.out.println(user);   //注释这句话，通过查看日志可以判断是否延迟加载
        User user2 = userMapper.selectOne(1);//验证一级缓存默认开启，查看日志值执行了第一次的全部sql语句


    }

    @Test
    public void selectName() throws IOException {

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配 映射文件中的SQL标签，并执行标签中的SQL语句
        List<User> user = userMapper.selectName("丹丹");
        for (User user1 : user) {
            System.out.println(user1.getSex().getName());
        }
    }


    @Test
    public void selectList() throws IOException {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配 映射文件中的SQL标签，并执行标签中的SQL语句
        List<User> user = userMapper.selectList();
        for (User user1 : user) {
            System.out.println(user1);
        }

    }

    //注解版
    @Test
    public void selectLists() throws IOException {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配 映射文件中的SQL标签，并执行标签中的SQL语句
        PageHelper.startPage(1, 5);
        List<User> user = userMapper.selectLists();
        for (User user1 : user) {
            System.out.println(user1);
        }
        PageInfo<User> pageInfo = new PageInfo<>(user, 5);
        System.out.println(pageInfo);
        /*常用数据：
            pageNum：当前页的页码
            pageSize：每页显示的条数
            size：当前页显示的真实条数
            total：总记录数
            pages：总页数
            prePage：上一页的页码
            nextPage：下一页的页码
            isFirstPage/isLastPage：是否为第一页/最后一页
            hasPreviousPage/hasNextPage：是否存在上一页/下一页
            navigatePages：导航分页的页码数
            navigatepageNums：导航分页的页码，[1,2,3,4,5]
        */
    }

    @Test
    public void selectUserList() throws IOException {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配 映射文件中的SQL标签，并执行标签中的SQL语句
        User user = new User();
        user.setName("丹丹2");
        user.setPhone("15698762325");
        List<User> userList = userMapper.selectUserList(user); //发现sql语句中只有两个条件
        for (User u : userList) {
            System.out.println(u);
        }

    }

}
