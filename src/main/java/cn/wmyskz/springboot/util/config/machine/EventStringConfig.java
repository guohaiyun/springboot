//package cn.wmyskz.springboot.util.config.machine;
//
//import lombok.extern.log4j.Log4j2;
//import org.springframework.statemachine.annotation.*;
//
///**
// * @author haiyun.guo
// * @Description:
// * @date 2019年04月16日 18:30
// */
//@WithStateMachine
//@Log4j2
//public class EventStringConfig {
//
//    @OnTransition(target = "start")
//    public void create() {
//        log.info("测试创建");
//    }
//
//    @OnTransition(source = "start", target = "middel")
//    public void test1() {
//        log.info("测试中");
//    }
////    @OnExtendedStateChanged(key = "")
////    public void exchange(){
////        log.info("状态改变了");
////    }
//
//
//    @OnTransitionStart(source = "start", target = "middel")
//    public void payStart() {
//        log.info("测试: start");
//    }
//    @OnExtendedStateChanged
//    public void exchange(){
//        log.info("状态改变了");
//    }
//    @OnTransitionEnd(source = "start", target = "middel")
//    public void payEnd() {
//        log.info("测试: end");
//    }
//
//
//    @OnTransitionStart(source = "middel", target = "end")
//    public void mark3() {
//        log.info("测试结束");
//    }
//}
