package com.adi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.adi.Models.Admin;
import com.adi.Repository.AdminRepo;

@Service
public class AdminRegisterService {

	@Autowired
	AdminRepo adminrepo;
	
	public ModelAndView register(Admin ad) {
		
		Admin admin= ad;
		
		try {
			adminrepo.save(admin); // email is unique. If duplicate is entered, exception will occur
		}
		catch(DataIntegrityViolationException e) {
			
			ModelAndView mvforexception = new ModelAndView("emailexception");
			mvforexception.addObject("memberobj",admin); //used memberobj instead of adminobj to reuse emailexception page
			
			return mvforexception;
			
		}
		
		ModelAndView mv= new ModelAndView("regsuccessadmin");
		mv.addObject("adminobj",admin);
		
		return mv;
	}
}
