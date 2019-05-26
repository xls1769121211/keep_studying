import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * 专门用来处理服务器端的响应数据
 *
 */
public class NioClientHandler implements  Runnable{
    private Selector selector;

    public NioClientHandler(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void run() {
        try {
            //死循环
            for (;;) {
                /**
                 * 获取可用的channel 数量
                 */
                int readyChannels = selector.select();
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

                if (iterator.hasNext()) {
                    //获取这个 selectionKey 实例
                    SelectionKey selectionKey = (SelectionKey) iterator.next();
                    //将这个实例移除掉
                    iterator.remove();
                    //处理业
                    //如果是 可读
                    if (selectionKey.isReadable()) {
                        readHandler(selectionKey, selector);
                    }
                }
            }
        } catch (IOException e){
            System.out.println(e.getStackTrace());
        }
    }
    //可读事件处理器
    private void readHandler(SelectionKey selectionKey, Selector selector) throws IOException {
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
        //将从服务器端接收到的消息打印出
        if (content.length() >0){
            System.out.println(content);
        }
    }
}
