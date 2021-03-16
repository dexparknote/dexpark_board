package com.dexpark.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
public class boardController {
	
	@RequestMapping(value="/board_list.do", method=RequestMethod.GET)
	public String board_list() {
		return "board_list";
	}
	
	@RequestMapping(value="board_content", method=RequestMethod.GET)
	public String board_content() {
		return "board_content";
	}
	
	@RequestMapping(value="board_write", method=RequestMethod.GET)
	public String board_write() {
		return "board_write";
	}
	
	@RequestMapping(value="board_update", method=RequestMethod.GET)
	public String board_update() {
		return "board_update";
	}
}
