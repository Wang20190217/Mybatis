package cn.curleyg.utils;

import cn.curleyg.dao.UserMapper;
import cn.curleyg.domain.User;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.util.List;

/**
 * 城南花已开<br>
 *
 * @Description: 全代码的形式创建SqlSessionFactory 连接工厂<br>
 * @Project: <br>
 * @CreateDate: Created in 2022/5/8 21:33 <br>
 * @Author: Wang
 */
public class SqlSessionFactoryUtils {
    public static void main(String[] args) {
        //构建数据库连接池
        PooledDataSource dataSource=new PooledDataSource();
        dataSource.setDriver("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mybatis");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        //构建数据库事务方式
        TransactionFactory transactionFactory=new JdbcTransactionFactory();
        //创建数据库运行环境
        Environment environment=new Environment("mysql",transactionFactory,dataSource);
        //构建一个configuration对象
        Configuration configuration=new Configuration(environment);
        configuration.getTypeAliasRegistry().registerAlias("user", User.class);
        //再加入一个映射器
        configuration.addMapper(UserMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList= mapper.selectList();
        for (User user : userList) {
            System.out.println(user);
        }

    }
}
