package cn.curleyg.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 城南花已开<br>
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created in 2022/5/9 04:48 <br>
 * @Author: Wang
 */


@Getter
@AllArgsConstructor
public enum Sex {
    MALE(1, "男"),
    FEMALE(2, "女");
    private int id;
    private String name;

    public static Sex getSex(int id) {
        if (id == 1) {
            return MALE;
        } else if (id == 2) {
            return FEMALE;
        }
        return null;
    }

}
