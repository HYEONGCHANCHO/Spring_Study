package org.zerock.w1.todo.repositoy;

import org.springframework.jdbc.core.JdbcTemplate;
import org.zerock.w1.todo.dto.TodoDTO;

public class TodoImpl implements TodoRepository {
	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int add(TodoDTO dto) {

		if (dto.getDueDate() == null) {
			return jdbcTemplate.update("insert into todos values(?,?,sysdate,?)", dto.getTno(), dto.getTitle(),
					dto.getFinished());
		}
		return jdbcTemplate.update("insert into todos values(?,?,TO_DATE(?,'YYYY/MM/DD'),?)", dto.getTno(), dto.getTitle(), dto.getDueDate(),
				dto.getFinished());
	}

	@Override
	public int delAll() {
		return jdbcTemplate.update("delete from todos");
	}
}
