package com.adi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.adi.Repository.MemberRepo;

@Service
public class LoginService {
	
	@Autowired
	MemberRepo memrepo;

	public ModelAndView login(String email, Long password) {
		
		if(email != null && password != null) {
			
			try {
				if((memrepo.findByEmail(email).getEmail()).equals(email) && (memrepo.findByPassword(password).getPassword()).equals(password)) {
					ModelAndView mv= new ModelAndView("loginsuccess");
					mv.addObject("memberobj", memrepo.findByEmail(email)); // See explanation in catch block
					return mv;
					// If found same password for multiple people, result size will be more than one,
					// so we must catch that exception.
				}
			}
			catch(IncorrectResultSizeDataAccessException e) {

				ModelAndView mv= new ModelAndView("loginsuccess");
				mv.addObject("memberobj", memrepo.findByEmail(email));
				// we don't want multiple records to go in memberobj. It will give parsing error.
				// we only want one record with that unique email to go in the object.
				return mv;
			}
			catch(NullPointerException e) { // this will occur if user not registered or incorrect email & password
				ModelAndView mv= new ModelAndView("loginexception");
				return mv;
			}
			
		}
		ModelAndView mv= new ModelAndView("loginexception");
		return mv;
	}
}
