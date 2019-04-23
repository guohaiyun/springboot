package cn.wmyskz.springboot.util.config.machine;

import cn.wmyskz.springboot.stateMachine.statusenum.Events;
import cn.wmyskz.springboot.stateMachine.statusenum.Events2;
import cn.wmyskz.springboot.stateMachine.statusenum.States;
import javafx.util.Builder;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;

import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.transition.Transition;
import redis.clients.jedis.Transaction;


import java.util.EnumSet;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2019年04月15日 20:09
 */
@Configuration
//该注解用来启用Spring StateMachine状态机功能
@EnableStateMachine
@Log4j2
//@Scope(scopeName="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
//@ConditionalOnClass(value= org.aspectj.lang.annotation.Aspect.class)
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {


    @Override
//    @Scope(scopeName="session", proxyMode= ScopedProxyMode.TARGET_CLASS)
    public void configure(StateMachineStateConfigurer<States, Events> states)
            throws Exception {
        states
                .withStates()
                .initial(States.UNPAID)   //定义了初始状态为UNPAID
                .end(States.END)
                .states(EnumSet.allOf(States.class));  //指定States中的所有状态作为该状态机的状态定义。
    }

    /*
    configure用来初始化当前状态机有哪些状态迁移动作
    从其中命名中我们很容易理解每一个迁移动作，都有来源状态source，目标状态target以及触发事件event。
    * */
    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
            throws Exception {
        transitions
                .withExternal()
                .source(States.UNPAID).target(States.WAITING_FOR_RECEIVE)
                .event(Events.PAY)
                .and()
                .withExternal()
                .source(States.WAITING_FOR_RECEIVE).target(States.DONE)
                .event(Events.RECEIVE)
                .and()
                .withExternal()
                .source(States.DONE).target(States.END)
                .event(Events.MARK);

    }
    /*
    configure为当前的状态机指定了状态监听器，其中listener()则是调用了下一个函数创建的监听器实例，用来处理各个各个发生的状态迁移事件。
    这里注释是因为我们有其他更好的方法去替代
    * */
//    @Override
//    public void configure(StateMachineConfigurationConfigurer<States, Events> config)
//            throws Exception {
//        config
//            .withConfiguration().autoStartup(true).listener(listener);
//
//
////                  // 指定状态机的处理监听器
//    }
    /*
    listener()方法用来创建StateMachineListener状态监听器的实例，
    在该实例中会定义具体的状态迁移处理逻辑，上面的实现中只是做了一些输出，
    实际业务场景会有更严密的逻辑，所以通常情况下，我们可以将该实例的定义放到独立的类定义中，并用注入的方式加载进来。
    这里注释是因为我们有其他更好的方法去替代
    * */
//    @Bean
//    public org.springframework.statemachine.listener.StateMachineListener<States, Events> listener() {
//        return new StateMachineListenerAdapter<States, Events>() {
//
//            @Override
//            public void transition(Transition<States, Events> transition) {
//
//                System.out.println(transition.getTarget().getIds());
//                if(transition.getTarget().getId() == States.UNPAID) {
//                    log.info("订单创建，待支付");
//                    return;
//                }
//
//                if(transition.getSource().getId() == States.UNPAID
//                        && transition.getTarget().getId() == States.WAITING_FOR_RECEIVE) {
//                    log.info("用户完成支付，待收货");
//                    return;
//                }
//
//                if(transition.getSource().getId() == States.WAITING_FOR_RECEIVE
//                        && transition.getTarget().getId() == States.DONE) {
//                    log.info("用户已收货，订单完成");
//                    return;
//                }
//
//            }
//
//
//        };
//    }

}

