package userdb.com.chan.dao;

public interface UserDAOQuery {
	String getUser="selet * from users where id=?";
	String getAllUser="selet * from users";
	String getCount="selet count(*) from users";
	String addUser="insert into users values(?,?,?)";
	String delUser="delete from users where id=?";
	String delAll="delete from users";
	String updateUser="update users set name=?, password=? where id=?";
}
