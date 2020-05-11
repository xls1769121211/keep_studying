package cache.command;


import cache.http.HttpClientUtils;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

/**
 * @description: 获取一条商品信息，基于Hystrix,断路器实验
 * @author: xingliushan
 * @createDate: 2020/3/16
 * @version: 1.0
 */
public class GetProductInfo2Command extends HystrixCommand<String>{
    private String productId;

    public GetProductInfo2Command(String productId) {
        //自定义短路器
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GetProductInfo2Command"))
            .andCommandPropertiesDefaults(
                    HystrixCommandProperties.Setter()
                            //错误，异常，拒绝占比
                            .withCircuitBreakerErrorThresholdPercentage(40)
                            //短路器最大请求数量
                            .withCircuitBreakerRequestVolumeThreshold(20)
                            //自动尝试关闭短路器时间
                            .withCircuitBreakerSleepWindowInMilliseconds(3000)
            )
        );
     //   super(HystrixCommandGroupKey.Factory.asKey("GetProductInfoGroup"));
        this.productId = productId;
    }

    @Override
    protected String run() throws Exception {
        if (productId.equals("bbb")){
            throw new Exception();
        }
        String url = "http://localhost:8086/product/getProductInfo?productId="+productId;
        String res = HttpClientUtils.sendGetRequest(url);
        return res;
    }

    @Override
    protected String getFallback() {
        return "this is not  good";
    }
}
