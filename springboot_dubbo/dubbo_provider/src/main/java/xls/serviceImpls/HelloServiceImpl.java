package xls.serviceImpls;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import xls.interfaces.HelloService;

@Component
@Service
public class HelloServiceImpl implements HelloService{
    @Override
    public void sayHello(String name) {
        System.out.println(name);
    }
}
