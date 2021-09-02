package com.adi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.adi.Models.Admin;
import com.adi.Repository.AdminRepo;

@Service
public class UpdateAdminService {

	@Autowired
	AdminRepo adminrepo;
	
	public ModelAndView updateAdmin(Admin m, @RequestParam("email") String email) {
		
		Admin admin= m;
		adminrepo.delete(adminrepo.findByEmail(email));
		try {
			
			admin.setEmail(email);
			adminrepo.save(admin); // email is unique. If duplicate is entered, exception will occur
		}
		catch(DataIntegrityViolationException e) {
			
			ModelAndView mvforexception = new ModelAndView("emailexception");
			mvforexception.addObject("adminobj",admin);
			
			return mvforexception;
			
		}
		ModelAndView mv= new ModelAndView("updateResultsPage");
		mv.addObject("memberobj", admin); // used memberobj instead of adminobj to reuse updateResultsPage
		return mv;
	}
}
