package com.chan.self.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chan.self.dao.UserDAO;
import com.chan.self.dao.UserDAOImpl;
import com.chan.self.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/setcontext.xml"})

public class UserDAOTest {
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	UserDAO dao;
	
	@Test
	public void contextTest() {
		System.out.println("context"+context);
	}
	@Test
	public void daoTest() {
		System.out.println("dao"+dao);
	}

	UserVO td1=null,td2=null,td3=null;
	
	@Before
	public void setData() {
		dao.delAlluser();
		UserVO td1=new UserVO("aa", "aaa", "a134");
		UserVO td2=new UserVO("aab", "aaab", "ab134");
		UserVO td3=new UserVO("aac", "aaac", "ac134");
	}
	
	
	
	@Test
	public void addUserTest() {
		dao.addUser(td1);
		dao.delAlluser();
		
	}
	
}
