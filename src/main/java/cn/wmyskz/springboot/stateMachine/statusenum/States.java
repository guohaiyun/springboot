package cn.wmyskz.springboot.stateMachine.statusenum;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2019年04月15日 20:01
 */
public enum States {
    UNPAID,                 // 待支付
    WAITING_FOR_RECEIVE,    // 待收货
    DONE,                   //待评价
    END                     //完成
}
