package exam.chan.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import exam.chan.dao.ExamDao;
import exam.chan.vo.ExamVO;

public class ExamTest {
	ExamVO vo1 = new ExamVO("aaaa","kinsss", "aaaadada");
	ExamVO vo2 = new ExamVO("aavv","kffnsss", "aafffada");
	
	@Test
	public void userAdd() {
		ApplicationContext context = new GenericXmlApplicationContext("beans.xml");
		ExamDao dao = context.getBean("ExamDao",ExamDao.class);
		dao.addUser(vo1);
		dao.addUser(vo2);
		assertEquals(dao.count(),2);
	}
}
