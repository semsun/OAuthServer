package com.semsun.redis;

import java.util.List;
import java.util.Set;

public interface RedisDao {
	
	public void set(String key, Object value);
	
	public Object get(String key);
	
	public boolean del(String key);
	
	public void setList(String key, List<String> list);
	
	public List<String> getList(String key, int pageSize, int pageNum);
	
	public void setListItem(String key, int index, String value);
	
	public String getListItem(String key, int index);
	
	public boolean exists(String key);

}
