package com.masget.redis.shrio;

import java.io.Serializable;

import org.apache.shiro.cache.Cache;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.masget.test.TestResource;

class TestClass implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2939290968971399122L;
	private long id;
	private String name;
	private int age;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}

public class CacheManagerTest {
	
	RedisCacheManager manager = null;
	
	@Before
	public void setUp() {
		ClassPathXmlApplicationContext applicationContext = TestResource.getApplicationContext();
		
		manager = applicationContext.getBean(RedisCacheManager.class);
	}
	
	@Test
	public void save() {
		Cache<String, String> cache = manager.getCache("test");
		cache.put("CacheTest", "CacheManager");
		
		String value = cache.get("CacheTest");
		
		Assert.assertNotNull(value);
		Assert.assertEquals("CacheManager", value);
	}
	
	@Test
	public void saveObj() {
		Cache<Long, TestClass> cache = manager.getCache("testObj");
		
		TestClass t = new TestClass();
		t.setAge(10);
		t.setName("test");
		t.setId(1);
		
		cache.put(t.getId(), t);
		TestClass v = cache.get(1l);
			
		Assert.assertNotNull(v);
		Assert.assertEquals(10, v.getAge());
		Assert.assertEquals("test", v.getName());
	}

}
