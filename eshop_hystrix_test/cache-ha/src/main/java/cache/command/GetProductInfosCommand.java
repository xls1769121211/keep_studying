package cache.command;

import cache.http.HttpClientUtils;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * @description: 批量获取商品信息
 * @author: xingliushan
 * @createDate: 2020/3/16
 * @version: 1.0
 */
public class GetProductInfosCommand extends HystrixObservableCommand<String>{
    private String[] productIds;

    public GetProductInfosCommand(String[] productIds) {
        super(HystrixCommandGroupKey.Factory.asKey("GetProductInfoGroup"));
        this.productIds = productIds;
    }

    @Override
    protected Observable<String> construct() {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> observer) {
                try {
                    for (String productId : productIds) {
                        String url = "http://localhost:8086/product/getProductInfo?productId="+productId;
                        String res = HttpClientUtils.sendGetRequest(url);
                        observer.onNext(res);
                    }
                    observer.onCompleted();
                } catch (Exception e) {
                    observer.onError(e);
                }
            }
        } ).subscribeOn(Schedulers.io());
    }
}
