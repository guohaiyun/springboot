package cn.wmyskz.springboot.validate.controller;


import cn.wmyskz.springboot.validate.service.ICourseService;
import cn.wmyskz.springboot.validate.vo.Demo;
import cn.wmyskz.springboot.validate.vo.ValidatorDemo;
import cn.wmyskz.springboot.validate.vo.ValidatorDemo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2018-12-26
 */
// 详情配置查看地址 https://www.cnblogs.com/mr-yang-localhost/p/7812038.html#_label2_0

@RestController

//@Validated  //用来标识非JSON格式的请求
//@Validated
@Validated
@RequestMapping("/validate/course")
public class CourseController {
    @Autowired
    private ICourseService service;
    @RequestMapping("/getUser")
//    @Validated
    public void hello(@RequestBody  @Validated ValidatorDemo demo) {

    }
    @RequestMapping("/getUser2")
    public void hello2(@RequestBody  @Valid ValidatorDemo2 course) {
        System.out.println(course.getDemos().size());
    }
    @RequestMapping("/getUser3")
    public void hello3(@NotEmpty  String  course) {
        System.out.println(course);
    }


    @RequestMapping("/getUser4")
    public void hello4(@RequestBody @Valid Demo demo) {

        System.out.println(demo.getId());
    }
    @RequestMapping("/getUser5")
    public void hello5(@NotNull Integer courseId,@NotNull Integer vvv) {
     //   service.removeById(courseId);
    }



    @RequestMapping("/getUser6")
    public void hello6( @NotNull  Integer courseId) {
//        int v=1/0;
        service.test1();
    }
//    @RequestMapping("/getUser7")
//    public void hello7() {
////        jdbcTemplate.execute("select * from teacher");
//
//        System.out.println(c);
//    }
//
//    @RequestMapping("/getUser8")
//    public void hello8() {
////        jdbcTemplate.execute("select * from teacher");
//        System.out.println(c);
//    }
//    @RequestMapping("/getUser9")
//    public void hello9() {
////        jdbcTemplate.execute("select * from teacher");
//
//        System.out.println(c);
//    }
//    @RequestMapping("/getUser10")
//    public void hello10() {
////        jdbcTemplate.execute("select * from teacher");
//        System.out.println("vvvvvvvvvvvvvvvv");
//        System.out.println(c);
//    }
//
//    @RequestMapping("/getUser11")
//    public void hello11() {
////        jdbcTemplate.execute("select * from teacher");
//        System.out.println("vvvvvvvvvvvvvvvv");
//        System.out.println(c);
//    }
//
//    @RequestMapping("/getUser12")
//    public void hello12() {
////        jdbcTemplate.execute("select * from teacher");
//        System.out.println("vvvvvvvvvvvvvvvv");
//        System.out.println(c);
//    }
//    @RequestMapping("/getUser13")
//    public void hello13() {
////        jdbcTemplate.execute("select * from teacher");
//        System.out.println("vvvvvvvvvvvvvvvv");
//        System.out.println(c);
//    }
//
//    @RequestMapping("/getUser14")
//    public void hello14() {
////        jdbcTemplate.execute("select * from teacher");
//        System.out.println("vvvvvvvvvvvvvvvv");
//        System.out.println(c);
//    }
//    @RequestMapping("/getUser15")
//    public void hello15() {
////        jdbcTemplate.execute("select * from teacher");
//        System.out.println("vvvvvvvvvvvvvvvv");
//        System.out.println(c);
//    }
//    @RequestMapping("/getUser16")
//    public void hello16() {
////        jdbcTemplate.execute("select * from teacher");
//        System.out.println("vvvvvvvvvvvvvvvv");
//        System.out.println(c);
//    }
//    @RequestMapping("/getUser17")
//    public void hello17() {
////        jdbcTemplate.execute("select * from teacher");
//        System.out.println("vvvvvvvvvvvvvvvv");
//        System.out.println(c);
//    }
//
//    @RequestMapping("/getUser18")
//    public void hello18() {
////        jdbcTemplate.execute("select * from teacher");
//        System.out.println("vvvvvvvvvvvvvvvv");
//        System.out.println(c);
//    }
//
//    @RequestMapping("/getUser19")
//    public void hello19() {
////        jdbcTemplate.execute("select * from teacher");
//        System.out.println("vvvvvvvvvvvvvvvv");
//        System.out.println(c);
//    }
//
//    @RequestMapping("/getUser20")
//    public void hello20() {
////        jdbcTemplate.execute("select * from teacher");
//        System.out.println("vvvvvvvvvvvvvvvv");
//        System.out.println("zzzzzzzzzzzzzzzzzzzzzzzz");
//        System.out.println(c);
//    }
//
//    @RequestMapping("/getUser21")
//    public void hello21() {
////        jdbcTemplate.execute("select * from teacher");
//        System.out.println("vvvvvvvvvvvvvvvv");
//        System.out.println("zzzzzzzzzzzzzzzzzzzzzzzz");
//        System.out.println(c);
//    }
//    @RequestMapping("/getUser22")
//    public void hello22() {
////       serviceInterface
//        serviceInterface.test();
//    }
//    @RequestMapping("/getUser23")
//    public void hello23() {
////        serviceInterface.test();
////       serviceInterface
////        anInterface.test();
//    }
}
