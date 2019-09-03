package com.monco.user.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monco.user.entity.User;
import com.monco.user.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author monco
 * @since 2019-09-04
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @GetMapping("page")
    public IPage<User> userIPage() {
        return userService.getPage(new Page<User>().setSize(10).setCurrent(0), new User().setNickName("qq").setUsername("bb"));
    }
}
