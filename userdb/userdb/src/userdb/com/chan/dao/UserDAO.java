package userdb.com.chan.dao;


import java.util.List;

import userdb.com.chan.vo.UserVO;

public interface UserDAO {
	public UserVO getUser(String id);
	public List<UserVO> getAllUser();
	public Integer getCount();
	public int addUser(UserVO vo);
	public int delUser(String id);
	public void delAll();
	public void updateUser(UserVO vo);
	
}
