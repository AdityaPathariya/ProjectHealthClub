package com.adi.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.adi.Models.Member;
import com.adi.Repository.MemberRepo;

@Service
public class SearchMembersByNameService {

	@Autowired
	MemberRepo memberrepo;
	
	public ModelAndView searchByName(String name) {
		
		List<Member> listMembers= new ArrayList<Member>();
		listMembers= memberrepo.findAll();
		
		List<Member> resultList= new ArrayList<Member>();
		for(Member element: listMembers) {
			if(element.getName().equals(name)) {
				resultList.add(element);
			}
		}
		
		ModelAndView mv= new ModelAndView("searchResultsName");
		mv.addObject("namelistobj", resultList);
		return mv;
	}
}
