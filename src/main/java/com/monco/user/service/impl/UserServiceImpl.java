package com.monco.user.service.impl;

import com.monco.user.entity.User;
import com.monco.user.mapper.UserMapper;
import com.monco.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author monco
 * @since 2019-08-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
