package com.adi.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.adi.Models.Admin;
import com.adi.Repository.AdminRepo;

@Service
public class ViewAdminsService {

	@Autowired
	AdminRepo adminrepo;
	
	public ModelAndView viewAdmins() {
		
		List<Admin> listadmin= new ArrayList<Admin>();
		listadmin=  adminrepo.findAll();
		
		ModelAndView mv= new ModelAndView("adminrecords");
		mv.addObject("listadmin", listadmin);
		
		return mv;
	}
}
