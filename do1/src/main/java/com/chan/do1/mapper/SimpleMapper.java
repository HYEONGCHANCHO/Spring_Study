package com.chan.do1.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.chan.do1.vo.SimplebdVO;

public interface SimpleMapper {

	@Select("SELECT sysdate FROM dual")
	public String gettime();

	public String gettime2();
	
	@Insert("insert into simplebd values( #{boardNum}, #{boardName}, #{boardPass}, #{boardSubject}, #{boardContent}, sysdate")
	public int insert(SimplebdVO vo);
}
