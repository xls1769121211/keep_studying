package com.xls;

import com.xls.user.UserInterface;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;


/**
 * 自定义ServletContainerInitializer 在容器初始化的时候回执行这个类，配置全类名在 META-INF/services/javax.servlet.ServletContainerInitializer
 *
 *@HandlesTypes 添加类型，会把当前类及子类和实现类带过来放到 set集合中
 *
 *
 * 利用ServletContext 注册web三大组件 Filter，Listener，Servlet
 */
@HandlesTypes({UserInterface.class})
public class MyServletContainerInitializer implements ServletContainerInitializer{

    /**
     *
     * @param set 自己感兴趣的类的集合，结合注解@HandlesTypes
     * @param servletContext Servlet容器
     * @throws ServletException
     */
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("感兴趣的类。。");
        set.forEach((claz)->{
            System.out.println(claz.getName());
        });
        //添加过滤器
        FilterRegistration.Dynamic dynamic = servletContext.addFilter("filter1",new FilterTest());
        dynamic.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true,"/hello");

        //添加监听器
        servletContext.addListener(ListenerTest.class);

        //添加Servlet
        ServletRegistration.Dynamic dynamic1 = servletContext.addServlet("servlet1","com.xls.ServletTest");

        dynamic1.addMapping("/hello","/aaaa");

    }
}
