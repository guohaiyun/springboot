package cn.wmyskz.springboot.shiro.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-04-24
 */
@RestController
@RequestMapping("/shiro/sys-use")
public class SysUseController {
    //post登录
    @RequestMapping(value = "/login")
    public String login(String username,String password){
        System.out.println("1111111111111111111111111111111");
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        if(!subject.isAuthenticated()){
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                    username,
                    password);

            //进行验证，这里可以捕获异常，然后返回对应信息

            try {
                subject.login(usernamePasswordToken);
                //if no exception, that's it, we're done!
            } catch ( UnknownAccountException uae ) {
                throw uae;
                //username wasn't in the system, show them an error message?
            } catch ( IncorrectCredentialsException ice ) {
                //password didn't match, try again?
                throw ice;
            } catch ( LockedAccountException lae ) {
                //account for that username is locked - can't login.  Show them a message?
                throw lae;
            }
        }
        subject.logout();
        return "test";
    }

    @RequestMapping(value = "/test2")
    @RequiresPermissions("test1")
    public String test2(@RequestBody Map map){
        System.out.println("测试权限");
        return "111";
    }

    @RequestMapping(value = "/test3")
//    @RequiresPermissions("test1")
    public String test3(@RequestBody Map map){
        System.out.println("测试权限是否有");
        return "111";
    }
}
