package com.dexpark.dao;

import com.dexpark.vo.boardVO;

public class boardDAO extends DBConn{
	
	public boolean getWrite(boardVO vo) {
		boolean result = false;
		
		try {
			String sql = "insert into dexpark_board "
					+ "values(sqe_dexpark_board.nextval,?,?,?,?,to_char(sysdate, 'YYYY-MM-DD AM HH12:MI'),0)";
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
