//package cn.wmyskz.springboot;
//
//import cn.wmyskz.springboot.cookie_session.entity.Student;
//import cn.wmyskz.springboot.cookie_session.mapper.StudentMapper;
//import cn.wmyskz.springboot.mongodb.mongo.entity.MongoStu;
//import cn.wmyskz.springboot.mongodb.mongo.mapper.StudentRepository;
//import lombok.Data;
//import lombok.extern.log4j.Log4j2;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Date;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Log4j2
//public class SpringbootApplicationTests {
//
//    @Autowired
//    private StudentRepository repository;
//
//    @Autowired
//    private StudentMapper mapper;
//    @Test
//    public void contextLoads() {
//
//         log.trace("I am trace log.");
//        log.debug("I am debug log.");
//        log.warn("I am warn log.");
//        log.error("I am error log.");
//        }
//    @Test
//    public void test1() {
//        Long start=System.currentTimeMillis();
//        for (int i = 0; i <1 ; i++) {
//            ces();
//        }
//        System.out.println("插入耗时-->"+(System.currentTimeMillis()-start)+"ms");
//    }
//    private void ces(){
//        MongoStu stu=new MongoStu(System.currentTimeMillis(),"","");
//        stu.setClassRoom("11");
//        stu.setSbirthday(new Date());
//        stu.setSname("hahha");
//        stu.setSno("sfasfasdf");
//        stu.setSsex("1");
//        repository.save(stu);
//    }
//
//    @Test
//    public void test2() {
//        Long start=System.currentTimeMillis();
//        for (int i = 0; i <1 ; i++) {
//            ces2();
//        }
//        System.out.println("插入耗时-->"+(System.currentTimeMillis()-start)+"ms");
//    }
//    private void ces2(){
//        Student stu=new Student();
//        stu.setId(System.currentTimeMillis());
//        stu.setClassRoom("11");
//        stu.setSbirthday(new Date());
//        stu.setSname("hahha");
//        stu.setSno("sfasfasdf");
//        stu.setSsex("1");
//        mapper.insert(stu);
//    }
//
//    @Test
//    public void test3(){
//        check("你怎么这么叼？还->😂用符号-->😘在😡干嘛🐷");
//    }
//
//    private boolean check(String str){
//
//
//        if(str.trim().isEmpty()){
//            return false;
//        }
//        String pattern="[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]";
//        String reStr="";
//        Pattern emoji=Pattern.compile(pattern);
//        Matcher emojiMatcher=emoji.matcher(str);
//        str=emojiMatcher.replaceAll(reStr);
//        System.out.println("测试看看-->"+str);
//        return false;
//    }
//}
//
