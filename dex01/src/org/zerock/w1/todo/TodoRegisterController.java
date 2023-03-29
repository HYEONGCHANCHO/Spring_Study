package org.zerock.w1.todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.zerock.w1.todo.dto.TodoDTO;
import org.zerock.w1.todo.repositoy.TodoImpl;
import org.zerock.w1.todo.service.TodoService;
import org.zerock.w1.todo.service.TodoServiceImpl;


@WebServlet("/todo/register")
public class TodoRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TodoService service = new TodoServiceImpl();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("입력 폼 화면을 보여줍니다.");
		request.getRequestDispatcher("/WEB-INF/todo/register.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service.setRepository(new TodoImpl());
		TodoDTO dto = new TodoDTO();
//		dto.setDueDate(request.getParameter("dueDate"));
//		dto.setFinished(Integer.parseInt(request.getParameter("finished")));
//		dto.setTitle(request.getParameter("title"));
//		dto.setTno(Integer.parseInt(request.getParameter("tno")));
		service.add(dto);
		response.sendRedirect(request.getContextPath()+"/todo/list");
	}
}
