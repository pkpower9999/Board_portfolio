package com.portfolio.controller;

import java.util.List;

import com.portfolio.service.BoardService;
import com.portfolio.vo.PostVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BoardController {

	@Autowired
	BoardService service;

	@GetMapping("/notice")
	public String getNotice(@RequestParam @Nullable Integer offset, Model model) {
		if(offset == null)
			offset = 0;
		List<PostVO> list = service.getPostList(offset, 2);
		model.addAttribute("list", list);
		
		return "/board/notice";
	}

	@GetMapping("/notice/write")
	public String getNoticeWrite(){

		return "/board/write";
	}

	@GetMapping("/notice/detail")
	public String getDetail(@RequestParam Integer no, Model model){

		PostVO data = service.getPostBySeq(no);
		model.addAttribute("data", data);

		List<Integer> likes = service.selectPostLikesCount(no);
		model.addAttribute("likes", likes);

		return "/board/detail";
	}

	@GetMapping("/notice/modify")
	public String getModifyNotice(@RequestParam Integer seq, Model model){
		PostVO vo = service.getPostBySeq(seq);
		model.addAttribute("postInfo", vo);

		return "/board/modify";

	}



	@GetMapping("/freeBoard")
	public String getFreeBoard(@RequestParam @Nullable Integer offset, Model model) {
		if(offset == null)
			offset = 0;
		List<PostVO> list = service.getPostList(offset, 3);
		model.addAttribute("list", list);
		
		return "/board/freeBoard/freeBoard";
	}

	@GetMapping("/freeBoard/write")
	public String getFreeBoardWrite(){

		return "/board/freeBoard/write";
	}

	@GetMapping("/freeBoard/modify")
	public String getModifyfreeBoard(@RequestParam Integer seq, Model model){
		PostVO vo = service.getPostBySeq(seq);
		model.addAttribute("postInfo", vo);

		return "/board/freeBoard/modify";

	}

	@GetMapping("/freeBoard/detail")
	public String getFreeBoardDetail(@RequestParam Integer no, Model model){

		PostVO data = service.getPostBySeq(no);
		model.addAttribute("data", data);

		List<Integer> likes = service.selectPostLikesCount(no);
		model.addAttribute("likes", likes);

		return "/board/freeBoard/detail";
	}

	
}
