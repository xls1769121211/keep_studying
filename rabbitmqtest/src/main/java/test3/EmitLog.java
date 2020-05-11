package test3;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Publish/Subscribe 发布订阅模式
 */
public class EmitLog {

    //定义交换机名称
    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.188.129");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            //给channel设置exchange，并设置exchange类型
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");


            String message = argv.length < 1 ? "info: Hello World!" :
                    String.join(" ", argv);

//           发布消息给exchange，而不是queue
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");
        }
    }

}

