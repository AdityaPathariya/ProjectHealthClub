package com.adi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.adi.Models.Member;
import com.adi.Repository.MemberRepo;

@Service
public class UpdateService {

	@Autowired
	MemberRepo memrepo;
	
	public ModelAndView update(Member m, String email) {
		
		Member member= m;
		memrepo.delete(memrepo.findByEmail(email));
		try {
			
			member.setEmail(email);
			memrepo.save(member); // email is unique. If duplicate is entered, exception will occur
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
