package com.monco.staff.service.impl;

import com.monco.staff.model.UserModel;
import com.monco.staff.mapper.UserMapper;
import com.monco.staff.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, UserModel> implements IUserService {

}
