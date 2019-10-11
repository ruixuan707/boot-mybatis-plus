package com.monco.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monco.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author monco
 * @since 2019-10-11
 */
public interface IRoleService extends IService<Role> {

    /**
     * 查询列表数据
     *
     * @param role
     * @return
     */
    List<Role> getRoleList(Role role);

    /**
     * 查询分页数据
     *
     * @param page
     * @param role
     * @return
     */
    IPage<Role> getRolePage(IPage<Role> page, Role role);

}
