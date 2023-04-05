package com.chan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.chan.boardself.vo.BoardVO;

public interface UserMapper {
	
	@Select("select * from Board")
	public List<BoardVO> getAllUser();
	
	@Select("select * from Board where boardNum = #{boardNum}")
	public BoardVO getUser(String id);

}
