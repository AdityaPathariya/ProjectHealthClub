package com.adi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.adi.Models.Member;
import com.adi.Repository.MemberRepo;

@Service
public class DeleteMemberByIdService {

	@Autowired
	MemberRepo memberrepo;

	public ModelAndView deleteById(Integer id) {
		
		Member member= memberrepo.findById(id).orElse(new Member());
		
		if(member.getId() != null) {
			ModelAndView mv= new ModelAndView("deleteResultsId");
			memberrepo.delete(member);
			return mv;
		}
		
		ModelAndView mv= new ModelAndView("deleteexception");
		return mv;
	}
	
	
}
