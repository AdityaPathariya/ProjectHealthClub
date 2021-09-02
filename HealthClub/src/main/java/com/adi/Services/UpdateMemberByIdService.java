package com.adi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.adi.Models.Member;
import com.adi.Repository.MemberRepo;

@Service
public class UpdateMemberByIdService {

	@Autowired
	MemberRepo memberrepo;
	
	public ModelAndView updateById(Integer id) {
		
		Member member= memberrepo.findById(id).orElse(new Member());
		
		if(member.getId() != null) {
			ModelAndView mv= new ModelAndView("updateMemberPage");
			mv.addObject("memberobj", member);
			return mv;
		}
		
		ModelAndView mv= new ModelAndView("deleteexception"); // reuse no such record exists page
		return mv;
	}
}
