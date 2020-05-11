package test2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/**
 * Work queues
 */
public class NewTask {

    private static final String TASK_QUEUE_NAME = "task_queue";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.188.129");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            //开启持久化，如果不开启持久化，当mq服务器出故障重启会，那么会丢失消息，
            channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
            for (int i = 0; i < 4; i++) {
                String message = "aaaa...."+i;
                channel.basicPublish("", TASK_QUEUE_NAME,
                        //设置一定性保障消息不丢失，通知msg持久化
                        MessageProperties.PERSISTENT_TEXT_PLAIN,
                        message.getBytes("UTF-8"));
                System.out.println(" [x] Sent '" + message + "'");
                Thread.sleep(1000);
            }

        }
    }

}
