package test1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;

/**
 * rabbitmq 简单模式
 */
public class Send {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        //连接工厂
        ConnectionFactory factory = new ConnectionFactory();
//        mq服务器地址
        factory.setHost("192.168.188.129");
//       使用try 不用手动关闭连接
        try (Connection connection = factory.newConnection();
             //创建channel
             Channel channel = connection.createChannel()) {
            //定义队列 1 队列名称，是否持久化，是否独有链接，是否自动删除长时间未使用队列，其他配置
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            for (int i = 0; i < 3; i++) {
                String message = "Hello World!"+i;
//               发布消息 1 消息队列交换机，按一定的规则将消息路由转发到某个队列，对消息进行过虑,2队列名称，3其他属性，4消息内容
                channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
                System.out.println(" [x] Sent '" + message + "'");
            }

        }
    }
}
