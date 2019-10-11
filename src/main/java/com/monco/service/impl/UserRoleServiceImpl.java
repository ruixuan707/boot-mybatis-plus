package com.monco.service.impl;

import com.monco.entity.UserRole;
import com.monco.mapper.UserRoleMapper;
import com.monco.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author monco
 * @since 2019-09-11
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
