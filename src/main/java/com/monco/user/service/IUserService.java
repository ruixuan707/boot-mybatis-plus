package com.monco.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monco.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author monco
 * @since 2019-09-04
 */
public interface IUserService extends IService<User> {

    /**
     * @return java.util.List<com.monco.user.entity.User>
     * @Author monco
     * @Description // 根据条件获取用户列表
     * @Date 4:26 2019/9/4
     * @Param [user]
     **/
    List<User> getList(User user);


    /**
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.monco.user.entity.User>
     * @Author monco
     * @Description //分页查询
     * @Date 4:29 2019/9/4
     * @Param [page, user]
     **/
    IPage<User> getPage(IPage<User> page, User user);
}
