package com.chan.conex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chan.conex.dao.MemberDAO;
import com.chan.conex.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO dao;
	@Override
	public MemberVO getMember(String id) {
		 
		return dao.findMember;
	}

}
