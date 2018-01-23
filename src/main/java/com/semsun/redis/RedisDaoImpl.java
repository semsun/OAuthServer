package com.semsun.redis;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

/**
 * Redis缓存访问类，注：未处理并发操作问题。
 * @author semsun sunyongqian@masget.com
 *
 */
public class RedisDaoImpl implements RedisDao {

	@Override
	public void set(String key, Object value) {
		// TODO Auto-generated method stub
		Jedis redis = RedisUtils.getInstance().getRedisResource();
		
		redis.set( key, String.valueOf(value) );
	}

	@Override
	public Object get(String key) {
		// TODO Auto-generated method stub
		Jedis redis = RedisUtils.getInstance().getRedisResource();
		return redis.get(key);
	}

	@Override
	public boolean del(String key) {
		// TODO Auto-generated method stub
		Jedis redis = RedisUtils.getInstance().getRedisResource();
		
		redis.del(key);
		return true;
	}

	@Override
	public void setList(String key, List<String> list) {
		// TODO Auto-generated method stub
		if( null == list || list.size() <= 0 ) return;
		long listLen = list.size();
		long saveLen = 0;
		
		Jedis redis = RedisUtils.getInstance().getRedisResource();
		Pipeline pipe = redis.pipelined();
		
		if( redis.exists(key) ) {
			saveLen = redis.llen(key);
		}
		
		/* 替换Redis已存储部分 */
		int tailIndex = 0;
		for( tailIndex = 0; tailIndex < saveLen; tailIndex++ ) {
			if( tailIndex >= listLen ) break;
			pipe.lset(key, tailIndex, list.get(tailIndex) );
		}

		/* 增加Redis未存储部分 */
		List<String> subList = list.subList(tailIndex, list.size());
		if( null != subList ) {
			for( int j = 0; j < subList.size(); j++ ) {
				tailIndex++;
				pipe.rpush( key, subList.get(j) );
			}
		}

		/* 去掉删除部分 */
		pipe.ltrim(key, 0, tailIndex - 1);
		pipe.sync();
		
	}

	@Override
	public List<String> getList(String key, int pageSize, int pageNum) {
		// TODO Auto-generated method stub
		Jedis redis = RedisUtils.getInstance().getRedisResource();
		
		long llen = 0;
		
		if( redis.exists(key) ) {
			llen = redis.llen(key);
		} else {
			return null;
		}
		
		if( pageSize == 0 ) {
			return redis.lrange(key, 0, llen);
		}
		
		long begin = (pageNum - 1) * pageSize;
		long end = begin + pageSize;
		return redis.lrange(key, begin, end);
	}

	@Override
	public void setListItem(String key, int index, String value) {
		// TODO Auto-generated method stub
		Jedis redis = RedisUtils.getInstance().getRedisResource();
		
		redis.lset(key, index, value);
	}

	@Override
	public String getListItem(String key, int index) {
		// TODO Auto-generated method stub
		Jedis redis = RedisUtils.getInstance().getRedisResource();
		return redis.lindex(key, index);
	}

	@Override
	public boolean exists(String key) {
		// TODO Auto-generated method stub
		Jedis redis = RedisUtils.getInstance().getRedisResource();
		return redis.exists(key);
	}

}
