package cn.curleyg.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 城南花已开<br>
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created in 2022/5/9 04:17 <br>
 * @Author: Wang
 */
@MappedTypes({String.class})   //定义的是Java中的类型
@MappedJdbcTypes(JdbcType.VARCHAR) //定义的是数据库中的类型
public class MyStringTypeHandler implements TypeHandler<String> {
     Logger log = Logger.getLogger(MyStringTypeHandler.class);

    @Override
    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        log.info("使用我的TypeHandler");
        ps.setString(i,parameter);
    }

    @Override
    public String getResult(ResultSet rs, String columnName) throws SQLException {
        log.info("使用我的TypeHandler,ResultSet获取结果");
        return rs.getString(columnName);
    }

    @Override
    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
        log.info("使用我的TypeHandler,ResultSet下标获取结果");
        return rs.getString(columnIndex);
    }

    @Override
    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        log.info("使用我的TypeHandler,CallableStatement下标获取结果");
        return cs.getString(columnIndex);
    }
}
