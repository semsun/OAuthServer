package com.semsun.redis;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class RedisDaoTest {
	
	private RedisDao dao = new RedisDaoImpl();

	@Ignore
	@Test
	public void testGetSet() {
		String key = "junitTest";
		dao.del(key);
		dao.set(key, 1);
		String res = (String) dao.get(key);
		
		Assert.assertEquals("1", res);
	}

	@Ignore
	@Test
	public void testList() {
		String key = "junitTest";
		dao.del(key);
		
		/* 新建测试 */
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		
		dao.setList(key, list);
		
		List<String> resList = dao.getList(key, 0, 0);
		Assert.assertEquals(String.format("Len:%s", resList.size()), 2, resList.size());
		Assert.assertEquals(String.format("1:%s", resList.get(0)), "1", resList.get(0) );
		Assert.assertEquals(String.format("2:%s", resList.get(1)), "2", resList.get(1) );

		/* 增加性修改测试 */
		list.clear();
		list.add("3");
		list.add("4");
		list.add("5");
		
		dao.setList(key, list);
		
		resList = null;
		resList = dao.getList(key, 0, 0);
		Assert.assertEquals(String.format("Len:%s", resList.size()), 3, resList.size());
		Assert.assertEquals(String.format("1:%s", resList.get(0)), "3", resList.get(0) );
		Assert.assertEquals(String.format("2:%s", resList.get(1)), "4", resList.get(1) );
		Assert.assertEquals(String.format("3:%s", resList.get(2)), "5", resList.get(2) );

		/* 减少性修改测试 */
		list.clear();
		list.add("6");
		list.add("7");
		
		dao.setList(key, list);
		
		resList = null;
		resList = dao.getList(key, 0, 0);
		Assert.assertEquals(String.format("Len:%s", resList.size()), 2, resList.size());
		Assert.assertEquals(String.format("1:%s", resList.get(0)), "6", resList.get(0) );
		Assert.assertEquals(String.format("2:%s", resList.get(1)), "7", resList.get(1) );

		/* 多个增加性修改测试 */
		list.clear();
		list.add("8");
		list.add("9");
		list.add("10");
		list.add("11");
		list.add("12");
		list.add("13");
		
		dao.setList(key, list);
		
		resList = null;
		resList = dao.getList(key, 0, 0);
		Assert.assertEquals(String.format("Len:%s", resList.size()), 6, resList.size());
		Assert.assertEquals(String.format("1:%s", resList.get(0)), "8", resList.get(0) );
		Assert.assertEquals(String.format("2:%s", resList.get(1)), "9", resList.get(1) );
		Assert.assertEquals(String.format("3:%s", resList.get(2)), "10", resList.get(2) );
		Assert.assertEquals(String.format("4:%s", resList.get(3)), "11", resList.get(3) );
		Assert.assertEquals(String.format("5:%s", resList.get(4)), "12", resList.get(4) );
		Assert.assertEquals(String.format("6:%s", resList.get(5)), "13", resList.get(5) );

		/* 多个减少修改测试 */
		list.clear();
		list.add("14");
		
		dao.setList(key, list);
		
		resList = null;
		resList = dao.getList(key, 0, 0);
		Assert.assertEquals(String.format("Len:%s", resList.size()), 1, resList.size());
		Assert.assertEquals(String.format("1:%s", resList.get(0)), "14", resList.get(0) );

		/* 空列表测试 */
		list.clear();
		
		dao.setList(key, list);
		
		resList = null;
		resList = dao.getList(key, 0, 0);
		Assert.assertEquals(String.format("Len:%s", resList.size()), 1, resList.size());
		Assert.assertEquals(String.format("1:%s", resList.get(0)), "14", resList.get(0) );
		
		dao.setList(key, null);
		
		resList = null;
		resList = dao.getList(key, 0, 0);
		Assert.assertEquals(String.format("Len:%s", resList.size()), 1, resList.size());
		Assert.assertEquals(String.format("1:%s", resList.get(0)), "14", resList.get(0) );
		
		/* 单个修改测试 */
		dao.setListItem(key, 0, "15");
		Assert.assertEquals(String.format("1:%s", resList.get(0)), "15", dao.getListItem(key, 0) );
	}
}
