package org.zerock.w1.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TodoDTO {
	
	private Integer tno;
	private String title;
	private String dueDate;
	private Integer finished;
	
}
