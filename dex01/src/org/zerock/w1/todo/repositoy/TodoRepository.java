package org.zerock.w1.todo.repositoy;

import org.zerock.w1.todo.dto.TodoDTO;

public interface TodoRepository {

	int add(TodoDTO dto);

	int delAll();

}
