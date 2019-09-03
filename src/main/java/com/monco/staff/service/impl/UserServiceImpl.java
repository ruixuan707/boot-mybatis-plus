package com.monco.staff.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monco.staff.entity.User;
import com.monco.staff.mapper.UserMapper;
import com.monco.staff.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
* <p>
    *  服务实现类
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
        return userMapper.selectList(getQueryWrapper(user));
    }


    private QueryWrapper<User> getQueryWrapper(User user) {
        return new QueryWrapper<User>();
    }
}