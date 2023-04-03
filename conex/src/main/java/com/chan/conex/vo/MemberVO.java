package com.chan.conex.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MemberVO 	{
	private String id;
	private String password;
	private String name;
	private String address;
	private int age;
}
