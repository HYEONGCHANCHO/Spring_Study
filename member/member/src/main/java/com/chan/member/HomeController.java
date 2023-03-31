package com.chan.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chan.member.dao.MemberDao;
import com.chan.member.vo.Member;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	MemberDao dao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "home";
	}
	
	@RequestMapping(value = "/addMember", method = RequestMethod.GET)
	public String addMember() {
		return "addMember";
	}

	@RequestMapping(value = "/addMember", method = RequestMethod.POST)
	public String addMember(Member member) {
		System.out.println("================> " + member );
		int result = dao.addMember(member);
		System.out.println(result+"개의 자료가 입력되었습니다");
		return "redirect:/";
	}

	@RequestMapping(value = "/delMember", method = RequestMethod.GET)
	public String delMember() {
		
		return "delMember";
	}
	
	@RequestMapping(value = "/delMember", method = RequestMethod.POST)
	public String delMember(String memId) {
		System.out.println("넘겨받은 아이디"+memId);
		int result = dao.delMember(memId);
		System.out.println(result+"개의 자료가 삭제되었습니다");
		return "redirect:/";
	}
	
	@RequestMapping(value = "/getMember", method = RequestMethod.GET)
	public String getMember() {
		
		return "getMember";
	}
	
	@RequestMapping(value = "/getMember", method = RequestMethod.POST)
	public String getMember(String memId,Model model) {
		Member member = dao.getMember(memId);
		model.addAttribute("member",member);
		return "getView";
	}
	
	
	@RequestMapping(value = "/updateMember", method = RequestMethod.POST)
	public String updateMember(Member member, Model model) {
		dao.updateMember(member);
		return "redirect:/";
	}
	
}
