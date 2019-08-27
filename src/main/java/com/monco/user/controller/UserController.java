package com.monco.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monco.user.model.UserModel;
import com.monco.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author monco
 * @since 2019-08-26
 */
@RestController
@RequestMapping("/user/user-model")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public List<UserModel> getList(@RequestParam(required = false) String userName,
                                   @RequestParam(required = false) String nickName) {
        QueryWrapper<UserModel> queryWrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("user_name", userName);
        map.put("nick_name", nickName);
        queryWrapper.allEq(map, false);
        return userService.list(queryWrapper);
    }

    @PutMapping
    public void update() {
        UserModel userModel = userService.getById(12L);
        userModel.setStatus("停止");
        userService.updateById(userModel);
    }

    @DeleteMapping
    public void delete() {
        userService.removeById(2L);
    }

    @GetMapping("page")
    public IPage<UserModel> getListByPage(@RequestParam(value = "size", defaultValue = "10") long size,
                                          @RequestParam(value = "current", defaultValue = "0") long current) {
        Page<UserModel> modelPage = new Page<>();
        modelPage.setCurrent(current);
        modelPage.setSize(size);
        return userService.page(modelPage);
    }

    @PostMapping
    public void save() {
        UserModel userModel = new UserModel();
        userModel.setMerchantId(1L);
        userModel.setUserName("monco");
        userModel.setNickName("monco");
        userModel.setPassword("password");
        userModel.setSecurityKey("security_key");
        userModel.setVersion(0L);
        userService.save(userModel);
    }
}
