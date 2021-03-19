package com.iu.s1.member;

import java.io.Reader;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService; 
	
	//memberJoin get
	@RequestMapping (value = "/member/memberJoin")
	public void memberJoin() {
		//return "member/memberJoin";
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
		 * System.out.println(name); 
		 * System.out.println(age);
		 */
		
		System.out.println("MemberLogin");
		return "member/memberLogin";
	}
	
	
	@RequestMapping (value = "/member/memberLogin" , method=RequestMethod.POST)
	public ModelAndView memberLogin2 (MemberDTO memberDTO, ModelAndView modelAndView) throws Exception {//model은 request와 같은 역할(데이터 운반)		
		memberDTO = memberService.memberLogin(memberDTO);
		modelAndView.addObject("dto", memberDTO); //불러올 데이터 
		modelAndView.setViewName("member/memberPage"); //이동할 경로작성
		
		return modelAndView; 
	}
}
