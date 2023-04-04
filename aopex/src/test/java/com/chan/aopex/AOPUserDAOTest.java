package com.chan.aopex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chan.aopex.dao.UserDAO;
import com.chan.aopex.vo.UserVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class AOPUserDAOTest {
	
	
	@Autowired
	UserDAO dao;	
	
	UserVO user1,user2,user3;
		
	@Before
	public void dataSetup() {
		assertEquals(0, dao.readUserCount());
		user1 = new UserVO("aaa","aaapasword","aaaname","aaadress");
		user2 = new UserVO("bbb","bbbpasword","bbbname","bbbdress");
		user3 = new UserVO("ccc","cccpasword","cccname","cccdress");
		
	}
	
	@Test
	public void createAndDeleteAndReadUserTest() {
	dao.create(user1);
	System.out.println("=======입력 작업 완료");
	UserVO rtnVO = dao.readUser(user1.getUserId());
	System.out.println(rtnVO);
	
	dao.deleteUser(user1.getUserId());
	System.out.println("=======삭제 작업 완료");
	}
	
	private void dataCompare(UserVO src,UserVO tar) {
		assertEquals(src.getAddress(), tar.getAddress());
		assertEquals(src.getUserName(), tar.getUserName());
		assertEquals(src.getUserPassword(), tar.getUserPassword());
	}


	
	@After
	public void afterInit() {
		dao.deleteUser(user1.getUserId());
		dao.deleteUser(user2.getUserId());
		dao.deleteUser(user3.getUserId());

		assertEquals(0, dao.readUserCount());
	}
	
	
	
	
	
	
}
