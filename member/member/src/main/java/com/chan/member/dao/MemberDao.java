package com.chan.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chan.member.vo.Member;

@Repository
public class MemberDao {
	@Autowired
	SqlSession session;
	
	public Member getMember(String memId) {
		return session.selectOne("memberNs.getMember",memId);
	}
	
	public int addMember(Member member) {
		return session.insert("memberNs.addMember",member);
	}
	
	public int delMember(String memId) {
		return session.delete("memberNs.delMember",memId);
	}
	
	public int updateMember(Member member) {
		return session.update("memberNs.updateMember",member);
	}


}
