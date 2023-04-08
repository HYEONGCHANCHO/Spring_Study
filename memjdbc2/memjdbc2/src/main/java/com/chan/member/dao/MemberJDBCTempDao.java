package com.chan.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.chan.member.vo.MemberVO;

@Repository
public class MemberJDBCTempDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<MemberVO> mapper = new RowMapper<MemberVO>() {

		@Override
		public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberVO vo = new MemberVO();
			vo.setAddress(rs.getString("Address"));
			vo.setEmail(rs.getString("email"));
			vo.setGender(rs.getString("gender"));
			vo.setMemId(rs.getString("memId"));
			vo.setMemName(rs.getString("memName"));
			vo.setMemPwd(rs.getString("memPwd"));
			vo.setPhone(rs.getString("phone"));
			vo.setStateCode(rs.getInt("stateCode"));
			vo.setRegiDate(rs.getString("regiDate"));
			return vo;
		}
	};
	
	public int addMember(MemberVO vo) {

		return jdbcTemplate.update("insert into members valuse(?,?,?,?,?,?,?,1,sysdate)",
				vo.getMemId(),vo.getMemName(),vo.getMemPwd(),vo.getEmail(),
				vo.getPhone(),vo.getAddress(),vo.getGender()
				);
	}
	
	public int delMember(String memId) {

		return jdbcTemplate.update("delete from members where memId=?",memId);
	}
	
	public MemberVO getMember(String memId) {
		return jdbcTemplate.queryForObject("select * from members where memId=?", new Object[] {memId},mapper);
	}

	public int updateMember(MemberVO vo) {
		return jdbcTemplate.update("update members set memPwd=?, email=?, phone=?, address=? where memId=?",
				vo.getMemPwd(),vo.getEmail(),vo.getPhone(),vo.getAddress(),vo.getMemId()
				);	
		
	}

}
