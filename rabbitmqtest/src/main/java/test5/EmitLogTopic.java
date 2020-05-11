package test5;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * topic模式
 * 可以用表达式去匹配消息分配到哪个队列
 */
public class EmitLogTopic {

    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.188.129");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            //设置exchange类型 topic
            channel.exchangeDeclare(EXCHANGE_NAME, "topic");

            String routingKey = "aaaa.error";
            String message = getMessage(argv);

            channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");

            routingKey = "info.asadjaskldaljd.asdas.a.dasdsad.a.sd.a.ds.sa.d";
            channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");


            routingKey = "aaaa";
            channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");
        }
    }

    private static String getRouting(String[] strings) {
        if (strings.length < 1)
            return "anonymous.info";
        return strings[0];
    }

    private static String getMessage(String[] strings) {
        if (strings.length < 2)
            return "Hello World!";
        return joinStrings(strings, " ", 1);
    }

    private static String joinStrings(String[] strings, String delimiter, int startIndex) {
        int length = strings.length;
        if (length == 0) return "";
        if (length < startIndex) return "";
        StringBuilder words = new StringBuilder(strings[startIndex]);
        for (int i = startIndex + 1; i < length; i++) {
            words.append(delimiter).append(strings[i]);
        }
        return words.toString();
    }
}

