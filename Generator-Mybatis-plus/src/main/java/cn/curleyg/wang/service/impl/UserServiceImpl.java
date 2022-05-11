package cn.curleyg.wang.service.impl;

import cn.curleyg.wang.entity.User;
import cn.curleyg.wang.mapper.UserMapper;
import cn.curleyg.wang.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wang
 * @since 2022-05-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
