package com.example.doorship.service;

import java.util.List;

import com.example.doorship.dto.LoginDto;
import com.example.doorship.dto.signupdto;
import com.example.doorship.entity.signup;

public interface signupservice {
	
	
	    public signupdto createSignup(signupdto SignupDto);

	    signupdto getSignupById(Long SignupId);

	    List<signupdto> getAllSignup();

	   signupdto updateSignup(Long SignupId, signupdto updatedSignup);

	    void deleteSignup(Long SignupId);
	    
	    public signup authenticateUser(LoginDto loginDto);


}
		


		
	