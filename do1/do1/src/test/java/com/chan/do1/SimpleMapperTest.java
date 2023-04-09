package com.chan.do1;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chan.do1.mapper.SimpleMapper;
import com.chan.do1.vo.SimplebdVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class SimpleMapperTest {
//	@Autowired
//	ApplicationContext con;

//	@Setter(onMethod_=@Autowired)
//	private SimpleMapper simpleMapper;

	 @Autowired
	 SimpleMapper simpleMapper;
	@Test
	public void testmybatis() {
		assertNotNull(simpleMapper);
	}	
	@Test
	public void testmybatiss() {
		assertNotNull(14);
	}

//	
	@Test
	public void testGettime() {
		System.out.println("gettime2==>>>>"+simpleMapper.gettime2());
		System.out.println("gettime==>>>>"+simpleMapper.gettime());
	}
	SimplebdVO vo;
	
	
	
//	@Test
//	public void insertTest(SimplebdVO vo) {
//		
//		simpleMapper.insert(vo.getBoardNum(),vo.getBoardName(),vo.getBoardPass()
//				,vo.getBoardSubject(),vo.getBoardContent(),vo.getBoardDate());
//		
//		SimplebdVO simple=new SimplebdVO(1,"a","a","s","d","d");
//		simplemapper.insert(simple);
//		assertNotEquals(0, simplemapper);
//	}

}
