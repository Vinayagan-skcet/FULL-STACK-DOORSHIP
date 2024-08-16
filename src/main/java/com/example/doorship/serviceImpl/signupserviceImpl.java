package com.example.doorship.serviceImpl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.doorship.dto.LoginDto;
import com.example.doorship.dto.signupdto;
import com.example.doorship.entity.signup;
import com.example.doorship.exception.ResourceNotFoundException;
import com.example.doorship.mapper.signupmapper;
import com.example.doorship.repository.signuprepo;
import com.example.doorship.service.signupservice;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class signupserviceImpl implements signupservice {
	
	
			@Autowired
		    private signuprepo signuprepo;

		    @Override
		    public signupdto createSignup(signupdto signupdto) {

		        signup signup = signupmapper.mapToSignup(signupdto);
		        signup savedsignup = signuprepo.save(signup);
		        return signupmapper.mapToSignupdto(savedsignup);
		    }
		    
		    
		    @Override
		    public signupdto getSignupById(Long SignupId) {
		        signup auth = signuprepo.findById(SignupId)
		                .orElseThrow(() ->
		                        new ResourceNotFoundException("Employee is not exists with given id : " + SignupId));

		        return signupmapper.mapToSignupdto(auth);
		    }

		    @Override
		    public List<signupdto> getAllSignup() {
		        List<signup> auths = signuprepo.findAll();
		        return auths.stream().map((auth) -> signupmapper.mapToSignupdto(auth))
		                .collect(Collectors.toList());
		    }

		    @Override
		    public signupdto updateSignup(Long SignupId, signupdto updatedSignup) {

		        signup auth = signuprepo.findById(SignupId).orElseThrow(
		                () -> new ResourceNotFoundException("Signup id: " + SignupId)
		        );
		        auth.setUsername(updatedSignup.getUsername());
		        auth.setEmail(updatedSignup.getEmail());
		        auth.setPassword(updatedSignup.getPassword());
		        auth.setConfirmpassword(updatedSignup.getConfirmpassword());
		        

	        signup updatedsignupObj = signuprepo.save(auth);

		        return signupmapper.mapToSignupdto(updatedsignupObj);
		    }

		    @Override
		    public void deleteSignup(Long SignupId) {

		        signup auth = signuprepo.findById(SignupId).orElseThrow(
		                () -> new ResourceNotFoundException("Siggnup id: " +SignupId)
		        );

		        signuprepo.deleteById(SignupId);
		    }


			 @Override
		        public signup authenticateUser(LoginDto loginDto) {
		            // Find the user by mobile number
		            signup user = signuprepo.findByUsername(loginDto.getUsername());
		            System.out.println(loginDto.getUsername());
		            if (user != null && user.getPassword().equals(loginDto.getPassword())) {
		                return user; // Authentication successful
		            }
		            return null; // Authentication failed
		        }
}