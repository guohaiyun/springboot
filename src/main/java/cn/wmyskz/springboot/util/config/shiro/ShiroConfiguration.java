package cn.wmyskz.springboot.util.config.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2019年04月22日 15:29
 */
@Configuration
public class ShiroConfiguration {

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("SHA-256");//散列算法:MD2、MD5、SHA-1、SHA-256、SHA-384、SHA-512等。
        hashedCredentialsMatcher.setHashIterations(4);//散列的次数，默认1次， 设置两次相当于 md5(md5(""));
        return hashedCredentialsMatcher;
    }
    //将自己的验证方式加入容器
    @Bean
    public  MyShiroRealm myShiroRealm() {
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher()); //+++++++++++
        return myShiroRealm;
    }

    //权限管理，配置主要是Realm的管理认证
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        securityManager.setSessionManager(sessionManager());
        securityManager.setCacheManager(cacheManager());
        return securityManager;
    }
    /**
     * cacheManager 缓存 redis实现
     * 使用的是shiro-redis开源插件
     * @return
     */
    public RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        return redisCacheManager;
    }



    /**
     * 配置shiro redisManager
     * 使用的是shiro-redis开源插件
     * @return
     */
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setPort(6379);
        redisManager.setHost("127.0.0.1");
        redisManager.setTimeout(1000);
        redisManager.setExpire(1800);
//        redisManager.setPassword();
        // redisManager.setPassword(password)
        return redisManager;
    }


    /**
     * RedisSessionDAO shiro sessionDao层的实现 通过redis
     * 使用的是shiro-redis开源插件
     */
    @Bean
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        return redisSessionDAO;
    }

    /**
     * shiro session的管理
     */
    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(redisSessionDAO());
        return sessionManager;
    }





    //Filter工厂，设置对应的过滤条件和跳转条件
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> map = new HashMap<>();

//        //对所有用户认证
            map.put("/logout", "logout");
            map.put("/shiro/sys-use/login", "anon");
            map.put("/**","authc");
//        //登录
        shiroFilterFactoryBean.setLoginUrl("/login");
//        //首页
        shiroFilterFactoryBean.setSuccessUrl("/index");
//        //错误页面，认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/error");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    //加入注解的使用，不加入这个注解不生效
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
    public static void main(String[] args) {
        System.out.println(1^1^2^2^3^4^4);
    }



    // 获得本周日24点时间
//    public static Date getTimesWeeknight() {
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(getTimesWeekmorning());
//        cal.add(Calendar.DAY_OF_WEEK, 7);
//        return cal.getTime();
//    }

//    //获取本月的开始时间
//    public static String getBeginDayOfMonth() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(getNowYear(), getNowMonth() - 1, 1);
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//        return sdf1.format(calendar.getTime());
//    }
//
//    //获取本月的结束时间
//    public static String getEndDayOfMonth() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(getNowYear(), getNowMonth() - 1, 1);
//        int day = calendar.getActualMaximum(5);
//        calendar.set(getNowYear(), getNowMonth() - 1, day);
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//        return sdf1.format(calendar.getTime());
//    }
//
//    //获取今年是哪一年
//    public static Integer getNowYear() {
//        Date date = new Date();
//        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
//        gc.setTime(date);
//        return Integer.valueOf(gc.get(1));
//    }
//
//    //获取本月是哪一月
//    public static int getNowMonth() {
//        Date date = new Date();
//        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
//        gc.setTime(date);
//        return gc.get(2) + 1;
//    }

    public static Date getFirstDayOfMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 获取当前月份的最后一天
     */
    public static Date getLastDayOfMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        return calendar.getTime();
    }
}
