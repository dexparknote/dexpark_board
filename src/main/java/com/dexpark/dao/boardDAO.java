package com.dexpark.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.dexpark.vo.boardVO;

public class boardDAO extends DBConn{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static String namespace = "mapper.board";
	
	public boolean getBoardDelete(String bid) {
		boolean result = false;
		int val = sqlSession.delete(namespace+".delete", bid);
		if(val != 0) result = true;
		return result;
	}
	
	public boolean getUpdateProc(boardVO vo) {
		boolean result = false;
		int val = sqlSession.update(namespace+".update",vo);
		if(val != 0) result = true;
		return result;
	}
	
	/**
	 * 게시판
	 */
	public boardVO getBoardContent(String bid) {
		return sqlSession.selectOne(namespace+".content", bid);
	}
	
	/**
	 * 게시판 리스트
	 */
	public ArrayList<boardVO> getBoardList() {
		List<boardVO> list = sqlSession.selectList(namespace+".list");
		return (ArrayList<boardVO>)list;
	}
	
	/**
	 * 게시판 글 작성
	 * @param vo
	 * @return
	 */
	public boolean getWrite(boardVO vo) {
		boolean result = false;
		int val = sqlSession.insert(namespace+".insert", vo);
		if(val != 0) result = true;
		return result;
	}
}
