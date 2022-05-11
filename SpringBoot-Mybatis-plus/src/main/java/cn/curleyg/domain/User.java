package cn.curleyg.domain;

import cn.curleyg.enums.GradeEnum;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @TableId
    private Long id;
    @TableField("name")
    private String name;
    private Integer age;
    private String email;
    private GradeEnum grade;
    @TableLogic
    private Integer idDel;

}