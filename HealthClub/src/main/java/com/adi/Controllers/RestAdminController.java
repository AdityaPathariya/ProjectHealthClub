package com.adi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.adi.Models.Admin;
import com.adi.Repository.AdminRepo;

@RestController
public class RestAdminController {

	//To Implement
	/*
	viewAllAdmins
	viewAdminById
	updateAdminById
	deleteAdminById
	*/
	
	@Autowired
	AdminRepo adminrepo;
	
	@GetMapping("/admins")
	public List<Admin> viewAllAdmins() {
		
		List<Admin> listadmins= adminrepo.findAll();
		return listadmins;
	}
	
	@GetMapping("admins/{id}")
	public Admin getAdmin(@PathVariable Integer id) {
		
		Admin a= adminrepo.findById(id).orElse(new Admin());
		return a;
	}
	
}
