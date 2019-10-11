package com.monco.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monco.common.response.ApiResult;
import com.monco.entity.Role;
import com.monco.service.IRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* <p>
    * 角色表 前端控制器
    * </p>
*
* @author monco
* @since 2019-10-11
*/
@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private IRoleService roleService;

    /**
     * 新增Role方法
     *
     * @param role
     * @return
     */
    @PostMapping
    public ApiResult save(@RequestBody Role role) {
        roleService.save(role);
        return ApiResult.ok();
    }

    /**
     * 修改Role方法
     *
     * @param role
     * @return
     */
    @PutMapping
    public ApiResult update(@RequestBody Role role) {
        roleService.updateById(role);
        return ApiResult.ok();
    }

    /**
     * 查询列表
     *
     * @param role
     * @return
     */
    @GetMapping("list")
    public ApiResult list(Role role) {
        return ApiResult.ok(roleService.getRoleList(role));
    }

    /**
     * 查询分页
     *
     * @param current 当前页
     * @param size    一页多少数据
     * @param role
     * @return
     */
    @GetMapping("page")
    public ApiResult page(@RequestParam(required = false, defaultValue = "0") long current,
                          @RequestParam(required = false, defaultValue = "10") long size, Role role) {
        return ApiResult.ok(roleService.getRolePage(new Page<Role>().setCurrent(current).setSize(size), role));
    }

    /**
     * 删除方法
     *
     * @param id
     * @return
     */
    @DeleteMapping
    public ApiResult delete(@RequestParam Long id) {
        roleService.removeById(id);
        return ApiResult.ok();
    }
}
