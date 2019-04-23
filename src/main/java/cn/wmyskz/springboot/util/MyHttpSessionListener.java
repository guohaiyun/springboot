package cn.wmyskz.springboot.util;
import lombok.Synchronized;
import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * @author haiyun.guo
 * @Description:
 * @date 2019年01月02日 15:44
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener{
    public static int online = 0;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("创建session");
        synchronized(this){
            online ++;
        }
//        System.out.println(online);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("销毁session");
        synchronized(this){
            online --;
        }
    }
}
