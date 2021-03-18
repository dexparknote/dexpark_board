package com.dexpark.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dexpark.service.boardServiceImpl;
import com.dexpark.vo.boardVO;

@Controller 
public class boardController {
	
	@Autowired
	private boardServiceImpl boardService;
	
	@RequestMapping(value="/board_list.do", method=RequestMethod.GET)
	public String board_list() {
		return "board_list";
	}
	
	@RequestMapping(value="board_content.do", method=RequestMethod.GET)
	public String board_content() {
		return "board_content";
	}
	
	@RequestMapping(value="board_write.do", method=RequestMethod.GET)
	public ModelAndView board_write() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board_write");
		return mv;
	}
	
	@RequestMapping(value="boardWriteProc.do", method=RequestMethod.POST)
	public ModelAndView boardWriteProc(boardVO vo, HttpServletRequest request) {
		String path1 = request.getSession().getServletContext().getRealPath("/");
		String path2 = "\\resources\\upload\\";
		vo.setSavepath(path1 + path2);
		
		return boardService.getResultWrite(vo, request);
	}
	
	@RequestMapping(value="board_update.do", method=RequestMethod.GET)
	public String board_update() {
		return "board_update";
	}
}
