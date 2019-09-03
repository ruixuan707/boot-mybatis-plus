package com.monco.staff.service;

import com.monco.staff.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author monco
 * @since 2019-09-04
 */
public interface IUserService extends IService<User> {

  List<User> getList(User user);
}
