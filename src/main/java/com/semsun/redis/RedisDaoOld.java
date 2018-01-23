package com.semsun.redis;

import java.util.List;
import java.util.Set;

public interface RedisDaoOld {
	
	<T> boolean add(final String key, final T obj);

	/**
	 * 添加字符串记录
	 * @param key
	 * @param value
	 * @return
	 */
	boolean add(final String key, final String value);

	/**
	 * 添加列表
	 * @param key
	 * @param list
	 * @return
	 */
	<T> boolean add(final String key, final List<T> list);

	/**
	 * 添加时效性对象
	 * @param key
	 * @param timeout
	 * @param obj
	 */
	<T> void add(final String key, final long timeout, final T obj);

	/**
	 * 添加时效性二进制对象
	 * @param key
	 * @param timeout
	 * @param object
	 */
	void add(final String key, final long timeout, final byte[] object);

	/**
	 * 设置二进件
	 * @param key
	 * @param value
	 * @return
	 */
	boolean set(final String key, final byte[] value);

	/**
	 * 保存 不存在则新建，存在则更新
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	boolean save(final String key, final String value);

	/**
	 * 保存对象
	 * @param key
	 * @param obj
	 * @return
	 */
	<T> boolean save(final String key, final T obj);

	/**
	 * 删除记录
	 * @param key
	 */
	void delete(final String key);

	/**
	 * 批量删除记录
	 * @param keys
	 */
	void delete(final List<String> keys);

	/**
	 * 更新对象记录
	 * @param key
	 * @param obj
	 * @return
	 */
	<T> boolean update(final String key, final T obj);

	/**
	 * 更新字符串记录
	 * @param key
	 * @param value
	 * @return
	 */
	boolean update(final String key, final String value);

	/**
	 * 获取对象
	 * @param key
	 * @param clazz
	 * @return
	 */
	<T> T get(final String key, final Class clazz);

	/**
	 * 获取列表
	 * @param key
	 * @param clazz
	 * @return
	 */
	<T> List<T> getList(final String key, final Class<T> clazz);

	/**
	 * 获取字节
	 * @param key
	 * @return
	 */
	byte[] getByte(final String key);

	/**
	 * 获取字符串
	 * @param key
	 * @return
	 */
	String get(final String key);

	/**
	 * 匹配获取Key列表
	 * @param pattern
	 * @return
	 */
	Set<String> keys(String pattern);

	/**
	 * 是否存Key在判断
	 * @param key
	 * @return
	 */
	boolean exist(final String key);

	/**
	 * 更新数据
	 * @return
	 */
	boolean flushDB();

	/**
	 * 数据库大小
	 * @return
	 */
	long dbSize();
}
