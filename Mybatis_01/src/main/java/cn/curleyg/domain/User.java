package cn.curleyg.domain;

import cn.curleyg.enums.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * 城南花已开<br>
 *
 * @Description: User实体类 <br>
 * @Project: <br>
 * @CreateDate: Created in 2022/5/8 17:55 <br>
 * @Author: Wang
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String address;
    private Integer age;
    private String phone;
    private Sex sex;
    private Fere fere;
    List<Role> roleList;
    public User(Integer id,String name){
        System.out.println("执行了两个参数的构造函数");
        this.setId(id);
        this.setName(name);
    }

}
