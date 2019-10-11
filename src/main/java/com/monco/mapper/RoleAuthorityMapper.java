package com.monco.mapper;

import com.monco.entity.RoleAuthority;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 角色权限表 Mapper 接口
 * </p>
 *
 * @author monco
 * @since 2019-09-11
 */
public interface RoleAuthorityMapper extends BaseMapper<RoleAuthority> {

    /**
     * 删除角色关联的权限
     *
     * @param roleId
     */
    void deleteRoleAuthority(Long roleId);
}
