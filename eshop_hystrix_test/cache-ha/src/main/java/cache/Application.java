package cache;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
@MapperScan("cache.mapper")
public class Application {
 
    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource() {
        return new org.apache.tomcat.jdbc.pool.DataSource();
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
 
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /*
    *   //springboot默认的配置文件路径
        // String addClassPath = "spring.config.location:classpath:/";
         //自定义的配置文件路径
        String addClassPath = "spring.config.additional-location:classpath:/";
        addClassPath += ",classpath:/config/";
        addClassPath += ",classpath:/config/dev1/";
        addClassPath += ",classpath:/config/dev2/";
        addClassPath += ",classpath:/config/stg1/";
        addClassPath += ",classpath:/config/stg2/";
        addClassPath += ",classpath:/config/prd/";
        new SpringApplicationBuilder(DemoApplication.class).properties("spring.config.name:application", addClassPath).build().run(args);
————————————————
版权声明：本文为CSDN博主「『梧桐雨』」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/m0_37735176/article/details/89085843
    * */
    
}
