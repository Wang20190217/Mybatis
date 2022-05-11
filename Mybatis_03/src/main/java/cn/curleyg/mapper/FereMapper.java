package cn.curleyg.mapper;

import cn.curleyg.admin.Fere;
import java.util.List;

public interface FereMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Fere record);

    Fere selectByPrimaryKey(Integer id);

    List<Fere> selectAll();

    int updateByPrimaryKey(Fere record);
}