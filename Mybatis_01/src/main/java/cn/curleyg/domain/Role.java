package cn.curleyg.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 城南花已开<br>
 *
 * @Description: 角色 一个user可以有很多角色<br>
 * @Project: <br>
 * @CreateDate: Created in 2022/5/9 19:27 <br>
 * @Author: Wang
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Integer id;
    private String name;
    private String userid;

}
