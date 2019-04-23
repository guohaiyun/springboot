package cn.wmyskz.springboot.demo.controller;

import cn.wmyskz.springboot.demo.entity.User;
import cn.wmyskz.springboot.demo.service.TestServiceInterface;
import cn.wmyskz.springboot.util.MyHttpSessionListener;
import cn.wmyskz.springboot.util.TestCom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2018年12月24日 11:30
 */
@Controller()

@RequestMapping("/fuck")
@TestCom("切面注解测试类")
//@PropertySource(value = "classpath:/mybro.properties")
public class LoginController {
    private Logger logger= LogManager.getLogger(LoginController.class);
    @Value("${server.port}")
    private String VV;
    @Autowired
    private TestServiceInterface listener;
    @RequestMapping("/index")
    //@TestCom("切面注解测试方法")
    public String getIndex(HttpServletRequest request){
        HttpSession session=request.getSession(true);
        session.setAttribute("ggg","aa");
        session.setMaxInactiveInterval(30);
        System.out.println(11);
        System.out.println("当前在线人数"+MyHttpSessionListener.online);
        return "hah";
    }
//
    @RequestMapping("/freeIndex")
    public String getFreeIndex(){
//        System.out.println("11");
//        listener.test();
        System.out.println("测试是否可取到值"+VV);
        return "index";
    }

    @RequestMapping("/fvreeIndex2")
    public String getFreeIndex2(HttpServletRequest request){
        for (int i = 0; i < 100; i++) {
            try {
                int vv=1/0;
            }catch (Exception e){
                logger.error(e.getMessage(),e);

            }
        }


       // System.out.println("bean-->"+VV);
        User user=new User();
        user.setCno("vvv");
        User v=listener.test(user);

        System.out.println(v.getCno());
        return v.getCno();
    }
}
