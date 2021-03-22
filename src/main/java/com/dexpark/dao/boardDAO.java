package com.dexpark.dao;

import java.util.ArrayList;

import com.dexpark.vo.boardVO;

public class boardDAO extends DBConn{
	
	public boolean getUpdateProc(boardVO vo, String bid) {
		boolean result = false;
		
		try {
			String sql = "update dexpark_board set btitle=?, bcontent=?, bfile=?, bsfile=? where bid=?";
			getPreparedStatement(sql);
			pstmt.setString(1, vo.getBtitle());
			pstmt.setString(2, vo.getBcontent());
			pstmt.setString(3, vo.getBfile());
			pstmt.setString(4, vo.getBsfile());
			pstmt.setString(5, bid);
			
			int val = pstmt.executeUpdate();
			if(val != 0) result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean getUpdateProcNofile(boardVO vo, String bid) {
		boolean result = false;
		
		try {
			String sql = "update dexpark_board set btitle=?, bcontent=? where bid=?";
			getPreparedStatement(sql);
			pstmt.setString(1, vo.getBtitle());
			pstmt.setString(2, vo.getBcontent());
			pstmt.setString(5, bid);
			
			int val = pstmt.executeUpdate();
			if(val != 0) result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 게시판
	 */
	public boardVO getBoardContent(String bid) {
		boardVO vo = new boardVO();
		
		try {
			String sql = "select bid, btitle, bcontent, bsfile, bdate, views, bfile from dexpark_board where bid=?";
			getPreparedStatement(sql);
			pstmt.setString(1, bid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setBid(rs.getString(1));
				vo.setBtitle(rs.getString(2));
				vo.setBcontent(rs.getString(3));
				vo.setBsfile(rs.getString(4));
				vo.setBdate(rs.getString(5));
				vo.setViews(rs.getInt(6));
				vo.setBfile(rs.getString(7));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	/**
	 * 게시판 리스트
	 */
	public ArrayList<boardVO> getBoardList() {
		ArrayList<boardVO> list = new ArrayList<boardVO>();
		
		try {
			String sql = "select rownum rno, bid, btitle, bcontent, bsfile, bdate, views from dexpark_board";
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				boardVO vo = new boardVO();
				vo.setRno(rs.getInt(1));
				vo.setBid(rs.getString(2));
				vo.setBtitle(rs.getString(3));
				vo.setBcontent(rs.getString(4));
				vo.setBsfile(rs.getString(5));
				vo.setBdate(rs.getString(6));
				vo.setViews(rs.getInt(7));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 게시판 글 작성
	 * @param vo
	 * @return
	 */
	public boolean getWrite(boardVO vo) {
		boolean result = false;
		
		try {
			String sql = "insert into dexpark_board "
					+ "values('b_'||sqe_dexpark_board.nextval,?,?,?,?,to_char(sysdate, 'YYYY-MM-DD AM HH12:MI'),0)";
			getPreparedStatement(sql);
			pstmt.setString(1, vo.getBtitle());
			pstmt.setString(2, vo.getBcontent());
			pstmt.setString(3, vo.getBfile());
			pstmt.setString(4, vo.getBsfile());
			
			int val = pstmt.executeUpdate();
			if(val != 0) result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
