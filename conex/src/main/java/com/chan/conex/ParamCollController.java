package com.chan.conex;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chan.conex.service.MemberService;
import com.chan.conex.vo.ListMemberVO;
import com.chan.conex.vo.MemberVO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping(value = "/param/")
@Log4j
public class ParamCollController {

	@Autowired
	MemberService service;
	
	@RequestMapping("one")
	public void one(@RequestParam("data1") int data2) { // data1로 들어오는 data를 data2로 받겠다는 의미지만 굳이 쓸필요는 없음.
		System.out.println(data2 + 1234);
	}

	@RequestMapping("two")
	public void two(@RequestParam("data1") ArrayList<String> data1) { // 여러데이터 등을 받을 때 @RequestParam("")가 필요하다.
//		log.info()
		System.out.println(data1.get(0));
		System.out.println(data1.get(1));
		System.out.println(data1.get(2));

	}

	@RequestMapping("three")
	public void three(@RequestParam("data1") String[] data1) {
		System.out.println(data1[0]);
		System.out.println(data1[1]);
		System.out.println(data1[2]);

	}

	@RequestMapping("four")
	public void four(MemberVO vo,HttpServletRequest request,HttpSession ses, Model model) {
		System.out.println(vo);
		request.setAttribute("vo", vo);
		ses.setAttribute("sesVO", vo);
		model.addAttribute("dbResultVO",service.getMember(vo.getId()));
	}
	@RequestMapping("four2")
	public void four2(MemberVO vo) {
	}

	@RequestMapping("five")
	public void five(ListMemberVO list, Model model) {
		model.addAttribute("lsit", list);
	}
	
//	@RequestMapping(value="six", method = RequestMethod.GET) 
	//cf. @RequestMapping보다는 @GetMapping또는 @PosttMapping을 사용하는 것이 좋다.
	@GetMapping(value="six")
	public void six(@ModelAttribute("vo") MemberVO vo,
			@ModelAttribute("test") int test) {
	}
//	@RequestMapping(value="six", method = RequestMethod.POST)
//	@PostMapping(value="six")
	

}
