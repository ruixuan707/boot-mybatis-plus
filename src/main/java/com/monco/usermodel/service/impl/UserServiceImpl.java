package com.monco.usermodel.service.impl;

import com.monco.usermodel.model.UserModel;
import com.monco.usermodel.mapper.UserMapper;
import com.monco.usermodel.service.IUserService;
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
