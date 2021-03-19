package com.iu.s1.member;

import java.io.Reader;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService; 
	
	//memberJoin get
	@RequestMapping (value = "/member/memberJoin", method = RequestMethod.GET)
	public String memberJoin() {
		System.out.println("MemberJoin");
		return "member/memberJoin";
	}
	
	//memberJoin2 post 결과 print
	@RequestMapping (value = "/member/memberJoin" , method = RequestMethod.POST)
	public void memberJoin2(MemberDTO memberDTO) throws Exception {

		int result = memberService.memberJoin(memberDTO);	
		System.out.println(result);		
	}
	
	//memberLogin print로 확인 
	@RequestMapping (value = "/member/memberLogin")
	public String memberLogin () {
		/* String이 대신 해주기때문에 선언 따로 안하고 위의 매개변수안에 String name, int age로 선언해줌
		 * String name = request.getParameter("name"); 
		 * int age = Integer.parseInt(request.getParameter("age"));
		 */
		/*
		 * System.out.println(name); 
		 * System.out.println(age);
		 */
		
		System.out.println("MemberLogin");
		return "member/memberLogin";
	}
	
	
	@RequestMapping (value = "/member/memberLogin" , method=RequestMethod.POST)
	public String memberLogin2 (HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");  //파라미터 받을때는 무조건 string
		String pw = request.getParameter("pw");
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPw(pw);		
		memberDTO = memberService.memberLogin(memberDTO);
		
		System.out.println(memberDTO);
		request.setAttribute("dto", memberDTO);
		return "member/memberPage";  //로그인 성공시 memberPage로 이동
	}
}
