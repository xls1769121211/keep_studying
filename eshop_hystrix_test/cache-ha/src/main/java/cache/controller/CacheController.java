package cache.controller;

import cache.command.GetProductInfo2Command;
import cache.command.GetProductInfoCommand;
import cache.command.GetProductInfosCommand;
import cache.http.HttpClientUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import rx.Observable;
import rx.Observer;

import java.util.concurrent.Future;

/**
 * @description:
 * @author: xingliushan
 * @createDate: 2020/3/16
 * @version: 1.0
 */
@Controller
public class CacheController{
    @RequestMapping("/cache/product")
    @ResponseBody
    public String hello(String productId) {
        //调用产品服务去更新商品信息,模拟
        String url = "http://localhost:8086/product/getProductInfo?productId="+productId;
        String res = HttpClientUtils.sendGetRequest(url);
        System.out.println("获取商品信息成功===================【"+res+"】");
        return "success!";
    }

    @RequestMapping("/cache/noCacheProduct")
    @ResponseBody
    public String noCacheProduct(String productId) {
        //使用HystrixCommand 调用商品信息
        //方式1 同步方式
        //String res = new GetProductInfoCommand(productId).execute();
        //方式2 异步获取
        Future<String> queue = new GetProductInfoCommand(productId).queue();
        try {
            System.out.println("异步获取开始【"+queue.isDone()+"】");
            Thread.sleep(2000);
            System.out.println("获取商品信息成功===================【"+queue.get()+"】");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "success!";
    }


    @RequestMapping("/cache/manyProduct")
    @ResponseBody
    public String manyProduct(String productId) {
        //使用HystrixCommand 调用商品信息
        //方式1 同步方式
        //String res = new GetProductInfoCommand(productId).execute();
        //方式2 异步获取
        String res =  new GetProductInfo2Command(productId).execute();
        return res;
    }


    @RequestMapping("/cache/noCacheProductInfos")
    @ResponseBody
    public String noCacheProductInfos(String productIds) {
        //使用HystrixCommand 调用商品信息
        final Observable<String> observe = new GetProductInfosCommand(productIds.split(",")).observe();



        observe.subscribe(new Observer<String>(){
            @Override
            public void onCompleted() {
                System.out.println("接收完成======");
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        });

        return "success!";
    }
}
