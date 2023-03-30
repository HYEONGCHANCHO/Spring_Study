package com.chan.mbex01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chan.mbex01.dao.UserDAO;
import com.chan.mbex01.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MbUserTest {
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	UserDAO dao;
	
	@Test
	@Ignore
	public void contexttest() {
		assertNotNull(dao);
	}

	@Test
	public void insertTest() {
		UserVO user =new UserVO("cccc","강감찬","강123");
		dao.insert(user);
		UserVO rtnUser = dao.selectOne(user.getId());
		assertEquals(user.getName(), rtnUser.getName());
		assertEquals(user.getPassword(), rtnUser.getPassword());
		
		int delCount = dao.delUser(user.getId());
		assertEquals(delCount, 1);
	}
	
	@Test
	public void getAllTest() {
		List<UserVO> list = dao.getAll();
		assertEquals(list.size(),0);
		for(UserVO vo : list) {
			System.out.println(vo);
		}
	}
	
}
