package com.chan.mbex01.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chan.mbex01.vo.UserVO;

@Repository
public class UserDAOImpl implements UserDAO{
		@Autowired
		private SqlSession session;

		public void insert(UserVO user) {
			session.insert("userNS.insertUser", user);
		}
		
		public UserVO selectOne(String id) {
			return session.selectOne("userNS.selOne", id);
		}

		public int delUser(String id) {
			return session.delete("userNS.delUser", id);
		}
		
		public List<UserVO> getAll() {
			return session.selectList("userNS.selList");
		}
		
		
	}

