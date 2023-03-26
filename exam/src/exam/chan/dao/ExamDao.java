package exam.chan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import exam.chan.vo.ExamVO;

public class ExamDao {
	
	DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void addUser(ExamVO vo1) {
		Connection c = null;
		PreparedStatement ps =null;
		try {
			c=dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String query = "insert into users(id,name,password) values(?,?,?)";
		ps.setString(1, vo1.getId());
		ps.setString(2, vo1.geName());
		ps.setString(3, vo1.getPassword());
		try {
			ps=c.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public Integer count() {
		// TODO Auto-generated method stub
		return null;
	}

}
