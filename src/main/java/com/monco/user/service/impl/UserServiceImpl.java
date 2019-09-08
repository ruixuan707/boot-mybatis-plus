package com.monco.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monco.user.entity.User;
import com.monco.user.mapper.UserMapper;
import com.monco.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author monco
 * @since 2019-09-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getList(User user) {
        return userMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public IPage<User> getPage(IPage<User> page, User user) {
        return userMapper.selectPage(page, getQueryWrapper(user));
    }


    private QueryWrapper<User> getQueryWrapper(User user) {
        return new QueryWrapper<User>()
                .eq("username", user.getUsername()).or(true).eq("username", user.getNickName());

    }
}
