package com.masget.redis.shrio;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

public class RedisCacheManager implements CacheManager {
	
	private RedisTemplate redisTemplate;

	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		// TODO Auto-generated method stub
		return new RedisCache<K, V>(name, RedisCache.DEFAULT_EXPIRE_TIME, redisTemplate);
	}

	public RedisTemplate getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

}
