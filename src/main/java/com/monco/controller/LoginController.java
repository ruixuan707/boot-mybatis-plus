package com.monco.controller;

import com.monco.common.response.ApiResult;
import com.monco.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther: monco
 * @Date: 2019/9/10 11:47
 * @Description: 登录入口
 */
@Slf4j
@RestController
@RequestMapping("login")
public class LoginController {

    @PostMapping
    public ApiResult login(@RequestParam("username") String username, @RequestParam("password") String password) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            return ApiResult.error("未知账户");
        } catch (IncorrectCredentialsException ice) {
            return ApiResult.error("用户名或密码不正确");
        } catch (LockedAccountException lae) {
            return ApiResult.error("账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            return ApiResult.error("用户名或密码错误次数过多");
        } catch (AuthenticationException ae) {
            return ApiResult.error("用户名或密码不正确！");
        }
        if (subject.isAuthenticated()) {
            return ApiResult.ok("登录成功");
        } else {
            token.clear();
            return ApiResult.error("登录失败");
        }
    }

}
