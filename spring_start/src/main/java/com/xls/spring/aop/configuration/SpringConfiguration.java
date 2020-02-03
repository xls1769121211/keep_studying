package com.xls.spring.aop.configuration;

import com.xls.spring.aop.service.MathCalculator;
import com.xls.spring.aop.service.MathAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * spring aop 学习
 * 使用spring步骤
 * 1 创建业务类 MathCalculator， 其中有一个计算方法 Divide，现在要在方法调用之前添加日志记录
 * 2 创建切面类 MathAspect ，其中有各个通知方法
 * 3 为每个方法标注执行时机
 *    @Beafore 在方法执行之前执行
 *    @After   在方法执行完成之后执行
 *    @AfterReturning 在方法执行之后执行，并且可以接收返回值
 *    @AfterThrowing 在方法执行之后执行，接收异常信息
 *    @Around 在方法执行之前和之后都执行，动态代理，手动推进目标方法执行 joinPoint.proceed()
 *
 *    获取方法参数 在advice方法上加入参数 JoinPoint joinPoint
 *           //方法名
 *         String methodName = joinPoint.getSignature().getName();
 *         //方法参数列表
 *         Object[] args = joinPoint.getArgs();
 *    获取方法返回值 在advice方法上加入参数 JoinPoint joinPoint ,Object result ,
 *          注解样式 @AfterReturning(value = "pointCut()",returning = "result")
 *          其中 returning 的值和Object变量名要一致，并且 如果advice方法有多个参数，joinPoint这个变量必须在首位
 *    获取方法的异常返回值  在advice方法上加入参数 JoinPoint joinPoint ,Exception exception ,
 *
 * 4 编写PointCut
 *    （1）直接在advice注解里面写 execution 表达式的值 例如 @Beafore("public int MathCalculator.*(..)")
 *    （2）也可以单独写在 方法上 ，@Pointcut(value = "execution(public int MathCalculator.*(..))")
 *         然后advice的值直接调用该方法  @Before("pointCut()")
 * 5 将业务类和切面类全部加入 Spring容器中
 * 6 标注哪个类是切面类，在类上加入@Aspect 标注
 * 7 重要的一步，注明 配置类启动了面向切面的自动代理
 *
 *
 *
 * spring aop 原理（基于注解@EnableAspectJAutoProxy）
 *
 * 1 @EnableAspectJAutoProxy 导入  @Import(AspectJAutoProxyRegistrar.class)
 *   AspectJAutoProxyRegistrar实现了ImportBeanDefinitionRegistrar ，在ioc容器创建的时候会去执行AspectJAutoProxyRegistrar的重载方法 registerBeanDefinitions
 *   registerBeanDefinitions 方法会注册一个AnnotationAwareAspectJAutoProxyCreator类，这个类是基于注解实现aop的核心类
 *   AnnotationAwareAspectJAutoProxyCreator 最终实现了 BeanPostProcessor,
 *
 *2 AnnotationAwareAspectJAutoProxyCreator 注册时机
 *  容器创建时：refresh()
 *                --> invokeBeanFactoryPostProcessors(beanFactory)  // Invoke factory processors registered as beans in the context.
 *                  --> PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(beanFactory, getBeanFactoryPostProcessors());
 *                    --> invokeBeanDefinitionRegistryPostProcessors(currentRegistryProcessors, registry);
 *                      --> postProcessor.postProcessBeanDefinitionRegistry(registry);
 *                        --> processConfigBeanDefinitions(registry);
 *                          --> this.reader.loadBeanDefinitions(configClasses);
 *                            --> loadBeanDefinitionsForConfigurationClass(configClass, trackedConditionEvaluator);
 *                              --> loadBeanDefinitionsFromRegistrars(configClass.getImportBeanDefinitionRegistrars());//加载所有@import导入的类
 *                                --> registrar.registerBeanDefinitions(metadata, this.registry, this.importBeanNameGenerator)) // aop中的AspectJAutoProxyRegistrar
 *                                  --> AspectJAutoProxyRegistrar.registerBeanDefinitions()
 *                                    --> AopConfigUtils.registerAspectJAnnotationAutoProxyCreatorIfNecessary(registry);//注册AnnotationAwareAspectJAutoProxyCreator
 *                                      --> registerOrEscalateApcAsRequired(AnnotationAwareAspectJAutoProxyCreator.class, registry, source);
 *                                        --> registry.registerBeanDefinition(AUTO_PROXY_CREATOR_BEAN_NAME, beanDefinition);//AUTO_PROXY_CREATOR_BEAN_NAME = "org.springframework.aop.config.internalAutoProxyCreator";
 * 3 AnnotationAwareAspectJAutoProxyCreator 执行时机包装目标bean
 *   容器创建时：refresh()
 *                  --> finishBeanFactoryInitialization(beanFactory); // Instantiate all remaining (non-lazy-init) singletons. 实例化所有不是懒加载的单例bean
 *                      --> getBean(beanName);
 *                        --> doGetBean(beanName)
 *                          --> getSingleton(beanName, () -> {} --> createBean(beanName, mbd, args);
 *                            --> 	 1. Object bean = resolveBeforeInstantiation(beanName, mbdToUse);//  Give BeanPostProcessors a chance to return a proxy instead of the target bean instance.
 *                                  2. Object beanInstance = doCreateBean(beanName, mbdToUse, args);//正常创建bean
 *                              --> doCreateBean(beanName, mbdToUse);
 *                                --> createBeanInstance(beanName, mbd, args);
 *                                 --> instantiateUsingFactoryMethod(beanName, mbd, args);
 *                                  --> bw.setBeanInstance(instantiate(beanName, mbd, factoryBean, uniqueCandidate, EMPTY_ARGS));
 *                                   --> this.beanFactory.getInstantiationStrategy().instantiate(mbd, beanName, this.beanFactory, factoryBean, factoryMethod, args);
 *                                     --> factoryMethod.invoke(factoryBean, args);
 *                              --> exposedObject = initializeBean(beanName, exposedObject, mbd);
 *                                --> wrappedBean = applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
 *                                --> invokeInitMethods(beanName, wrappedBean, mbd);
 *                                --> wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 *                                  --> (AnnotationAwareAspectJAutoProxyCreator)processor.postProcessAfterInitialization(result, beanName);
 *                                    --> wrapIfNecessary(bean, beanName, cacheKey);
 *                                      --> getAdvicesAndAdvisorsForBean(bean.getClass(), beanName, null);//得到所有的advice
 *                                        --> findEligibleAdvisors(beanClass, beanName);
 *                                          --> List<Advisor> candidateAdvisors = findCandidateAdvisors();
 * 		                                    --> findAdvisorsThatCanApply(candidateAdvisors, beanClass, beanName);
 * 		                                      --> AopUtils.findAdvisorsThatCanApply(candidateAdvisors, beanClass);
 * 		                                --> createProxy(bean.getClass(), beanName, specificInterceptors, new SingletonTargetSource(bean));//如果有advice创建 代理对象
 *                                        --> Advisor[] advisors = buildAdvisors(beanName, specificInterceptors);
 * 		                                  --> proxyFactory.addAdvisors(advisors);
 * 		                                  --> proxyFactory.getProxy(getProxyClassLoader());
 * 		                                    -->createAopProxy().getProxy(classLoader);
 *4 代理方法执行流程
 *      divide(1,0)
 *        --> CglibAopProxy.intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy)//走代理方法
 *          --> this.advised.getInterceptorsAndDynamicInterceptionAdvice(method, targetClass);//获取执行链
 *            --> this.advisorChainFactory.getInterceptorsAndDynamicInterceptionAdvice(this, method, targetClass);
 *              --> registry.getInterceptors(advisor);
 *          --> new CglibMethodInvocation(proxy, target, method, args, targetClass, chain, methodProxy).proceed();//执行代理方法
 *            -->((MethodInterceptor) interceptorOrInterceptionAdvice).invoke(this);//先执行这个
 *              --> return mi.proceed();//递归执行
 *                -->((MethodInterceptor) interceptorOrInterceptionAdvice).invoke(this);//先执行这个
 *                  --> return mi.proceed();//递归执行
 *                   -->((MethodInterceptor) interceptorOrInterceptionAdvice).invoke(this);//先执行这个
 *                     --> return mi.proceed();//递归执行
 *                     ...
 *                     --> return invokeJoinpoint();
 *                       -->this.methodProxy.invoke(this.target, this.arguments); //执行方法
 *                     ...
 *            --> return invokeJoinpoint();
 */
@EnableAspectJAutoProxy
@Configuration
public class SpringConfiguration{
    @Bean
    public MathCalculator mathCalculator(){
        return new MathCalculator();
    }
    @Bean
    public MathAspect mathAspect(){
        return new MathAspect();
    }
}
