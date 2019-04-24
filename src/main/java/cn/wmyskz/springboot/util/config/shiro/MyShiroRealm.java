package cn.wmyskz.springboot.util.config.shiro;

import cn.wmyskz.springboot.shiro.entity.*;
import cn.wmyskz.springboot.shiro.service.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2019年04月22日 15:31
 */
public class MyShiroRealm extends AuthorizingRealm{

    //用于用户查询
    @Autowired
    private ISysUseService userService;
    @Autowired
    private ISysRoleService roleService;
    @Autowired
    private ISysPermissionService permissionService;
    @Autowired
    private ISysUseRoleService useRoleService;
    @Autowired
    private ISysRolePermissionService rolePermissionService;
    //角色权限和对应权限添加   //授权认证用注解实现更佳
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        String name= (String) principalCollection.getPrimaryPrincipal();

        //查询用户名称
        SysUse user = userService.getOne(new QueryWrapper<SysUse>().eq("name",name));
        List<SysUseRole> sysUseRoles = useRoleService.list(new QueryWrapper<SysUseRole>().in("use_id",user.getId()));
        List<Integer> roleIds =sysUseRoles.stream().map(SysUseRole::getRoleId).collect(Collectors.toList());
        List<SysRole> roles = roleService.list(new QueryWrapper<SysRole>().in("id",roleIds));
        List<SysRolePermission> rolePermissions = rolePermissionService.list(new QueryWrapper<SysRolePermission>().in("role_id",roleIds));
        List<Integer> rolePermissionsIds =rolePermissions.stream().map(SysRolePermission::getPermissionId).collect(Collectors.toList());
        List<SysPermission> sysPermissions = permissionService.list(new QueryWrapper<SysPermission>().in("id",rolePermissionsIds));
        //添加角色和权限
       SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (SysRole role1:roles) {
            //添加角色
            simpleAuthorizationInfo.addRole(role1.getRoleName());
            for (SysPermission permission1:sysPermissions) {
                //添加权限
                simpleAuthorizationInfo.addStringPermission(permission1.getPermissionName());
            }
        }

        return simpleAuthorizationInfo;
    }

    //用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }

        //获取用户信息
        String name = authenticationToken.getPrincipal().toString();
        SysUse user = userService.getOne(new QueryWrapper<SysUse>().eq("name",name));

        if (user == null) {
            //这里返回后会报出对应异常
            return null;
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            System.out.println("测试加盐后的代码-->"+ByteSource.Util.bytes(name));
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, user.getPassword(), ByteSource.Util.bytes(name), getName());
            return simpleAuthenticationInfo;
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(new SimpleHash("SHA-256", "大师兄", ByteSource.Util.bytes("大师兄"), 4));
        }catch (Exception e){

        }
    }
}
