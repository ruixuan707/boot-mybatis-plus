package com.monco.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monco.common.response.ApiResult;
import com.monco.entity.User;
import com.monco.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.security.auth.Subject;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author monco
 * @since 2019-10-16
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    /**
     * 新增User方法
     *
     * @param user
     * @return
     */
    @PostMapping
    public ApiResult save(@RequestBody User user) {
        String salt = new SecureRandomNumberGenerator().nextBytes().toString(); //盐量随机
        String encodedPassword = new SimpleHash("md5", user.getPassword(), salt, 2).toString();
        user.setPassword(encodedPassword);
        user.setSalt(salt);
        userService.save(user);
        return ApiResult.ok();
    }

    /**
     * 修改User方法
     *
     * @param user
     * @return
     */
    @PutMapping
    public ApiResult update(@RequestBody User user) {
        userService.updateById(user);
        return ApiResult.ok();
    }

    /**
     * 查询列表
     *
     * @param user
     * @return
     */
    @GetMapping("list")
    public ApiResult list(User user) {
        return ApiResult.ok(userService.getUserList(user));
    }

    /**
     * 查询分页
     *
     * @param current 当前页
     * @param size    一页多少数据
     * @param user
     * @return
     */
    @GetMapping("page")
    public ApiResult page(@RequestParam(required = false, defaultValue = "0") long current,
                          @RequestParam(required = false, defaultValue = "10") long size, User user) {
        return ApiResult.ok(userService.getUserPage(new Page<User>().setCurrent(current).setSize(size), user));
    }

    /**
     * 删除方法
     *
     * @param id
     * @return
     */
    @DeleteMapping
    public ApiResult delete(@RequestParam Long id) {
        userService.removeById(id);
        return ApiResult.ok();
    }

    /**
     * 按照id获取单条记录
     *
     * @param id
     * @return
     */
    public ApiResult getOne(@RequestParam Long id) {
        return ApiResult.ok(userService.getById(id));
    }
}
