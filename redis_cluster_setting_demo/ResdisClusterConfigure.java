package com.hhwy.dhvirins.redisTest.redisConfigure;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 通过java配置的方式实现简单redis集群的配置
 * @author xls
 *对应的xml配置
 *<!-- redis 配置 -->
  	<bean id="jedisPoolConfig" class="redis.clients.jedis.JedisPoolConfig">
		<property name="maxTotal" value="100"></property>
		<property name="maxIdle" value="20"></property>
		<property name="blockWhenExhausted" value="true"></property>
		<property name="maxWaitMillis" value="3000"></property>
		<property name="testOnBorrow" value="false"></property>
		<property name="testWhileIdle" value="true"></property>
		<property name="testOnReturn" value="false"></property>
		<property name="minEvictableIdleTimeMillis" value="60000"></property>
		<property name="timeBetweenEvictionRunsMillis" value="30000"></property>
		<property name="numTestsPerEvictionRun" value="-1"></property>
	</bean>  
	<bean id="redisCluster" class="redis.clients.jedis.JedisCluster">
		<constructor-arg index="0">
			<set>
				<bean class="redis.clients.jedis.HostAndPort">
					<constructor-arg index="0" value="192.168.188.129"/>
					<constructor-arg index="1" value="7001" type="int"/>
				</bean>
				<bean class="redis.clients.jedis.HostAndPort">
					<constructor-arg index="0" value="192.168.188.129"/>
					<constructor-arg index="1" value="7002" type="int"/>
				</bean>
				<bean class="redis.clients.jedis.HostAndPort">
					<constructor-arg index="0" value="192.168.188.129"/>
					<constructor-arg index="1" value="7003" type="int"/>
				</bean>
				<bean class="redis.clients.jedis.HostAndPort">
					<constructor-arg index="0" value="192.168.188.129"/>
					<constructor-arg index="1" value="7004" type="int"/>
				</bean>
				<bean class="redis.clients.jedis.HostAndPort">
					<constructor-arg index="0" value="192.168.188.129"/>
					<constructor-arg index="1" value="7005" type="int"/>
				</bean>
				<bean class="redis.clients.jedis.HostAndPort">
					<constructor-arg index="0" value="192.168.188.129"/>
					<constructor-arg index="1" value="7006" type="int"/>
				</bean>
			</set>
		</constructor-arg>
		<constructor-arg index="1" value="20000" type="int"/>
		<constructor-arg index="2" value="100" type="int"/>
		<constructor-arg index="3" ref="jedisPoolConfig"/>
	</bean>
 */
@Configuration
public class ResdisClusterConfigure {
	private static Integer REDIS_TIME_OUT  = 20000;
	
	
	@Bean
	public JedisCluster getJedisCluster() {
		Set<HostAndPort> nodes = getHostAndPortNodes();
		/**
		 * 简单实现，不使用redis连接池
		 */
		JedisCluster a = new JedisCluster(nodes, REDIS_TIME_OUT);
		/**
		 * 使用 redis 连接池
		 */
		JedisCluster bCluster = new JedisCluster(nodes, REDIS_TIME_OUT, getJedisPoolConfig());
		return a;
	}

	//获取
	private GenericObjectPoolConfig getJedisPoolConfig() {
		// TODO Ato-generated method stub
		
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxTotal(200); //redis最大连接数, 默认是8个
		jedisPoolConfig.setMaxIdle(20);//最大空闲连接数, 默认8个
		jedisPoolConfig.setBlockWhenExhausted(true);//连接资源耗尽是否阻塞，false报异常,ture阻塞直到超时
		jedisPoolConfig.setMaxWaitMillis(3000L);//获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
		jedisPoolConfig.setTestOnBorrow(false);//在获取连接的时候检查有效性, 默认false
		jedisPoolConfig.setTestWhileIdle(true);//在空闲时检查有效性, 默认false
		jedisPoolConfig.setTestOnReturn(false);//在return给pool时，是否提前进行validate操作；
		jedisPoolConfig.setMinEvictableIdleTimeMillis(60000L);//逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
		jedisPoolConfig.setTimeBetweenEvictionRunsMillis(30000L);//逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
		jedisPoolConfig.setNumTestsPerEvictionRun(-1);//每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3
		return jedisPoolConfig;
	}

	//获取redis地址和端口号
	private Set<HostAndPort> getHostAndPortNodes() {
		Set<HostAndPort> hostAndPorts = new HashSet<HostAndPort>();
		String propertiesName = "redisHostAndPort.properties";
	    String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	    rootPath = rootPath.replace("/webapp/WEB-INF/classes", "/resources");
	    File file = new File(rootPath+propertiesName);
	    InputStream in = null;
	    
	    try {
	    	in = new FileInputStream(file);
	   	    Properties properties = new Properties();
	   	    properties.load(in);
	   	    if (properties != null) {
				String hostAndPortsString = (String)properties.get("hostAndPorts");
				String[] ips = hostAndPortsString.split(",");
				for (String ip : ips) {
				    String host = ip.split(":")[0];
				    String port = ip.split(":")[1];
				    HostAndPort hostAndPort = new HostAndPort(host, Integer.parseInt(port));
				    hostAndPorts.add(hostAndPort);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if (null != in) {
				try {
					in.close();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
		}
		return hostAndPorts;
	}
	
	public static void main(String[] args) {
		ResdisClusterConfigure resdisClusterConfigure = new ResdisClusterConfigure();
		resdisClusterConfigure.getHostAndPortNodes();
		JedisCluster jedisCluster = resdisClusterConfigure.getJedisCluster();
		System.out.println(jedisCluster);
	}
}
