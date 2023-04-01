package userdb.com.chan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface StatementStratgy {
 public PreparedStatement makeStatement(Connection c) throws SQLException;
}
