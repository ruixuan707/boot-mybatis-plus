package com.monco.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monco.entity.User;
import com.monco.mapper.UserMapper;
import com.monco.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
* <p>
    * 用户表 服务实现类
    * </p>
*
* @author monco
* @since 2019-10-16
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getUserList(User user) {
        return userMapper.selectList(getWrapper(user));
    }

    @Override
    public IPage<User> getUserPage(IPage<User> page, User user) {
        return userMapper.selectPage(page, getWrapper(user));
    }

    private QueryWrapper<User> getWrapper(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (user.getId() != null) {
            queryWrapper.eq("id", user.getId());
        }
        if (user.getDataStatus() != null) {
            queryWrapper.eq("data_status", user.getDataStatus());
        }
        if (user.getCreateId() != null) {
            queryWrapper.eq("create_id", user.getCreateId());
        }
        if (StringUtils.isNotBlank(user.getCreateName())) {
            queryWrapper.like("create_name", user.getCreateName());
        }
        if (user.getUpdateId() != null) {
            queryWrapper.eq("update_id", user.getUpdateId());
        }
        if (StringUtils.isNotBlank(user.getUpdateName())) {
            queryWrapper.like("update_name", user.getUpdateName());
        }
        return new QueryWrapper<>(user);
    }
}
