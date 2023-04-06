package com.chan.do1.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SimplebdVO {

	private int boardNum;
	private String boardName;
	private String boardPass; 
	private String boardSubject;
	private String boardContent;
	private String boardDate; 
	
}
