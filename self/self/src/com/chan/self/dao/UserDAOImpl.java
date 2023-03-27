package com.chan.self.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.chan.self.vo.UserVO;

public class UserDAOImpl implements UserDAO {

	@Autowired
	DataSource dataSource;

	@Override
	public void addUser(UserVO vo) {
		Connection c=null;
		PreparedStatement ps=null;
		try {
			c=dataSource.getConnection();
			ps=c.prepareStatement(UserDAOQuery.addUser);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
		} finally {
			if(ps!=null)try {ps.close();} catch (SQLException e) {e.printStackTrace();}
			if(c!=null)try {c.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}

	@Override
	public UserVO getUser(String id) {
		Connection c=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		UserVO rtn = null;
		try {
			c=dataSource.getConnection();
			ps=c.prepareStatement(UserDAOQuery.getUser);
			rs=ps.executeQuery();
			
			
			
		} catch (SQLException e) {
		} finally {
			if(ps!=null)try {ps.close();} catch (SQLException e) {e.printStackTrace();}
			if(c!=null)try {c.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return null;
	}
		

	@Override
	public List<UserVO> getAllUser(String id) {
		return null;
		
	}

	@Override
	public Integer getCount() {
		return null;
	}

	@Override
	public void deluser(String id) {
		
	}

	@Override
	public void delAlluser() {
		Connection c=null;
		PreparedStatement ps=null;
		try {
			c=dataSource.getConnection();
			ps=c.prepareStatement(UserDAOQuery.delAlluser);
			ps.executeUpdate();
		} catch (SQLException e) {
		} finally {
			if(ps!=null)try {ps.close();} catch (SQLException e) {e.printStackTrace();}
			if(c!=null)try {c.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}
		
		
	

	@Override
	public void updateUser(UserVO vo) {
		
	}
	
}
