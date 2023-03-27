package com.chan.self.dao;

public interface UserDAOQuery {
	 String addUser = "insert into users values(?,?,?)";
	 String getUser = "select * from users where id=?";
	 String getAllUser = "select * from users";
	 String getCount = "select count(*) from users";
	 String deluser = "delete from users where id=?";
	 String delAlluser = "delete from users";
	 String updateUser = "update users set name=?, password=? where id=?";

}
