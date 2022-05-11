package cn.curleyg.domain;

import com.baomidou.mybatisplus.annotation.TableName;
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
//@TableName("sys_user")
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}