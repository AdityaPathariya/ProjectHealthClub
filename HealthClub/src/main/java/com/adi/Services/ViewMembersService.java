package com.adi.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.adi.Models.Member;
import com.adi.Repository.MemberRepo;

@Service
public class ViewMembersService {

	@Autowired
	MemberRepo memberrepo;
	
	public ModelAndView viewMembers() {
		
		List<Member> listmember= new ArrayList<Member>();
		listmember=  memberrepo.findAll();
		
		ModelAndView mv= new ModelAndView("memberrecords");
		mv.addObject("listmember", listmember);
		
		return mv;
	}
}
