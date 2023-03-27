package com.chan.self.dao;

import java.util.List;

import com.chan.self.vo.UserVO;

public interface UserDAO {

	public void addUser(UserVO vo);
	public UserVO getUser(String id);
	public List<UserVO> getAllUser(String id);
	public Integer getCount();
	public void deluser(String id);
	public void delAlluser();
	public void updateUser(UserVO vo);
}
