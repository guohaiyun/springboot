package cn.wmyskz.springboot.cookie_session.controller;


import cn.wmyskz.springboot.validate.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2018-12-29
 */
@Controller
@RequestMapping("/cookie_session/student")
public class StudentController {
    @Autowired
    private ICourseService service;
    @RequestMapping("/login")
    public String hello(HttpServletRequest request, HttpServletResponse response,String author) {


        Cookie cookie=new Cookie("login","");
//        cookie.set
        cookie.setValue("213"+System.currentTimeMillis());
        cookie.setMaxAge(-1);
        response.addCookie(cookie);
        return "index2";
    }

    @RequestMapping("/getUser")
    public String hello2(HttpServletRequest request, HttpServletResponse response,String author) {
        Cookie[]cookies=request.getCookies();
        for (int i = 0; i <cookies.length ; i++) {
            if(cookies[i].getName().equals("login")){
                return "index";
            }
        }
        return "index2";
    }

    @RequestMapping("/getUser2")
    public void hello6(HttpServletRequest request, HttpServletResponse response) {
        Cookie[]cookies=request.getCookies();
        for (int i = 0; i <cookies.length ; i++) {
            if(cookies[i].getName().equals("login")){
                cookies[i].setMaxAge(0);
                response.addCookie(cookies[i]);
            }
        }
    }
    @RequestMapping("/getUser3")
    public void hello3(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session=request.getSession(true);
        session.setAttribute("ggg","aa");
        session.setMaxInactiveInterval(30);
        System.out.println(11);
    }


    @RequestMapping("/getUser4")
    public void hello4(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session=request.getSession();
        System.out.println(session.getAttribute("ggg"));
    }
    @RequestMapping("/getUser5")
    public void hello5(@NotNull Integer courseId) {
        //   service.removeById(courseId);
    }
}
