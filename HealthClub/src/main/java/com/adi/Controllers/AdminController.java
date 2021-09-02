package com.adi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.adi.Models.Admin;
import com.adi.Models.Member;
import com.adi.Repository.AdminRepo;
import com.adi.Repository.MemberRepo;
import com.adi.Services.AdminLoginService;
import com.adi.Services.AdminRegisterService;
import com.adi.Services.DeleteMemberByIdService;
import com.adi.Services.LoginService;
import com.adi.Services.RegisterService;
import com.adi.Services.SearchMemberByEmailService;
import com.adi.Services.SearchMemberByIdService;
import com.adi.Services.SearchMembersByNameService;
import com.adi.Services.UpdateAdminByIdService;
import com.adi.Services.UpdateAdminService;
import com.adi.Services.UpdateMemberByIdService;
import com.adi.Services.UpdateMemberService;
import com.adi.Services.UpdateService;
import com.adi.Services.ViewAdminsService;
import com.adi.Services.ViewMembersService;

@Controller
public class AdminController {

	@Autowired
	AdminRepo adminrepo;
	@Autowired
	MemberRepo memberrepo;
	
	
	@Autowired
	AdminLoginService als;
	@Autowired
	AdminRegisterService ars;
	@Autowired
	DeleteMemberByIdService dmbis;
	@Autowired
	SearchMemberByEmailService smbes;
	@Autowired
	SearchMemberByIdService smbis;
	@Autowired
	SearchMembersByNameService smbns;
	@Autowired
	UpdateAdminByIdService uabis;
	@Autowired
	UpdateAdminService uas;
	@Autowired
	UpdateMemberByIdService umbis;
	@Autowired
	UpdateMemberService ums;
	@Autowired
	ViewAdminsService vas;
	@Autowired
	ViewMembersService vms;
	
	
	
	@RequestMapping("/adminindex")
	public String defaultpage() {
		
		return "adminindex";
	}
	
	@RequestMapping("/adminlogin")
	public ModelAndView adminLogin(@RequestParam String email, Long password) {		
		
		ModelAndView mv= als.login(email,password);	
		
		return mv;
	}
	
	@PostMapping("/adminregister")
	public ModelAndView register(Admin a) {
		
		ModelAndView mv= ars.register(a);
		
		return mv;
	}
	
	@GetMapping("/updateMemberById")
	public ModelAndView updateMemberById(@RequestParam Integer id) {
		
		ModelAndView mv= umbis.updateById(id);
		
		return mv;
	}
	
	@PostMapping("/updateMember")
	public ModelAndView updateMember(Member m, @RequestParam("email") String email) {
		
		ModelAndView mv= ums.updateMember(m,email);
		
		return mv;
	}
	
	@GetMapping("/updateAdminById")
	public ModelAndView updateAdminById(@RequestParam Integer id) {
		
		ModelAndView mv= uabis.updateAdmin(id);
		
		return mv;
	}
	
	@PostMapping("/updateAdmin")
	public ModelAndView updateAdmin(Admin a, @RequestParam("email") String email) {
		
		ModelAndView mv= uas.updateAdmin(a,email);
		
		return mv;
	}
	
	@RequestMapping("/adminactions")
	public String adminactions() {
		
		return "adminactionspage";
	}
	
	@GetMapping("/viewadmins")
	public ModelAndView viewAdmins() {
		
		ModelAndView mv= vas.viewAdmins();
		
		return mv;
	}
	
	@GetMapping("/viewmembers")
	public ModelAndView viewMembers() {
		
		ModelAndView mv= vms.viewMembers();
		
		return mv;
	}

	@GetMapping("/searchMembersByName")
	public ModelAndView searchMembersByName(@RequestParam String name) {
		
		ModelAndView mv= smbns.searchByName(name);
		
		return mv;
	}
	
	@GetMapping("/searchMemberById")
	public ModelAndView searchMemberById(@RequestParam Integer id) {
		
		ModelAndView mv= smbis.searchById(id);
		
		return mv;
	}
	
	@GetMapping("/searchMemberByEmail")
	public ModelAndView searchMemberByEmail(@RequestParam String email) {
		
		ModelAndView mv= smbes.searchByEmail(email);
		
		return mv;
	}
	
	@GetMapping("/deleteMemberById")
	public ModelAndView deleteMemberById(@RequestParam Integer id) {
		
		ModelAndView mv= dmbis.deleteById(id);
		return mv;
	}
}
