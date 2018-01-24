package com.masget.oauth.profit.masget.config;

import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import redis.clients.jedis.JedisPoolConfig;

//@Configuration
public class RedisCacheConfig {
	/**
	 * 读取Redis配置
	 * @param propertieName	Redis配置文件名，Redis配置文件需要放在CLASS_PATH下
	 * @return
	 */
	private Properties getRedisProperties(String propertieName) {
        
        Properties properties = new Properties();
        try{
        	
	        InputStream in = this.getClass().getClassLoader().getResourceAsStream(propertieName);
	        properties.load(in);
	        in.close();
        } catch (Exception e) {
        	e.printStackTrace();
        }
		
        return properties;
	}
	
	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		Properties properties = this.getRedisProperties("redis.properties");
		
		int maxActive = Integer.parseInt( String.valueOf(properties.get("redis.pool.maxActive")) );
        int maxIdle = Integer.parseInt( String.valueOf(properties.get("redis.pool.maxIdle")) );
        int maxWait = Integer.parseInt( String.valueOf(properties.get("redis.pool.maxWait")) );
        boolean testOnBorrow = Boolean.parseBoolean( String.valueOf(properties.get("redis.pool.testOnBorrow")) );
        boolean testOnReturn = Boolean.parseBoolean( String.valueOf(properties.get("redis.pool.testOnReturn")) );
        
        String host = String.valueOf(properties.get("redis.ip"));
        int port = Integer.parseInt( String.valueOf(properties.get("redis.port")) );
        int database = Integer.parseInt( String.valueOf(properties.get("redis.database")) );
        
//        String msg = String.format("maxActive:%d\nmaxIdle:%d\nmaxWait:%d\ntestOnBorrow:%b\ntestOnReturn:%b\nhost:%s\nport:%d\ndatabase:%d"
//        		, maxActive, maxIdle, maxWait, testOnBorrow, testOnReturn, host, port, database);
//        System.out.println( msg );
        JedisPoolConfig redisPoolConf = new JedisPoolConfig();
        redisPoolConf.setMaxTotal(maxActive);
        redisPoolConf.setMaxIdle(maxIdle);
        redisPoolConf.setMaxWaitMillis(maxWait);
        redisPoolConf.setTestOnReturn(testOnReturn);
        redisPoolConf.setTestOnBorrow(testOnBorrow);
        
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(host);
        jedisConnectionFactory.setPort(port);
        jedisConnectionFactory.setDatabase(database);
        jedisConnectionFactory.setPoolConfig(redisPoolConf);
        
        return jedisConnectionFactory;
	}

	@Bean
	public RedisTemplate redisTemplate(@Autowired JedisConnectionFactory jedisConnectionFactory) {
		RedisTemplate redisTemplate = new RedisTemplate();
		redisTemplate.setConnectionFactory(jedisConnectionFactory);
		
		return redisTemplate;
	}
}
