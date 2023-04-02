package com.chan.mbex02;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chan.mapper.TimeMapper;
import com.chan.mapper.UserMapper;
import com.chan.mbex02.vo.UserVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTest {
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private TimeMapper timeMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void beanConfigTest() {
		assertNotNull(context);
		String[] beanList = context.getBeanDefinitionNames();
		for(String beanName : beanList) {
			System.out.println("====="+beanName);
		}
	}
	
	@Test
	public void getTimeTest() {
		log.info(timeMapper.getTime()+"======================");
		log.info("mybatis가 만든 구현체 정보 :"+ timeMapper.getClass().getName());
	}
	@Test
	public void getAllUserTest() {
		List<UserVO> list = userMapper.getAllUser();
		log.info("마이바티스가 만든 구현체 정보==>"+ userMapper.getClass().getName());
		for(UserVO vo : list) {
			log.info("data list ==>"+ vo.toString());
		}
	}

	@Test
	public void getUserTest() {
		UserVO vo= userMapper.getUser("c");
		log.info("마이바티스가 만든 구현체 정보==>"+ userMapper.getClass().getName());
		log.info("data list ==>"+ vo.toString());
	}
}
