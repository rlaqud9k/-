package com.board.test;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myapp.mapper.MemberMapper;
import com.myapp.vo.MemberVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemberController {
	@Autowired
	private MemberMapper member;
	
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public String Memberjoin() {
		return "member/join";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String Memberlogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
	public String Memberjoininsert() {
		return "member/insert";
	}
	//회원가입
	@RequestMapping(value = "/createmember", method = RequestMethod.POST)
	public String createmember(@ModelAttribute MemberVo membervo) {
		member.createmember(membervo);
		return "redirect:/";
	}
	//로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginmember(HttpSession session,@ModelAttribute MemberVo membervo){
		List<MemberVo> list = member.login(membervo);

		if(list.isEmpty()) {
			return "redirect:/member";
		}else {
			session.setAttribute("allid", membervo.getId());
			session.setAttribute("id", membervo.getId().split("@")[0]);
			return "redirect:/LoginHome";		
		}
	}
	
	
	@RequestMapping(value = "/member/delete", method = RequestMethod.GET)
	public String Memberjoindelete() {
		return "member/delete";
	}
	
	@RequestMapping(value = "/deletedo", method=RequestMethod.GET)
	public String Memberjoindeletedo(@RequestParam("button") String button,HttpSession session) {
		String id = (String)session.getAttribute("allid");
//		MemberVo member1 = new MemberVo();
//		member1.setId(id);
		if(button.equals("yes")) {
			member.deletemember(id);
			return "redirect:/";
		}
		return "redirect:/LoginHome";
	}

	
}
