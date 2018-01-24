package com.semsun.redis;

import java.util.List;

public interface RedisDao {
	
	/**
	 * 保存kev value
	 * @param key
	 * @param value
	 */
	public void set(String key, Object value);
	
	/**
	 * 获取key的String数据
	 * @param key
	 * @return
	 */
	public Object get(String key);
	
	/**
	 * 删除key
	 * @param key
	 * @return
	 */
	public boolean del(String key);
	
	/**
	 * 保存列表
	 * @param key
	 * @param list
	 */
	public void setList(String key, List<String> list);
	
	/**
	 * 获取列表
	 * @param key
	 * @param pageSize
	 * @param pageNum
	 * @return
	 */
	public List<String> getList(String key, int pageSize, int pageNum);
	
	/**
	 * 修改列表指定项
	 * @param key		列表key
	 * @param index		列表项序号
	 * @param value		修改值
	 */
	public void setListItem(String key, int index, String value);
	
	/**
	 * 获取列表项
	 * @param key		列表key
	 * @param index		列表项序号
	 * @return
	 */
	public String getListItem(String key, int index);
	
	/**
	 * 判断key是否存在
	 * @param key
	 * @return
	 */
	public boolean exists(String key);

}
