package com.iu.s1.bankBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	//상품등록
	@RequestMapping (value="/bankBook/bankBookAdd")
	public void bankBookAdd() throws Exception {
		System.out.println("상품등록");
	}
	
	@RequestMapping (value="/bankBook/bankBookAdd" , method = RequestMethod.POST)
	public ModelAndView bankBookAdd(BankBookDTO bankBookDTO, ModelAndView modelAndView) throws Exception {
		return modelAndView;
	}
	
	//상품리스트
	@RequestMapping (value="/bankBook/bankBookList")
	public void bankBookList() throws Exception {
		System.out.println("상품리스트");
	}
	
	//상품 상세정보
	@RequestMapping (value="/bankBook/bankBookSelect")
	public void bankBookSelect() throws Exception {
		System.out.println("상품상세정보");
	}
	
	//상품 수정 
	@RequestMapping (value="/bankBook/bankBookUpdate")
	public void bankBookUpdate() throws Exception {
		System.out.println("상품리스트");
	}
	
	@RequestMapping (value="/bankBook/bankBookUpdate" , method = RequestMethod.POST)
	public ModelAndView bankBookUpdate(BankBookDTO bankBookDTO, ModelAndView modelAndView) throws Exception {
		//modelAndView.addObject();
		modelAndView.setViewName("bankBook/bankBookList");
		return modelAndView;
	}
	
	//상품 삭제 
	@RequestMapping (value="/bankBook/bankBookDelete")
	public void bankBookDelete() {
		System.out.println("상품삭제");
	}
	
}
