package com.chan.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	@Select("SELECT sysdata FROM dual")
	public String gettime();
}
