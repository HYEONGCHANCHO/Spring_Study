package userdb.com.chan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class JdbcContext {
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public int workWithStatementStrategy(StatementStratgy stratgy){
		Connection c=null;
		PreparedStatement ps = null;
		try {
			c=dataSource.getConnection();
			ps = stratgy.makeStatement(c);
			
			return ps.executeUpdate();
				} catch (SQLException e) {

				}finally {
					if(ps!=null)try {ps.close();} catch (SQLException e) {e.printStackTrace();}
					if(c!=null)try {c.close();} catch (SQLException e) {e.printStackTrace();}
				}
			return 0;
			}

	public int executeSql(String query) {
		return workWithStatementStrategy( new StatementStratgy() {
			public PreparedStatement makeStatement(Connection c) throws SQLException {
				return c.prepareStatement(query);
			}
		});
	}
	
	
	
}
