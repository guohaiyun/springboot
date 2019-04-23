package cn.wmyskz.springboot.util.config.shiro;

import cn.wmyskz.springboot.shiro.entity.SysUse;
import cn.wmyskz.springboot.shiro.service.ISysUseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2019年04月22日 15:31
 */
public class MyShiroRealm extends AuthorizingRealm{

    //用于用户查询
    @Autowired
    private ISysUseService userService;

    //角色权限和对应权限添加   //授权认证用注解实现更佳
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        String name= (String) principalCollection.getPrimaryPrincipal();
        //查询用户名称
//        SysUse user = userService.getOne(new QueryWrapper<SysUse>().eq("name",name));

        SysUse user=new SysUse();
        Role role=new Role();
        role.setId(12);
        role.setRoleName("测试1");
        Permission permission = new Permission();
        permission.setId(1);
        List<Permission> list = new ArrayList<>();
//        permission.setRole();
        role.setPermissions(list);
        List<Role> roles = new ArrayList<>();
        user.setRoles(roles);
        //添加角色和权限
       SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (Role role1:user.getRoles()) {
            //添加角色
            simpleAuthorizationInfo.addRole(role1.getRoleName());
            for (Permission permission1:role1.getPermissions()) {
                //添加权限
                simpleAuthorizationInfo.addStringPermission(permission1.getPermission());
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
        SysUse user = new SysUse();//userService.getOne(new QueryWrapper<SysUse>().eq("name","123"));
        user.setPassword("123");
        if (user == null) {
            //这里返回后会报出对应异常
            return null;
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, user.getPassword().toString(), getName());
            return simpleAuthenticationInfo;
        }
    }
}
