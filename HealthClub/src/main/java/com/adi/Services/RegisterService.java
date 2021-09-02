package com.adi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.adi.Models.Member;
import com.adi.Repository.MemberRepo;

@Service
public class RegisterService {

	@Autowired
	MemberRepo memrepo;
	
	public ModelAndView register(Member m) {
		
		Member member= m;
		
		try {
			memrepo.save(member); // email is unique. If duplicate is entered, exception will occur
		}
		catch(DataIntegrityViolationException e) {
			
			ModelAndView mvforexception = new ModelAndView("emailexception");
			mvforexception.addObject("memberobj",member);
			
			return mvforexception;
			
		}
		
		ModelAndView mv= new ModelAndView("regsuccess");
		mv.addObject("memberobj",member);
		
		return mv;
	}
}
