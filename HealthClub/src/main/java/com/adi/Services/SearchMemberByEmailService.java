package com.adi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.adi.Models.Member;
import com.adi.Repository.MemberRepo;

@Service
public class SearchMemberByEmailService {

	@Autowired
	MemberRepo memberrepo;

	public ModelAndView searchByEmail(String email) {
		
		Member member= memberrepo.findByEmail(email);

		ModelAndView mv= new ModelAndView("searchResultsEmail");
		mv.addObject("emailsearchobj",member);
		
		return mv;
	}
	
}
