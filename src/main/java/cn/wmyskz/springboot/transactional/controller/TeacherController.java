package cn.wmyskz.springboot.transactional.controller;


import cn.wmyskz.springboot.transactional.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
 * @since 2019-01-09
 */
@RestController
@RequestMapping("/transactional/teacher")
public class TeacherController {
    @Autowired
    private ITeacherService service;

    @RequestMapping("/getUser")
    public String hello2(HttpServletRequest request, HttpServletResponse response, String author) {
        service.test();
        return "index2";
    }

    @RequestMapping("/getUser2")
    public void hello6(HttpServletRequest request, HttpServletResponse response) {
        service.test1();
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
