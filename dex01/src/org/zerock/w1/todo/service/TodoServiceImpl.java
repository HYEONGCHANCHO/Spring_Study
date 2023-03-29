package org.zerock.w1.todo.service;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.zerock.w1.todo.dto.TodoDTO;
import org.zerock.w1.todo.repositoy.TodoRepository;

public class TodoServiceImpl implements TodoService{

	TodoRepository repository;
	
	public void setRepository(TodoRepository repository) {
		this.repository = repository;
	}
	
	
	@Override
	public int add(TodoDTO dto) {
		dto.setDueDate(new Date().toString());
		dto.setTitle("sample todo title");
		dto.setTno(2);
		return repository.add(dto);
	}
	@Override
	public int delAll() {
		return repository.delAll();
	}

}
