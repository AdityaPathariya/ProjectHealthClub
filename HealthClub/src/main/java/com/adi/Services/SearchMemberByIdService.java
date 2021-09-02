package com.adi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.adi.Models.Member;
import com.adi.Repository.MemberRepo;

@Service
public class SearchMemberByIdService {

	@Autowired
	MemberRepo memberrepo;

	public ModelAndView searchById(Integer id) {
		
		Member member= memberrepo.findById(id).orElse(new Member());
		
		ModelAndView mv= new ModelAndView("searchResultsId");
		mv.addObject("idsearchobj",member);
		return mv;
	}
	
	
}
