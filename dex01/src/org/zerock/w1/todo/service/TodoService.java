package org.zerock.w1.todo.service;

import org.zerock.w1.todo.dto.TodoDTO;

public interface TodoService {

	int add(TodoDTO dto);

	int delAll();

}
