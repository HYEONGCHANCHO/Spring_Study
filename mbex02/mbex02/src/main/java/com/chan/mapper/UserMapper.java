package com.chan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.chan.mbex02.vo.UserVO;

public interface UserMapper {
	
	@Select("select * from users")
	public List<UserVO> getAllUser();
	
	@Select("select * from users where id = #{id}")
	public UserVO getUser(String id);
	
	@Select("select * from users where id = #{id} and name=#{name}")
	public UserVO getUserCon(String id,String name);
}
