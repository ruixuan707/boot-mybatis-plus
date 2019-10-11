package com.monco.service.impl;

import com.monco.entity.Authority;
import com.monco.entity.RoleAuthority;
import com.monco.mapper.RoleAuthorityMapper;
import com.monco.service.IRoleAuthorityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 角色权限表 服务实现类
 * </p>
 *
 * @author monco
 * @since 2019-09-11
 */
@Service
public class RoleAuthorityServiceImpl extends ServiceImpl<RoleAuthorityMapper, RoleAuthority> implements IRoleAuthorityService {

    @Override
    public void saveOrUpdate(Long roleId, List<Authority> authorityList) {
        if (CollectionUtils.isEmpty(authorityList)) {
            return;
        }
        // 删除之前关联
        baseMapper.deleteRoleAuthority(roleId);
        // 新增关联
        List<RoleAuthority> roleAuthorityList = new ArrayList<>();
        for (Authority authority : authorityList) {
            RoleAuthority roleAuthority = new RoleAuthority();
            roleAuthority.setRoleId(roleId);
            roleAuthority.setAuthorityId(authority.getId());
            roleAuthorityList.add(roleAuthority);
        }
        this.saveBatch(roleAuthorityList);
    }
}
