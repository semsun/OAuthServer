package com.semsun.redis;

import java.io.InputStream;
import java.util.Properties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

public class RedisUtils {

	private JedisPool mPool = null;
	
	private static volatile RedisUtils instance = null;
	
	private RedisUtils() {
		initRedis("redis.properties");
	}
	
	private RedisUtils( String propertieName ) {
		initRedis(propertieName);
	}
	
	/**
	 * 获取Redis工具类实例，需要指定配置文件初始化时，不要使用该方法
	 * @return
	 */
	public static RedisUtils getInstance() {
		if( null == instance ) {
			instance = new RedisUtils();
		}
		
		return instance;
	}
	
	/**
	 * 根据指定配置文件初始化，并返回实例
	 * @param propertieName
	 * @return
	 */
	public static RedisUtils init( String propertieName ) {
		if( null == instance ) {
			instance = new RedisUtils(propertieName);
		}
		
		return instance;
	}
	
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
	
	/**
	 * 初始化Redis
	 * @param propertieName
	 */
	private void initRedis(String propertieName) {
		Properties properties = this.getRedisProperties(propertieName);
		
        int maxActive = Integer.parseInt( String.valueOf(properties.get("redis.pool.maxActive")) );
        int maxIdle = Integer.parseInt( String.valueOf(properties.get("redis.pool.maxIdle")) );
        int maxWait = Integer.parseInt( String.valueOf(properties.get("redis.pool.maxWait")) );
        boolean testOnBorrow = Boolean.parseBoolean( String.valueOf(properties.get("redis.pool.testOnBorrow")) );
        boolean testOnReturn = Boolean.parseBoolean( String.valueOf(properties.get("redis.pool.testOnReturn")) );
        
        String host = String.valueOf(properties.get("redis1.ip"));
        int port = Integer.parseInt( String.valueOf(properties.get("redis1.port")) );
        int database = Integer.parseInt( String.valueOf(properties.get("redis1.database")) );
        
        String msg = String.format("maxActive:%d\nmaxIdle:%d\nmaxWait:%d\ntestOnBorrow:%b\ntestOnReturn:%b\nhost:%s\nport:%d\ndatabase:%d"
        		, maxActive, maxIdle, maxWait, testOnBorrow, testOnReturn, host, port, database);
        System.out.println( msg );
        JedisPoolConfig redisPoolConf = new JedisPoolConfig();
        redisPoolConf.setMaxTotal(maxActive);
        redisPoolConf.setMaxIdle(maxIdle);
        redisPoolConf.setMaxWaitMillis(maxWait);
        redisPoolConf.setTestOnReturn(testOnReturn);
        redisPoolConf.setTestOnBorrow(testOnBorrow);
        
        mPool = new JedisPool(redisPoolConf, host, port, Protocol.DEFAULT_TIMEOUT, null, database);
//      JedisPool pool = new JedisPool(redisPoolConf, host, port);
	}
	
	/**
	 * 通过连接池，获取Redis实例
	 * @return
	 */
	public Jedis getRedisResource() {
		if( null == mPool ) return null;
		
		return mPool.getResource();
	}
	
	/**
	 * 关闭Redis连接池
	 */
	public void closeRedisPool() {
		if( null == mPool ) return;
		
		mPool.close();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		/* 对象销毁时，关闭Redis连接池，并清空实例化对象 */
		this.closeRedisPool();
		instance = null;
		
		super.finalize();
	}

}
