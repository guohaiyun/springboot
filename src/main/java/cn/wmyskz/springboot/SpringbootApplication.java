package cn.wmyskz.springboot;

import com.spring4all.mongodb.EnableMongoPlus;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@ServletComponentScan
@EnableMongoPlus
@MapperScan("cn.wmyskz.springboot.*.mapper")
//@EnableMongoRepositories("cn.wmyskz.springboot.mongodb.mongo.mapper")
public class SpringbootApplication {

    public static void main(String[] args) {
        System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
        SpringApplication.run(SpringbootApplication.class, args);
    }

}

