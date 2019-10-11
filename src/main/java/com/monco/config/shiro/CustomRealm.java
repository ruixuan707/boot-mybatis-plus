package com.monco.config.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName CustomRealm
 * @Description
 * @Author monco
 * @Date 2019/9/5 0:16
 * @Version 1.0
 */
public class CustomRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("-------权限认证方法开始--------");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> stringSet = new HashSet<>();
        stringSet.add("user:show");
        stringSet.add("user:admin");
        info.setStringPermissions(stringSet);
        System.out.println("-------权限认证方法结束--------");
        return info;
    }

    /**
     * 这里可以注入userService,为了方便演示，我就写死了帐号了密码
     * private UserService userService;
     * <p>
     * 获取即将需要认证的信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("-------身份认证方法开始--------");
        String username = (String) authenticationToken.getPrincipal();
        String userPwd = new String((char[]) authenticationToken.getCredentials());
        //根据用户名从数据库获取密码
        String password = "9ff322019ad2f4d46ddd3d159160fecd";
        String salt = "/IVmqPUXl8G0gKhJf8WvkQ==";
        if (username == null) {
            throw new AccountException("用户名不正确");
        }
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        System.out.println("-------身份认证方法结束--------");
        return new SimpleAuthenticationInfo(username, password, ByteSource.Util.bytes(salt), getName());
    }
}

