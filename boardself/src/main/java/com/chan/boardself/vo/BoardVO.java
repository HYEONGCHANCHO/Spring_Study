package com.chan.boardself.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BoardVO {
	private Integer boardNum;
	private String boardName;
	private String boardPass;
	private String boardSubject;
	private String boardContent;
	private String boardFile;
	private Integer boardReRef;
	private Integer boardReLev;
	private Integer boardReSeq;
	private Integer boardAdcount;
	private String boardDate;
}
