package com.adi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adi.Models.Member;
import com.adi.Repository.MemberRepo;

@RestController
public class RestMemberController {

	//To Implement
	/*
	viewAllMembers
	viewMemberById
	updateMemberById
	deleteMemberById
	*/
	
	@Autowired
	MemberRepo memrepo;
	
	
	@GetMapping("/members")
	public List<Member> viewAllMembers() {
		
		List<Member> listmem= memrepo.findAll();
		return listmem;
	}
	
//	@PostMapping("/members")
//	public void addMember(Member member) {
//		
//		memrepo.save(member);
//		
//	}
	
	@GetMapping("members/{id}")
	public Member getMember(@PathVariable Integer id) {
		
		Member m= memrepo.findById(id).orElse(new Member());
		return m;
	}
	
}





