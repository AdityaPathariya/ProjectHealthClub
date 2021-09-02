package com.adi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.adi.Models.Member;
import com.adi.Repository.MemberRepo;

@Service
public class UpdateMemberService {

	@Autowired
	MemberRepo memberrepo;
	
	public ModelAndView updateMember(Member m,String email) {
		
		Member member= m;
		memberrepo.delete(memberrepo.findByEmail(email));
		try {
			
			member.setEmail(email);
			memberrepo.save(member); // email is unique. If duplicate is entered, exception will occur
		}
		catch(DataIntegrityViolationException e) {
			
			ModelAndView mvforexception = new ModelAndView("emailexception");
			mvforexception.addObject("memberobj",member);
			
			return mvforexception;
			
		}
		ModelAndView mv= new ModelAndView("updateResultsPage");
		mv.addObject("memberobj", member);
		return mv;
	}
}
