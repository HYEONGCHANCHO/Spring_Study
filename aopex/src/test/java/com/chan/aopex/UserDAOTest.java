package com.chan.aopex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chan.aopex.dao.UserDAO;
import com.chan.aopex.vo.UserVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class UserDAOTest {
	
	
	@Autowired
	UserDAO dao;	
	
	UserVO user1,user2,user3;
	
	@Autowired
	ApplicationContext context;
	
	@Test
	public void dsTest() {
		assertNotNull(dao);
	}

	
	@Before
	public void dataSetup() {
		assertEquals(0, dao.readUserCount());
		user1 = new UserVO("aaa","aaapasword","aaaname","aaadress");
		user2 = new UserVO("bbb","bbbpasword","bbbname","bbbdress");
		user3 = new UserVO("ccc","cccpasword","cccname","cccdress");
		
	}
	
	@Test
	public void createAndDeleteAndReadUserTest() {
		assertEquals(dao.create(user1), 1); 
		dataCompare(user1, dao.readUser(user1.getUserId()));
		assertEquals(1, dao.readUserCount());
		
		assertEquals(dao.create(user2), 1); 
		dataCompare(user2, dao.readUser(user2.getUserId()));
		assertEquals(2, dao.readUserCount());
		
		assertEquals(dao.create(user3), 1); 
		dataCompare(user3, dao.readUser(user3.getUserId()));
		assertEquals(3, dao.readUserCount());
		
	}
	
	private void dataCompare(UserVO src,UserVO tar) {
		assertEquals(src.getAddress(), tar.getAddress());
		assertEquals(src.getUserName(), tar.getUserName());
		assertEquals(src.getUserPassword(), tar.getUserPassword());
	}

	@Test
	public void updateUserTest() {
		dao.create(user1);
		dao.create(user2);
		log.info("원본" +dao.readUser(user2.getUserId()));
		dao.create(user3);
		user2.setAddress("서울 코리아");
		user2.setUserPassword("seoul korea");
		user2.setUserName("대한민국");
		log.info("변경전 변경할 정보"+ user2);
		assertEquals(1, dao.updatUser(user2));
		log.info("변경후 정보"+dao.readUser(user2.getUserId()));
		dataCompare(user2, dao.readUser(user2.getUserId()));
		dataCompare(user1, dao.readUser(user1.getUserId()));
		dataCompare(user3, dao.readUser(user3.getUserId()));
	}
	
	@After
	public void afterInit() {
		dao.deleteUser(user1.getUserId());
		dao.deleteUser(user2.getUserId());
		dao.deleteUser(user3.getUserId());

		assertEquals(0, dao.readUserCount());
	}
	
	
	
	
	
	
}
