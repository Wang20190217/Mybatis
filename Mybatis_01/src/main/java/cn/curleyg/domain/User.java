package cn.curleyg.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 城南花已开<br>
 *
 * @Description: User实体类<br>
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
}
