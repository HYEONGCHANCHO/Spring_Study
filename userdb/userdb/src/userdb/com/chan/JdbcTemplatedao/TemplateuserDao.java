package userdb.com.chan.JdbcTemplatedao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import userdb.com.chan.vo.UserVO;



public class TemplateuserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	RowMapper<UserVO> selectMapper =(rs,arg1) ->{
			UserVO rtnVO = new UserVO();
			rtnVO.setId(rs.getString("id"));
			rtnVO.setName(rs.getString("name"));
			rtnVO.setPassword(rs.getString("password"));
			return rtnVO;
			
	};
	
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
	
	public List<UserVO> getAll(){
		return this.jdbcTemplate.query("select * from users", new RowMapper<UserVO>() {
			
			@Override
			public UserVo mapRow(ResultSet rs,int arg1) throws SQLException{
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
