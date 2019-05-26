package com.xls.ioc.test;


import com.xls.ioc.IocContainer;
import com.xls.ioc.car.AuDi;
import com.xls.ioc.car.Buike;
import com.xls.ioc.human.LisiHuman;
import com.xls.ioc.human.ZhanSan;
import org.junit.Before;
import org.junit.Test;

public class TestIoc {
    private IocContainer iocContainer = new IocContainer();
    @Before
    public void before(){
        iocContainer.setBean(AuDi.class,"audi");
        iocContainer.setBean(Buike.class,"buike");
        iocContainer.setBean(ZhanSan.class,"zhangsan","audi");
        iocContainer.setBean(LisiHuman.class,"lisi","buike");
    }

    @Test
    public void Test(){
        ZhanSan zhanSan = (ZhanSan)iocContainer.getBean("zhangsan");
        zhanSan.goHome();
    }
}
