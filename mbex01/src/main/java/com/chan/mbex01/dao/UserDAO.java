package com.chan.mbex01.dao;

import java.util.List;

import com.chan.mbex01.vo.UserVO;

public interface UserDAO {
	//private SqlSession session;
	public void insert(UserVO user);
	public UserVO selectOne(String id);
	public int delUser(String id);
	public List<UserVO> getAll();
	
}
