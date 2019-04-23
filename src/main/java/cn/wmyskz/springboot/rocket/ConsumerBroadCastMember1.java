package cn.wmyskz.springboot.rocket;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2019年04月13日 15:26
 */
class MqBroadCastListener implements MessageListenerConcurrently{
    @Override
    public org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        try {
            MessageExt msg = msgs.get(0);
            String msgBody = new String(msg.getBody(), "utf-8");
            System.out.println("msgBody:" + msgBody);
        } catch(Exception e) {
            e.printStackTrace();
            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}

public class ConsumerBroadCastMember1 {
    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer_broadcast");
        consumer.setNamesrvAddr("127.0.0.1:9876");
        // 批量消费,每次拉取10条
        consumer.setConsumeMessageBatchMaxSize(10);
        //设置广播消费
//        consumer.setMessageModel(MessageModel.BROADCASTING);
        //设置集群消费
        consumer.setMessageModel(MessageModel.CLUSTERING);
        // 如果非第一次启动，那么按照上次消费的位置继续消费
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        // 订阅PushTopic下Tag为push的消息
        consumer.subscribe("topic_broadcast", "TagA || Tag B || Tage C");
//        MqBroadCastListener listener=new MqBroadCastListener();
        consumer.registerMessageListener(new MqBroadCastListener());
        consumer.start();
        System.out.println("Consumer1 Started.");

    }

}

