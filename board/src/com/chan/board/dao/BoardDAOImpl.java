package com.chan.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.chan.board.vo.BoardVO;

public class BoardDAOImpl implements BoardDAO{

	//@Autowired
	private JdbcTemplate JdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		JdbcTemplate = jdbcTemplate;
	}
	
	private RowMapper<BoardVO> rowMapper = new RowMapper<BoardVO>() {
		public BoardVO mapRow(ResultSet rs, int arg1) throws SQLException{
			BoardVO vo = new BoardVO();
			vo.setBoardContent(rs.getString("boardContent"));
			vo.setBoardDate(rs.getString("boardDate"));
			vo.setBoardFile(rs.getString("boardFile"));
			vo.setBoardName(rs.getString("boardName"));
			vo.setBoardpass(rs.getString("boardpass"));
			vo.setBoardSubject(rs.getString("boardSubject"));
			vo.setBoardNum(rs.getInt("BoardNum"));
			vo.setBoardReRef(rs.getInt("BoardReRef"));
			vo.setBoardReLev(rs.getInt("BoardReLev"));
			vo.setBoardReSeq(rs.getInt("BoardReSeq"));
			vo.setBoardReadCount(rs.getInt("BoardReadCount"));
			return vo;
		}
	};
	
	@Override
	public Integer add(BoardVO vo) {
		return JdbcTemplate.update("insert into board values(?,?,?,?,?,?,?,0,0,0,sysdate)",
				vo.getBoardNum(),vo.getBoardName(),vo.getBoardpass(),
				vo.getBoardSubject(),vo.getBoardContent(),
				vo.getBoardFile(),vo.getBoardReRef() );
	}

	@Override
	public int getMax() {
		return JdbcTemplate.queryForObject("select max(boardNum) from board", Integer.class);
	}

	@Override
	public Integer del(Integer boardNum) {
		return JdbcTemplate.update("delete from board where boardNum = ?",boardNum);
	}

	@Override
	public int getCount() {
		return JdbcTemplate.queryForObject("select count(*) from board", Integer.class);
	}

	@Override
	public int update(BoardVO vo) {
		return JdbcTemplate.update("update board set boardSubject= ?, boardContent = ?, boardName=? where boardNum=?",
				vo.getBoardSubject(),vo.getBoardContent(),
				vo.getBoardName(),vo.getBoardNum());
	}

	@Override
	public List<BoardVO> getList(int start, int end) {
		String query = "select * from (select rownum num, imsi.* from (select * from board order by boardReRef desc, boardReSeq ) imsi ) where num >=? and num <= ?";
		return JdbcTemplate.query(query, 
				new Object[] {start, end }, 
				rowMapper);
	}
	
	@Override
	public BoardVO get(int boardNum) {
		return JdbcTemplate.queryForObject("select * from board where boardNum = ?",
				new Object[] {boardNum} ,
				rowMapper);
	}

}
