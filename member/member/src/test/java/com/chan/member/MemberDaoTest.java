package com.chan.member;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chan.member.dao.MemberDao;
import com.chan.member.vo.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberDaoTest {

	@Autowired
	MemberDao dao;
	
	@Test
	public void beanTest() {
		assertNotNull(dao);
	}
	@Test
	public void getMemberTest() {
		System.out.println(dao.getMember("chan"));
	}
	@Test
	public void delMemberTest() {
		int result = dao.delMember("chan");
		assertEquals(result, 1);
	}
	@Test
	public void addAndUpdateMemberTest() {
		Member member = new Member();
		member.setMemId("chan");
		member.setMemName("형찬");
		member.setMemPwd("111222");
		member.setAddress("suwon");
		member.setEmail("chan@naver.com");
		member.setPhone("01022223333");
		member.setGender("M");
		dao.addMember(member);
		System.out.println(dao.getMember(member.getMemId())); 
		
		member.setStateCode(2);
		member.setAddress("Seoul");
		dao.updateMember(member);
		
		assertEquals(member, dao.getMember(member.getMemId()));
	}
	
}
