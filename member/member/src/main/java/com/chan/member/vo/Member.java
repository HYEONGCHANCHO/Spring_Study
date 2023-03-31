package com.chan.member.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Member {
	@NonNull private String memId;
	@NonNull private String memName;
	@NonNull private String memPwd;
	private String email;
	private String phone;
	private String address;
	private String gender;
	private Integer stateCode;
	private String regiDate;

	
}
