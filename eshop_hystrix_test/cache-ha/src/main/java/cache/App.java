package cache;

import cache.http.HttpClientUtils;

/**
 * @description:
 * @author: xingliushan
 * @createDate: 2020/3/16
 * @version: 1.0
 */
public class App{
    public static void main(String[] args) throws InterruptedException {
        //模拟多条请求出发短路机制
        System.out.println("正常请求开始========");
        for (int i = 0; i < 15; i++) {
            String url = "http://localhost:8085/cache/manyProduct?productId="+i;
            String res = HttpClientUtils.sendGetRequest(url);
            System.out.println(res);
        }
        System.out.println("正常请求结束========");
        System.out.println("异常请求开始========");
        for (int i = 0; i < 15; i++) {
            String url = "http://localhost:8085/cache/manyProduct?productId=bbb";
            String res = HttpClientUtils.sendGetRequest(url);
            System.out.println(res);
        }
        System.out.println("异常请求结束========");
        System.out.println("尝试出发短路器经过一个时间窗口检测，触发短路========");
        Thread.sleep(3000);
        System.out.println("短路后，异常请求开始========");
        for (int i = 0; i < 15; i++) {
            String url = "http://localhost:8085/cache/manyProduct?productId=bbb";
            String res = HttpClientUtils.sendGetRequest(url);
            System.out.println(res);
        }
        System.out.println("短路后，异常请求结束========");

        Thread.sleep(3000);
        System.out.println("正常请求开始========");
        for (int i = 0; i < 15; i++) {
            String url = "http://localhost:8085/cache/manyProduct?productId="+i;
            String res = HttpClientUtils.sendGetRequest(url);
            System.out.println(res);
        }
        System.out.println("正常请求结束========");
    }
}
