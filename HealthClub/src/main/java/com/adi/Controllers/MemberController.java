package com.adi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.adi.Models.Member;
import com.adi.Repository.MemberRepo;
import com.adi.Services.LoginService;
import com.adi.Services.RegisterService;
import com.adi.Services.UpdateService;

@Controller
public class MemberController {
	
	@Autowired
	MemberRepo memrepo;
	
	@Autowired
	LoginService ls;
	@Autowired
	RegisterService rs;
	@Autowired
	UpdateService us;
	

	@RequestMapping("/")
	public String defaultpage() {
		
		return "index";
	}
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam String email, Long password) {
		
		ModelAndView mv= ls.login(email,password);
		
		return mv;
	}
	
	@PostMapping("/register")
	public ModelAndView register(Member m) {
		
		ModelAndView mv= rs.register(m);
		
		return mv;
	}
	
	@PostMapping("/update")
	public ModelAndView update(Member m, @RequestParam("email") String email) {
		
		ModelAndView mv= us.update(m,email);
		
		return mv;
	}
	
}
