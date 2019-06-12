package cn.wmyskz.springboot.demo.controller;

import cn.wmyskz.springboot.demo.entity.User;
import cn.wmyskz.springboot.demo.service.TestServiceInterface;
import cn.wmyskz.springboot.exception.MyException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.awt.event.ActionEvent;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2018年12月24日 11:26
 */


@Controller
@RequestMapping("demo")
@Api(description = "测试demo",value = "ces")
public class HelloController {

    @Autowired
    private TestServiceInterface serviceInterface;

    private static String a="asfaasfass";
    private static String b="asfaasfass";
    private static String c="asfaasfass";
    @RequestMapping("/getUser")
    //ModelMap modelMap
    @ApiOperation("测试看看")
    public String hello() {
        System.out.println("afdas");
        return "index";
//        System.out.println(author);
//        System.out.println(author);
//        System.out.println(vvv+","+ttt);
//
//        serviceInterface.test();
//        serviceInterface.test1();

    }
    @RequestMapping("/config")
    public void hello2(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
//        String rootPath = request.getSession().getServletContext().getRealPath("/");
//        try {
//            String exec = new request, rootPath).exec();
//            PrintWriter writer = response.getWriter();
//            writer.write(exec);
//            writer.flush();
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    @RequestMapping("/getUser3")
    public void hello3(@RequestBody @Valid  User user) {

        System.out.println(user.getCname());
//        List<ObjectError> errorList = result.getAllErrors();
//
//        for (ObjectError error:errorList) {
//            System.out.println(error.getCode()+","+error.getObjectName()+","+error.getClass());
//        }
//        System.out.println(result);
//        throw new MyException();

//        System.out.println();
//        serviceInterface.test3();
    }
    @RequestMapping("/getUser4")
    public void hello4() {
        throw  new MyException("测试看看");
//        jdbcTemplate.execute("select * from teacher");
//        System.out.println(11111);
//        System.out.println("sdfas");
//        System.out.println("hello spring boot");
//        System.out.println("sdfas");
//        System.out.println("sdfas");
//        System.out.println(b);
    }
    @RequestMapping("/getUser5")
    public void hello5() {
//        jdbcTemplate.execute("select * from teacher");
        System.out.println(11111);
        System.out.println("sdfas");
        System.out.println("hello spring boot");
        System.out.println("sdfas");
        System.out.println("sdfas");
        System.out.println(b);
    }

    @RequestMapping("/getUser6")
    public void hello6() {
//        jdbcTemplate.execute("select * from teacher");
        System.out.println(11111);
        System.out.println("sdfas");
        System.out.println("hello spring boot");
        System.out.println("sdfas");
        System.out.println("sdfas");
        System.out.println(b);
    }
    @RequestMapping("/getUser7")
    public void hello7() {
//        jdbcTemplate.execute("select * from teacher");

        System.out.println(c);
    }

    @RequestMapping("/getUser8")
    public void hello8() {
//        jdbcTemplate.execute("select * from teacher");
        System.out.println(c);
    }
    @RequestMapping("/getUser9")
    public void hello9() {
//        jdbcTemplate.execute("select * from teacher");

        System.out.println(c);
    }
    @RequestMapping("/getUser10")
    public void hello10() {
//        jdbcTemplate.execute("select * from teacher");
        System.out.println("vvvvvvvvvvvvvvvv");
        System.out.println(c);
    }

    @RequestMapping("/getUser11")
    public void hello11() {
//        jdbcTemplate.execute("select * from teacher");
        System.out.println("vvvvvvvvvvvvvvvv");
        System.out.println(c);
    }

    @RequestMapping("/getUser12")
    public void hello12() {
//        jdbcTemplate.execute("select * from teacher");
        System.out.println("vvvvvvvvvvvvvvvv");
        System.out.println(c);
    }
    @RequestMapping("/getUser13")
    public void hello13() {
//        jdbcTemplate.execute("select * from teacher");
        System.out.println("vvvvvvvvvvvvvvvv");
        System.out.println(c);
    }

    @RequestMapping("/getUser14")
    public void hello14() {
//        jdbcTemplate.execute("select * from teacher");
        System.out.println("vvvvvvvvvvvvvvvv");
        System.out.println(c);
    }
    @RequestMapping("/getUser15")
    public void hello15() {
//        jdbcTemplate.execute("select * from teacher");
        System.out.println("vvvvvvvvvvvvvvvv");
        System.out.println(c);
    }
    @RequestMapping("/getUser16")
    public void hello16() {
//        jdbcTemplate.execute("select * from teacher");
        System.out.println("vvvvvvvvvvvvvvvv");
        System.out.println(c);
    }
    @RequestMapping("/getUser17")
    public void hello17() {
//        jdbcTemplate.execute("select * from teacher");
        System.out.println("vvvvvvvvvvvvvvvv");
        System.out.println(c);
    }

    @RequestMapping("/getUser18")
    public void hello18() {
//        jdbcTemplate.execute("select * from teacher");
        System.out.println("vvvvvvvvvvvvvvvv");
        System.out.println(c);
    }

    @RequestMapping("/getUser19")
    public void hello19() {
//        jdbcTemplate.execute("select * from teacher");
        System.out.println("vvvvvvvvvvvvvvvv");
        System.out.println(c);
    }

    @RequestMapping("/getUser20")
    public void hello20() {
//        jdbcTemplate.execute("select * from teacher");
        System.out.println("vvvvvvvvvvvvvvvv");
        System.out.println("zzzzzzzzzzzzzzzzzzzzzzzz");
        System.out.println(c);
    }

    @RequestMapping("/getUser21")
    public void hello21() {
//        jdbcTemplate.execute("select * from teacher");
        System.out.println("vvvvvvvvvvvvvvvv");
        System.out.println("zzzzzzzzzzzzzzzzzzzzzzzz");
        System.out.println(c);
    }
    @RequestMapping("/getUser22")
    public void hello22() {
//       serviceInterface
//        serviceInterface.test();
    }
    @RequestMapping("/getUser23")
    public void hello23() {
//        serviceInterface.test();
//       serviceInterface
//        anInterface.test();
    }
}

