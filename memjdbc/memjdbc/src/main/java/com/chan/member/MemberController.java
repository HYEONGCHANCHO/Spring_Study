package com.chan.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chan.member.dao.MemberJDBCTempDao;
import com.chan.member.vo.MemberVO;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberJDBCTempDao service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	
	@RequestMapping(value = "member/addMember", method = RequestMethod.GET)
	public String addMember() {
		return "addMember";
	}

	@RequestMapping(value = "member/addMember", method = RequestMethod.POST)
	public String addMember(MemberVO member) {
		int result = service.addMember(member);
		return "redirect:/";
	}
	@RequestMapping(value = "member/delMember", method = RequestMethod.GET)
	public String delMember() {
		return "delMember";
	}
	@RequestMapping(value = "member/delMember", method = RequestMethod.POST)
	public String delMember(String memId) {
		int result = service.delMember(memId);
		return "redirect:/";
	}
	@RequestMapping(value = "member/getMember", method = RequestMethod.GET)
	public String getMember() {
		return "getMember";
	}
	@RequestMapping(value = "member/getMember", method = RequestMethod.POST)
	public String getMember(String memId,Model model) {
		MemberVO member = service.getMember(memId);
		if(member==null) {
			model.addAttribute("member",memId);
			return "idError";
		}
		model.addAttribute("member",member);
		return "getView";
	}
	@RequestMapping(value = "member/updateMember", method = RequestMethod.POST)
	public String updateMember(MemberVO member, Model model) {
		service.updateMember(member);
		return "redirect:/";
	}
}