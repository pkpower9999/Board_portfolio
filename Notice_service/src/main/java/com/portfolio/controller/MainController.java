package com.portfolio.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.portfolio.service.BoardService;
import com.portfolio.vo.PostVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@Autowired
	BoardService service;

	@GetMapping("/")
	public String getMain(Model model) {
		List<PostVO> noticeList = service.getPostList(0, 2);
		List<PostVO> freeBoardList = service.getPostList(0, 3);

		List<PostVO> newNoticeList = new ArrayList<PostVO>();
		List<PostVO> newFreeBoardList = new ArrayList<PostVO>();

		int limit = 0;
		if(noticeList.size() < 10) limit = noticeList.size();
		else limit = 10;

		for(int i=0; i<limit; i++){
			newNoticeList.add(noticeList.get(i));
			newFreeBoardList.add(freeBoardList.get(i));
		}

		model.addAttribute("noticeList", newNoticeList);
		model.addAttribute("freeBoardList", newFreeBoardList);

		return "/main";
	}

	@GetMapping("/member/login")
	public String getLogin() {
		return "/member/login";
	}

	@GetMapping("/member/join")
	public String getJoin() {
		return "/member/join";
	}

	@GetMapping("/member/logout")
	public String getLogout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}

}
