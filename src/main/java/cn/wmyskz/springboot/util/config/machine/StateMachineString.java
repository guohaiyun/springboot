//package cn.wmyskz.springboot.util.config.machine;
//
//import cn.wmyskz.springboot.stateMachine.statusenum.Events;
//import cn.wmyskz.springboot.stateMachine.statusenum.Events2;
//import cn.wmyskz.springboot.stateMachine.statusenum.States;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import org.springframework.context.annotation.Scope;
//import org.springframework.context.annotation.ScopedProxyMode;
//import org.springframework.core.task.SyncTaskExecutor;
//import org.springframework.statemachine.StateMachine;
//import org.springframework.statemachine.config.EnableStateMachine;
//import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
//import org.springframework.statemachine.config.StateMachineBuilder;
//import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
//import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
//import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
//import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
//import org.springframework.statemachine.listener.StateMachineListener;
//import org.springframework.statemachine.listener.StateMachineListenerAdapter;
//import org.springframework.statemachine.transition.Transition;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.annotation.SessionScope;
//
//import java.util.EnumSet;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * @author haiyun.guo
// * @Description:
// * @date 2019年04月16日 15:57
// */
//
////@Configuration
//////该注解用来启用Spring StateMachine状态机功能
////
////@EnableStateMachine
//////@Log4j2
////@SessionScope
////public class StateMachineString extends StateMachineConfigurerAdapter<String, String> {
////    /*
////   configure用来初始化当前状态机拥有哪些状态。
////   * */
////    @Override
//////    @Scope(scopeName="session", proxyMode= ScopedProxyMode.TARGET_CLASS)
////    public void configure(StateMachineStateConfigurer<String, String> states)
////            throws Exception {
////        Set<String>stringSet=new HashSet<String>();
////        stringSet.add("start");
////        stringSet.add("middel");
////        stringSet.add("end");
////        states
////                .withStates()
////                .initial("start")   //定义了初始状态为UNPAID
////                .states(stringSet);
//////                .states(EnumSet.allOf(States.class));  //指定States中的所有状态作为该状态机的状态定义。
////    }
////
////    /*
////    configure用来初始化当前状态机有哪些状态迁移动作
////    从其中命名中我们很容易理解每一个迁移动作，都有来源状态source，目标状态target以及触发事件event。
////    * */
////    @Override
////    public void configure(StateMachineTransitionConfigurer<String, String> transitions)
////            throws Exception {
////        transitions
////                .withExternal()
////                .source("start").target("middel")
////                .event("toMid")
////                .and()
////                .withExternal()
////                .source("middel").target("end")
////                .event("toEnd");
////
////
////    }
////     /*
////    configure为当前的状态机指定了状态监听器，其中listener()则是调用了下一个函数创建的监听器实例，用来处理各个各个发生的状态迁移事件。
////    这里注释是因为我们有其他更好的方法去替代
////    * */
//////    @Override
//////    public void configure(StateMachineConfigurationConfigurer<String, String> config)
//////            throws Exception {
//////        config
//////            .withConfiguration().machineId("stringMachine");
////////                .listener(listener());   // 指定状态机的处理监听器
//////    }
////    /*
////    listener()方法用来创建StateMachineListener状态监听器的实例，
////    在该实例中会定义具体的状态迁移处理逻辑，上面的实现中只是做了一些输出，
////    实际业务场景会有更严密的逻辑，所以通常情况下，我们可以将该实例的定义放到独立的类定义中，并用注入的方式加载进来。
////    这里注释是因为我们有其他更好的方法去替代
////    * */
//////    @Bean
//////    public StateMachineListener<String, String> listener() {
//////        return new StateMachineListenerAdapter<String, String>() {
//////
//////            @Override
//////            public void transition(Transition<String, String> transition) {
//////
//////               // System.out.println(transition.getTarget().getIds());
//////                if(transition.getSource().getId().equals("start")) {
//////                    log.info("测试开始");
//////                    return;
//////                }
//////
//////                if(transition.getSource().getId() .equals("start")
//////                        && transition.getTarget().getId() .equals("middel")) {
//////                    log.info("测试中");
//////                    return;
//////                }
//////
//////                if(transition.getSource().getId()  .equals("middel")
//////                        && transition.getTarget().getId() .equals("end")) {
//////                    log.info("测试完成");
//////                    return;
//////                }
//////
//////            }
//////
//////
//////        };
//////    }
////}
//
////@Configuration
////public class StateMachineString {
////
////    @Bean
////    @Scope(scopeName="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
////    StateMachine<String, String> stateMachine() throws Exception {
////        StateMachineBuilder.Builder<String, String> builder = StateMachineBuilder.builder();
////        builder.configureConfiguration()
////                .withConfiguration()
////                .autoStartup(true)
////                .taskExecutor(new SyncTaskExecutor());
////        builder.configureStates()
////                .withStates()
////                .initial("S1")
////                .state("S2");
////        builder.configureTransitions()
////                .withExternal()
////                .source("S1")
////                .target("S2")
////                .event("E1");
////        StateMachine<String, String> stateMachine = builder.build();
////        return stateMachine;
////    }
////
////}
//@Configuration
//@EnableStateMachine
////@Component
//@Scope(scopeName="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
//public  class StateMachineString extends StateMachineConfigurerAdapter<String, String> {
//
//    @Override
//    public void configure(StateMachineConfigurationConfigurer<String, String> config) throws Exception {
//        config
//                .withConfiguration()
//                .autoStartup(true);
//    }
//
//    @Override
//    public void configure(StateMachineStateConfigurer<String, String> states) throws Exception {
//        states
//                .withStates()
//                .initial("S1")
//                .state("S2");
//    }
//
//    @Override
//    public void configure(StateMachineTransitionConfigurer<String, String> transitions) throws Exception {
//        transitions
//                .withExternal()
//                .source("S1")
//                .target("S2")
//                .event("E1");
//    }
//
//}