

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * nio 编程练习 server端
 * nio 核心 selector buffer channel
 *
 */
public class NioServer {
    //主方法
    public static void main(String[] args) throws IOException{
        NioServer nioServer = new NioServer();
        nioServer.startServer();
    }

    //服务器启动方法
    private void startServer() throws IOException {
        /**
         * 第一步
         * 得到 selector 对象
         * selector 的主要作用是 根据连接 找到相应selectorkey 对应的channel
         * 建立连接
         * 当有读或者写等任何注册的事件发生时，可以从Selector中获得相应的SelectionKey，
         * 同时从SelectionKey中可以找到发生的事件和该事件所发生的具体的SelectableChannel，以获得客户端发送过来的数据
         */
        Selector selector = Selector.open();

        /**
         * 第二步
         * 通过 ServerSocketChannel 创建channel 通道
         */
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        /**
         * 第三步
         * 为channel通道绑定监听端口
         */
        serverSocketChannel.bind(new InetSocketAddress(8000));

        /**
         * 第四步
         *设置channel为非阻塞模式
         */

        serverSocketChannel.configureBlocking(false);

        /**
         * 的第五步
         * 将 channel 注册到selector上，监听连接
         */

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务器启动成功！");

        /**
         * 第六步
         * 循环等待 监听连接
         */
        //死循环
        for (;;){

            /**
             * 获取可用的channel 数量
             */
            int readyChannels  = selector.select();
            /**
             * TODO 为什么要这样、？？
             * 防止空轮询 CPU利用100%
             */
            if (readyChannels == 0) continue;

            /**
             * 获取selectionKey 集合 获取可用的channel 集合
             */

            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            /**
             * 迭代便利集合得到 selectionKey 实例
             */
            Iterator iterator = selectionKeys.iterator();

            if (iterator.hasNext()){
                //获取这个 selectionKey 实例
                SelectionKey selectionKey = (SelectionKey)iterator.next();
                //将这个实例移除掉
                iterator.remove();
                //处理业务
                //如果是 接入 seletionKey 有一个方法可以判断是接入还是 可读
                if (selectionKey.isAcceptable()){
                    acceptHandler(serverSocketChannel,selector);
                }
                //如果是 可读
                if (selectionKey.isReadable()){
                    readHandler(selectionKey,selector);
                }
            }

        }

    }

    /**
     *  接入事件处理器
     */
    private void acceptHandler(ServerSocketChannel serverSocketChannel,Selector selector) throws IOException{
        //接入事件处理器，建立与客户端的连接，获取socketChannel
        SocketChannel socketChannel = serverSocketChannel.accept();

        //设置channel 为非阻塞模式
        socketChannel.configureBlocking(false);

        //将chnnel 注册到selector上面 监听可读事件
        socketChannel.register(selector,SelectionKey.OP_READ);

//        给客户端 返回消息
        socketChannel.write(Charset.forName("UTF-8").encode("not friend,be cautious!"));
    }

    //可读事件处理器
    private void readHandler(SelectionKey selectionKey,Selector selector) throws IOException{
        //获取 selectionKey中已经就绪的channel
        SocketChannel socketChannel  =  (SocketChannel) selectionKey.channel();

        //创建 bytebuffer 读取channel 中的数据
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //读取channel中的内容
        String content = "";
        while (socketChannel.read(byteBuffer) > 0){
            //先切换 buffer的状态  切换为读的状态
            byteBuffer.flip();
            content += Charset.forName("UTF-8").decode(byteBuffer);
        }

        //将channel 注册到selector 上 监听可读事件
        socketChannel.register(selector,SelectionKey.OP_READ);
        //将消息广播到其他客户端
        if (content.length() >0){
            //广播到其他客户端
           broadCast(selector,socketChannel,content);
        }
    }

    //将消息广播到其他客户端
    private void broadCast(Selector selector,SocketChannel sourceSocketChannel ,String content) throws IOException{
        //获取所有的SelectionKey
       Set<SelectionKey> selectionKeys =  selector.keys();
       //循环所有的key 获取channel
        selectionKeys.forEach(selectionKey -> {
            Channel socketChannel =  selectionKey.channel();
            //删除发出消息的channel
            if (socketChannel instanceof SocketChannel && socketChannel != sourceSocketChannel){
                //发送消息
                try {
                    ((SocketChannel)socketChannel).write(Charset.forName("UTF-8").encode(content));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });

    }

}
