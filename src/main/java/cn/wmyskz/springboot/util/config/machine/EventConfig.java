package cn.wmyskz.springboot.util.config.machine;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2019年04月15日 20:21
 */

import lombok.extern.log4j.Log4j2;
import org.apache.juli.logging.Log;
import org.springframework.statemachine.annotation.*;

import java.security.Key;

/**
 * 该配置实现了com.didispace.StateMachineConfig类中定义的状态机监听器实现。
 */
@WithStateMachine
@Log4j2
public class EventConfig {

//    @OnTransition(target = "E1")
//    public void TEST() {
//        log.info("订单创建，待支付");
//    }


    @OnTransition(target = "UNPAID")
    public void create() {
        log.info("订单创建，待支付");
    }

    @OnTransition(source = "UNPAID", target = "WAITING_FOR_RECEIVE")
    public void test1() {
        log.info("用户完成支付，待收货");
    }
//    @OnExtendedStateChanged(key = "")
//    public void exchange(){
//        log.info("状态改变了");
//    }


    @OnTransitionStart(source = "UNPAID", target = "WAITING_FOR_RECEIVE")
    public void payStart() {
        log.info("用户完成支付，待收货: start");
    }
    @OnExtendedStateChanged
    public void exchange(){
        log.info("状态改变了");
    }
    @OnTransitionEnd(source = "UNPAID", target = "WAITING_FOR_RECEIVE")
    public void payEnd() {
        int i=1/0;
        log.info("用户完成支付，待收货: end");

    }

    @OnTransition(source = "WAITING_FOR_RECEIVE", target = "DONE")
    public void receive() {
        log.info("用户已收货，订单完成");
    }

    @OnTransition(source = "DONE", target = "END")
    public void mark() {
        log.info("评价中");
    }

    @OnTransitionEnd(source = "DONE", target = "END")
    public void mark1() {
        log.info("评价结束");
    }
    @OnTransitionStart(source = "DONE", target = "END")
    public void mark3() {
        log.info("评价开始");
    }
}
