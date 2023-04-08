package com.chan.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.chan.member.dao.MemberJDBCTempDao;
import com.chan.member.vo.MemberVO;

@Service
public class MemberService {
	@Autowired
	MemberJDBCTempDao dao;
	
	public int addMember(MemberVO vo) {
		return dao.addMember(vo);
	}
	public int delMember(String memId) {
		return dao.delMember(memId);
	}
	public int updateMember(MemberVO vo) {
		return dao.updateMember(vo);
	}
	
	public MemberVO getMember(String memId) {
		try {
			return dao.getMember(memId);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	
	
}
