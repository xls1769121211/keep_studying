package test1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;


public class Recv {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        //rabbitmq连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //rabbitMq服务器地址
        factory.setHost("192.168.188.129");
        //创建连接
        Connection connection = factory.newConnection();
        //创建channel
        Channel channel = connection.createChannel();
        //定义队列 1 队列名称，是否持久化，是否独有链接，是否自动删除长时间未使用队列，其他配置
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");

            //消费之后尝试睡眠5000
            try {
                Thread.sleep(5000);
            }catch (Exception e){
                e.printStackTrace();
            }
        };

        //消费消息，1 队列名称，2 是否自动确认，3接收消息后的回调，4取消消费后的回调
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
            System.out.println("canceled........"+consumerTag);
        });
    }
}
