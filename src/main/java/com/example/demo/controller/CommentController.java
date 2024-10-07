package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CommentDTO;
import com.example.demo.service.CommentService;

@RequestMapping("/comment")
@RestController   // @ResponseBody + @Controller
public class CommentController {

	@Autowired
	CommentService service;
	
	// Class List -> JSON 문자열 List로 변환
	// @ResponseBody
	// 게시물에 달린 댓글 목록을 반환하는 메소드
	@GetMapping("/list") // /comment/list?boardNo=1
	public List<CommentDTO> list(@RequestParam(name = "boardNo") int boardNo) {
		
		// 댓글 목록 조회
		List<CommentDTO> list = service.getListByBoardNo(boardNo);
		
		return list;
		
	}
	
}
