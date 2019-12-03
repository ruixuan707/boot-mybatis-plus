package com.monco.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.monco.entity.Role;
import com.monco.mapper.RoleMapper;
import com.monco.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
* <p>
    * 角色表 服务实现类
    * </p>
*
* @author monco
* @since 2019-10-11
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> getRoleList(Role role) {
        return roleMapper.selectList(getWrapper(role));
    }

    @Override
    public IPage<Role> getRolePage(IPage<Role> page, Role role) {
        return roleMapper.selectPage(page, getWrapper(role));
    }

    private QueryWrapper<Role> getWrapper(Role role) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        if (role.getId() != null) {
            queryWrapper.eq("id", role.getId());
        }
        if (role.getDataStatus() != null) {
            queryWrapper.eq("data_status", role.getDataStatus());
        }
        if (role.getCreateId() != null) {
            queryWrapper.eq("create_id", role.getCreateId());
        }
        if (StringUtils.isNotBlank(role.getCreateName())) {
            queryWrapper.like("create_name", role.getCreateName());
        }
        if (role.getUpdateId() != null) {
            queryWrapper.eq("update_id", role.getUpdateId());
        }
        if (StringUtils.isNotBlank(role.getUpdateName())) {
            queryWrapper.like("update_name", role.getUpdateName());
        }
        return new QueryWrapper<>(role);
    }
}
