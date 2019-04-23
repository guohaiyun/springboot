package cn.wmyskz.springboot.stateMachine;

import cn.wmyskz.springboot.stateMachine.statusenum.Events;
import cn.wmyskz.springboot.stateMachine.statusenum.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2019年04月15日 19:57
 */
@RestController
@RequestMapping("/state/machine")
public class controller {

    @Autowired
    private StateMachine<States, Events> stateMachine;

//    @Autowired
//    private StateMachine<String, String> stringMachine;


//    @RequestMapping("/getTest1")
//    public void test1(){
//        stateMachine.start();
//        stateMachine.sendEvent("a");
//        stateMachine.sendEvent("bb");  //通过调用用sendEvent(Events.RECEIVE)来完成收货操作
////        eventMachine.sendEvent(Events.MARK);
//
//    }
//    @RequestMapping("/getTest2")
//    public void test2(){
//        stringMachine.start();
//        stringMachine.sendEvent("toMid");
//
//
//
////        stringMachine.sendEvent("toEnd");
//    }
//
//
//
    @RequestMapping("/getTest3")
    public void test3(){
         stateMachine.start();    //start()就是创建这个订单流程，根据之前的定义，该订单会处于待支付状态，



//        eventMachine.start();    //start()就是创建这个订单流程，根据之前的定义，该订单会处于待支付状态，
//        eventMachine.sendEvent(Events.PAY);    //通过调用sendEvent(Events.PAY)执行支付操作，




//        stateMachine.sendEvent(Events.RECEIVE);
//        stateMachine.sendEvent(Events.);
//        stateMachine.addStateListener();
    }
    @RequestMapping("/getTest4")
    public void test4(){
        stateMachine.sendEvent(Events.PAY);    //通过调用sendEvent(Events.PAY)执行支付操作，


    }

    @RequestMapping("/getTest2")
    public void test2(){


        stateMachine.sendEvent(Events.RECEIVE);  //通过调用用sendEvent(Events.RECEIVE)来完成收货操作
        stateMachine.hasStateMachineError();

        stateMachine.sendEvent(Events.MARK);
    }
//@Autowired
//StateMachine<String, String> stateMachine;
//
//    @RequestMapping(path="/state")
//    public void setState() {
//        stateMachine.sendEvent("E1");
////        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
//    }
//
////    @RequestMapping(path="/state", method=RequestMethod.GET)
////    @ResponseBody
////    public String getState() {
////        return stateMachine.getState().getId();
////    }
}
