package cache.command;


import cache.http.HttpClientUtils;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @description: 获取一条商品信息，基于Hystrix
 * @author: xingliushan
 * @createDate: 2020/3/16
 * @version: 1.0
 */
public class GetProductInfoCommand extends HystrixCommand<String>{
    private String productId;

    public GetProductInfoCommand(String productId) {
        super(HystrixCommandGroupKey.Factory.asKey("GetProductInfoGroup"));

        this.productId = productId;
    }

    @Override
    protected String run() throws Exception {
//        try {
//            Thread.sleep(1000);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        String url = "http://localhost:8086/product/getProductInfo?productId="+productId;
        String res = HttpClientUtils.sendGetRequest(url);
        return res;
    }

    @Override
    protected String getCacheKey() {
        return "info_"+productId;
    }
}
