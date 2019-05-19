package NioTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * nio 编程练习 server端
 * nio 核心 selector buffer channel
 *
 */
public class NioServer {
    //主方法
    public static void main(String[] args) {

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
                //如果是 接入
                //如果是 可读

            }

        }

    }
}
