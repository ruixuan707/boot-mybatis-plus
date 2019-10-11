package com.monco.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.monco.entity.User;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author monco
 * @since 2019-10-11
 */
public interface IUserService extends IService<User> {

    /**
     * 查询列表数据
     *
     * @param user
     * @return
     */
    List<User> getUserList(User user);

    /**
     * 查询分页数据
     *
     * @param page
     * @param user
     * @return
     */
    IPage<User> getUserPage(IPage<User> page, User user);
}
