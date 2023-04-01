package userdb.com.chan.JdbcTemplatedao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import userdb.com.chan.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/templatebeans.xml"})

public class TemplateuserDaoTest {



	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	TemplateuserDao dao;
	UserVO vo1,vo2,vo3;
	@Before
	public void dataSetup() {
		vo1 = new UserVO("ch1", "형1", "aa12");
		vo2 = new UserVO("ch2", "형2", "bb12");
		vo3 = new UserVO("ch3", "형3", "cc12");
	}
	
	
	@Test
	public void addandGet() {
		dao.addUser(vo1);
		assertEquals(1, dao.getCount());
		dao.addUser(vo2);
		assertEquals(2, dao.getCount());
		dao.addUser(vo3);
		assertEquals(3, dao.getCount());
		
		UserVO rv =null;
		rv=dao.getUser(vo1.getId());
		resultCheck(rv,vo1);
		rv=dao.getUser(vo2.getId());
		resultCheck(rv,vo2);
		rv=dao.getUser(vo3.getId());
		resultCheck(rv,vo3);
	}
	
	@After
	public void clearData() {
		dao.delAll();
		assertEquals(dao.getCount(),null);
	}
	private void resultCheck(UserVO rv, UserVO td) {
		assertEquals(rv.getName(), td.getName());
		assertEquals(rv.getPassword(), td.getPassword());
	}
	
	@Test(expected = EmptyResultDataAccessException.class)
	public void getNullDataTest() {
		dao.getUser("없는");
	}
	
	@Test
	public void deleteAllTest() {
		
	}
	
	@Test
	public void getAll() {
		dao.addUser(vo1); dao.addUser(vo2);dao.addUser(vo3);
		assertEquals(dao.getCount(), 3);
		List<UserVO> list=dao.getAll();
		assertEquals(vo1, list.get(0));
		assertEquals(vo2, list.get(1));
		assertEquals(vo3, list.get(2));
	}
	
	@Test
	public void delUserTest() {
		dao.addUser(vo1);
		assertEquals(1, dao.getCount());
		assertEquals(1, dao.delUser(vo1.getId()));
		assertEquals(0, dao.getCount());
	}
	
	
	
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		this.dataSource = dataSource;
	}	

	public UserVO getUser(String id) throws EmptyResultDataAccessException {

		return this.jdbcTemplate.queryForObject("select * from users where id=?", 
				new Object[] {id}, new RowMapper<UserVO>() {
					public UserVO mapRow(ResultSet rs,int arg1) throws SQLException{
						UserVO rtnVO = new UserVO();
						rtnVO.setId(rs.getString("id"));
						rtnVO.setName(rs.getString("name"));
						rtnVO.setPassword(rs.getString("password"));
						return rtnVO;}
		});
	}
	
	public Integer getCount() {
		return jdbcTemplate.queryForObject("select count(*)from users", Integer.class);
	}
	
	public int addUser(UserVO vo) {
		return jdbcTemplate.update("insert into users values(?,?,?)", 
				vo.getId(), vo.getName(), vo.getPassword());
	}
	
	public void delAll() {
		jdbcTemplate.update("delete from users");
	}

}
