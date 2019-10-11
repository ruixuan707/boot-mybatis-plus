package com.monco.service;

import com.monco.entity.Authority;
import com.monco.entity.RoleAuthority;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色权限表 服务类
 * </p>
 *
 * @author monco
 * @since 2019-09-11
 */
public interface IRoleAuthorityService extends IService<RoleAuthority> {

    /**
     * 保存角色信息 和 权限信息
     *
     * @param roleId
     * @param authorityList
     */
    void saveOrUpdate(Long roleId, List<Authority> authorityList);

}
