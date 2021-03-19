package com.iu.s1.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	}
	
	@RequestMapping (value="/bankBook/bankBookAdd" , method = RequestMethod.POST)
	public ModelAndView bankBookAdd(BankBookDTO bankBookDTO, ModelAndView modelAndView) throws Exception {
		modelAndView.setViewName("");
		return modelAndView;
	}
	
	//상품리스트
	@RequestMapping (value="/bankBook/bankBookList")
	public void bankBookList(Model model) throws Exception {
		List<BankBookDTO> ar = bankBookService.getList();
		model.addAttribute("list", ar);
		model.addAttribute("kind", "BankBook"); //테스트용도임
	}
	
	//상품 상세정보
	@RequestMapping (value="/bankBook/bankBookSelect")
	public ModelAndView bankBookSelect(BankBookDTO bankBookDTO, ModelAndView modelAndView) throws Exception {
		bankBookDTO = bankBookService.getSelect(bankBookDTO);
		modelAndView.addObject("dto", bankBookDTO);
		modelAndView.setViewName("/bankBook/bankBookSelect");
		return modelAndView;
	}
	
	//상품 수정 
	@RequestMapping (value="/bankBook/bankBookUpdate")
	public void bankBookUpdate() throws Exception {
	}
	
	@RequestMapping (value="/bankBook/bankBookUpdate" , method = RequestMethod.POST)
	public ModelAndView bankBookUpdate(BankBookDTO bankBookDTO, ModelAndView modelAndView) throws Exception {
		//modelAndView.addObject();
		modelAndView.setViewName("");
		return modelAndView;
	}
	
	//상품 삭제 
	@RequestMapping (value="/bankBook/bankBookDelete")
	public void bankBookDelete() throws Exception {
		System.out.println("상품삭제");
	}
	
}
