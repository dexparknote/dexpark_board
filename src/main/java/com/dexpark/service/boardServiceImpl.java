package com.dexpark.service;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.dexpark.dao.boardDAO;
import com.dexpark.vo.boardVO;

@Service("boardService")
public class boardServiceImpl {
	
	@Autowired
	private boardDAO boardDAO;
	
	public ModelAndView getResultWrite(boardVO vo, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		boardVO bvo = (boardVO)vo;
		
		if(bvo.getFile1().getSize() != 0) {
			UUID uuid = UUID.randomUUID();
			bvo.setBfile(bvo.getFile1().getOriginalFilename());
			bvo.setBsfile(uuid + "_" + bvo.getFile1().getOriginalFilename());
			
			boolean result = boardDAO.getWrite(bvo);
			if(result) {
				try {
					File file = new File(vo.getSavepath() + bvo.getBsfile());
					bvo.getFile1().transferTo(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				mv.setViewName("redirect:board_list.do");
				
			} else {
				mv.setViewName("errorPage");
			}
			
		}
		
		return mv;
	}
	
}
