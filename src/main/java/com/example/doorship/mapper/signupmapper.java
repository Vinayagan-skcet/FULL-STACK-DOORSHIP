package com.example.doorship.mapper;

import com.example.doorship.dto.signupdto;
import com.example.doorship.entity.signup;
	
public class signupmapper{

	    public static signupdto mapToSignupdto(signup signup){
	        return new signupdto(
	                signup.getId(),
	                signup.getUsername(),
	                signup.getEmail(),
	                signup.getPassword(),
	                signup.getConfirmpassword()
	                
	        );
	    }

	    public static signup mapToSignup(signupdto signupDto){
	        return new signup(
	        		 signupDto.getId(),
		             signupDto.getUsername(),
		             signupDto.getEmail(),
		             signupDto.getPassword(),
		             signupDto.getConfirmpassword()
	               
	        );
	    }
	}
	

	
	
	

