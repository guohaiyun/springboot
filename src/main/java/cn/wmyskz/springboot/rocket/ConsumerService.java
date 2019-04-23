package cn.wmyskz.springboot.rocket;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2019年04月12日 14:19
 */
import java.util.List;


import cn.wmyskz.springboot.util.config.rocket.MessageEvent;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {
////    @EventListener(condition = "#event.msgs[0].topic=='user-topic' && #event.msgs[0].tags=='white'")
////    public void rocketmqMsgListener(MessageEvent event) {
////        try {
////            List<MessageExt> msgs = event.getMsgs();
////            for (MessageExt msg : msgs) {
////                System.err.println("消费消息:" + new String(msg.getBody()));
////            }
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
    @EventListener
    public void rocketmqMsgListenerAll(MessageEvent event) {
//            int i=1/0;
            List<MessageExt> msgs = event.getMsgs();
            for (MessageExt msg : msgs) {

                System.err.println("消费消息All:" + new String(msg.getBody()));
            }

    }

//    @EventListener(condition = "#event.msgs[0].topic=='user-topic' && #event.msgs[0].tags=='black'")
//    public void rocketmqMsgListenerBlack(MessageEvent event) {
//        try {
//            List<MessageExt> msgs = event.getMsgs();
//            for (MessageExt msg : msgs) {
//                System.err.println("消费消息Black:" + new String(msg.getBody()));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    @EventListener
//    public void rocketmqMsgListenerWhite(MessageEvent event) {
//        try {
//            List<MessageExt> msgs = event.getMsgs();
//            for (MessageExt msg : msgs) {
//                System.err.println("消费消息All:" + new String(msg.getBody()));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }



//    @EventListener(condition = "#event.msgs[0].topic=='user-topic' && #event.msgs[0].tags=='white'")
//    public void rocketmqMsgListener3(MessageEvent event) {
//        try {
//            List<MessageExt> msgs = event.getMsgs();
//            for (MessageExt msg : msgs) {
//                System.err.println("消费消息white:" + new String(msg.getBody()));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
    public static void main(String[] args) throws Exception {

            DefaultMQProducer producer = new DefaultMQProducer("push_consumer");
            producer.setNamesrvAddr("127.0.0.1:9876");
            try {
                // 设置实例名称
                producer.setInstanceName("producer_broadcast");
                // 设置重试次数
                producer.setRetryTimesWhenSendFailed(3);
                // 开启生产者
                producer.start();
                // 创建一条消息
                for (int i = 0; i <10 ; i++) {
                    Message msg = new Message("topic_broadcast", "TagA", "OrderID0034", "message_broadcast_test".getBytes());
                    SendResult send = producer.send(msg);
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            producer.shutdown();
        }
//
//    public static void main(String[] args) throws Exception{
//        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer_broadcast");
//        consumer.setNamesrvAddr("192.168.31.176:9876;192.168.31.165:9876");
//        // 批量消费,每次拉取10条
//        consumer.setConsumeMessageBatchMaxSize(10);
//        //设置广播消费
//        consumer.setMessageModel(MessageModel.BROADCASTING);
//        //设置集群消费
////        consumer.setMessageModel(MessageModel.CLUSTERING);
//        // 如果非第一次启动，那么按照上次消费的位置继续消费
//        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
//        // 订阅PushTopic下Tag为push的消息
//        consumer.subscribe("topic_broadcast", "TagA || Tag B || Tage C");
//        consumer.registerMessageListener(new MqBroadCastListener());
//        consumer.start();
//        System.out.println("Consumer1 Started.");
//
//    }
//
//
////    public static void main(String[] args) throws Exception {
////        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("example_group_name");
////
////        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
////
////        //set to broadcast mode
////        consumer.setMessageModel(MessageModel.BROADCASTING);
////
////        consumer.subscribe("TopicTest", "TagA || TagC || TagD");
////
////        consumer.registerMessageListener(new MessageListenerConcurrently() {
////
////            @Override
////            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
////                                                            ConsumeConcurrentlyContext context) {
////                System.out.printf(Thread.currentThread().getName() + " Receive New Messages: " + msgs + "%n");
////                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
////            }
////        });
////
////        consumer.start();
////        System.out.printf("Broadcast Consumer Started.%n");
////    }
//
//}
//
//class MqBroadCastListener implements MessageListenerConcurrently{
//    @Override
//    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
//        try {
//            MessageExt msg = msgs.get(0);
//            String msgBody = new String(msg.getBody(), "utf-8");
//            System.out.println("msgBody:" + msgBody);
//        } catch(Exception e) {
//            e.printStackTrace();
//            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
//        }
//        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//    }
//
}
