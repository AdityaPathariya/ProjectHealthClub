package com.adi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.adi.Models.Admin;
import com.adi.Repository.AdminRepo;

@Service
public class UpdateAdminByIdService {

	@Autowired
	AdminRepo adminrepo;
	
	public ModelAndView updateAdmin(Integer id) {
		
		Admin admin= adminrepo.findById(id).orElse(new Admin());
		
		if(admin.getId() != null) {
			ModelAndView mv= new ModelAndView("updateAdminPage"); 
			mv.addObject("adminobj", admin);
			return mv;
		}
		
		ModelAndView mv= new ModelAndView("deleteexception"); // reuse no such record exists page
		return mv;
	}
}
