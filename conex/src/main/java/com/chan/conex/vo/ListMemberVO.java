package com.chan.conex.vo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ListMemberVO {
	private List<MemberVO> list;
	
	public ListMemberVO() {
		list=new ArrayList<>();
	}
}
