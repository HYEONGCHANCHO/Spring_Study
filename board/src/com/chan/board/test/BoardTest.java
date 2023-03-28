package com.chan.board.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chan.board.dao.BoardDAO;
import com.chan.board.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class) // db에 연결할거니까 이거랑 아래거 적어주기
@ContextConfiguration(locations = { "/boardbeans.xml" })
public class BoardTest {
	@Autowired
	ApplicationContext context;

	@Autowired
	BoardDAO dao;

	BoardVO data1, data2, data3;

	@Test
	@Ignore
	public void contextTest() {
		assertNotNull(context); // boardbeans.xml에서 제대로 읽어오는지 확인
	}

	@Before
	public void init() {
		data1 = new BoardVO("조형찬1", "1111", "testsubject1", "Test contents1");
		data2 = new BoardVO("조형찬2", "2222", "testsubject2", "Test contents2");
		data3 = new BoardVO("조형찬3", "3333", "testsubject3", "Test contents3");
	}

	@Test
	public void addTest() {
		int max = dao.getMax();
		data1.setBoardNum(max + 1);
		data1.setBoardReRef(max + 1);
		assertEquals(dao.add(data1), 1);

		max = dao.getMax();
		data2.setBoardNum(max + 1);
		data2.setBoardReRef(max + 1);
		assertEquals(dao.add(data2), 1);

		max = dao.getMax();
		data3.setBoardNum(max + 1);
		data3.setBoardReRef(max + 1);
		assertEquals(dao.add(data3), 1);

		Integer result = dao.del(data1.getBoardNum());
		assertEquals(result, 1);
		
		result = dao.del(data2.getBoardNum());
		assertEquals(result, 1);
		
		result = dao.del(data3.getBoardNum());
		assertEquals(result, 1);
	}
	
	@Test
	public void getListTest() {
		List<BoardVO> list =dao.getList(6, 10);
		assertEquals(list.size(), 5);
		for (BoardVO boardVO : list) {
			System.out.println(boardVO);
		}
	}
	

}
