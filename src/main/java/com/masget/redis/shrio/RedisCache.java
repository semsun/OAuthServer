package com.masget.redis.shrio;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisCache<K, V> implements Cache<K, V> {
	
	public static long DEFAULT_EXPIRE_TIME = 120; // 缓存的超时时间，单位为s
	
	private long expireTime = DEFAULT_EXPIRE_TIME;
	
	private RedisTemplate<String, V> redisTemplate = null;
	
	private String cacheName = "default";
	
	public RedisCache(String cacheName, long expireTime, RedisTemplate<String, V> redisTemplate) {
		super();
		this.expireTime = expireTime;
		this.redisTemplate = redisTemplate;
		
		if( null != cacheName && !cacheName.isEmpty() ) {
			this.cacheName = cacheName;
		}
	}

	/**
	 * 通过key来获取对应的缓存对象
	 * 通过源码我们可以发现，shiro需要的key的类型为Object，V的类型为AuthorizationInfo对象
	 */
	@Override
	public V get(K key) throws CacheException {
		// TODO Auto-generated method stub
		String mKey = String.format( "%s_%s", cacheName, String.valueOf(key) );
		return redisTemplate.opsForValue().get(mKey);
	}

	/**
	 * 将权限信息加入缓存中
	 */
	@Override
	public V put(K key, V value) throws CacheException {
		// TODO Auto-generated method stub
		String mKey = String.format( "%s_%s", cacheName, String.valueOf(key) );
		
		if( this.expireTime == 0 ) {
			redisTemplate.opsForValue().set(mKey, value);
		} else {
			redisTemplate.opsForValue().set(mKey, value, this.expireTime, TimeUnit.SECONDS);
		}
		return value;
	}

	/**
	 * 将权限信息从缓存中删除
	 */
	@Override
	public V remove(K key) throws CacheException {
		// TODO Auto-generated method stub
		String mKey = String.format( "%s_%s", cacheName, String.valueOf(key) );
		
		V v = redisTemplate.opsForValue().get(mKey);
		redisTemplate.opsForValue().getOperations().delete(mKey);
		return v;
	}

	@Override
	public void clear() throws CacheException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<K> keys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

}
