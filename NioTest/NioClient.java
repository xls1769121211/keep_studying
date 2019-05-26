import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 *  nio客户端的实现
 */
public class NioClient {
    private String name;

    public NioClient(String name) {
        this.name = name;
    }

    public void start() throws IOException {
        /**
         * 创建与服务端的链接
         */
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8000));
        System.out.println("客户端连接成功！");

        /**
         * 获取服务端的响应
         */
        //新启动一个线程 专门获取服务器端的响应数据
        //创建selector
        Selector selector = Selector.open();
        //channel非阻塞
        socketChannel.configureBlocking(false);
        //注册可读事件
        socketChannel.register(selector, SelectionKey.OP_READ);

       // socketChannel.write(Charset.forName("UTF-8").encode(name+"加入聊天室"));

        //启动子线程
        new Thread(new NioClientHandler(selector)).start();

        /**
         * 像服务器端发送消息,从键盘读取数据
         */
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String content = scanner.nextLine();
            if (content != null && content.length() >0){
                socketChannel.write(Charset.forName("UTF-8").encode(name + " : "+content));
            }
        }


    }


}
