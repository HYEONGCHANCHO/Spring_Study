package com.chan.aopex.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class UserVO {
	@NonNull	private String userId;
	@NonNull	private String userPassword;
	@NonNull	private String userName;
	private String address;

}
