package cn.curleyg.dao;

import cn.curleyg.domain.Fere;
import cn.curleyg.domain.Role;
import cn.curleyg.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 城南花已开<br>
 *
 * @Description: User Dao 接口<br>
 * @Project: <br>
 * @CreateDate: Created in 2022/5/8 18:00 <br>
 * @Author: Wang
 */
public interface UserMapper {
    /*** 添加用户信息 */
    int insertUser(User user);

    List<User> selectList();
    User selectOne(Integer id);

    //注解版
    @Select("select * from user")
    List<User> selectLists();

    @Select("select * from user where name like #{name}")
    List<User> selectName(String name);

    Fere selectFere(Integer userid);
    List<Role> selectRoleList(Integer id);

    List<User> selectUserList(User user);

}
