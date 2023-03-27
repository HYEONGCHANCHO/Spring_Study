package userdb.com.chan.test;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import userdb.com.chan.dao.UserDAO;
import userdb.com.chan.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/userAppContext.xml"})

public class UserDAOTest {
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	UserDAO dao;	
	
	@Test
	public void contextTest() {
		System.out.println("--"+context);
	}
	@Test
	public void daoTest() {
		System.out.println("--"+dao);
	}
	
	UserVO td1, td2, td3;
	@Before
	public void dataSetup() {
		td1 = new UserVO("chan1", "형찬1", "aa1234");
		td2 = new UserVO("chan2", "형찬2", "bb1234");
		td3 = new UserVO("chan3", "형찬3", "cc1234");
	}
	
	@After
	public void clearData() {
		dao.delAll();
		assertEquals(0, dao.getCount());
	}
	
	
	@Test
	public void addandGet() {
		dao.addUser(td1);
		assertEquals(1, dao.getCount());
		dao.addUser(td2);
		assertEquals(2, dao.getCount());
		dao.addUser(td3);
		assertEquals(3, dao.getCount());
		
		UserVO rv =null;
		rv=dao.getUser(td1.getId());
		resultCheck(rv,td1);
		rv=dao.getUser(td2.getId());
		resultCheck(rv,td2);
		rv=dao.getUser(td3.getId());
		resultCheck(rv,td3);
	}
	private void resultCheck(UserVO rv, UserVO td) {
		assertEquals(rv.getName(), td.getName());
		assertEquals(rv.getPassword(), td.getPassword());
	}
	
	@Test(expected = EmptyResultDataAccessException.class)
	public void getNullDataTest() {
		UserVO rv=dao.getUser("chan");
	}
}
