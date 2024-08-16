
package com.example.doorship.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.doorship.entity.signup;

public interface signuprepo extends JpaRepository<signup, Long> {
 

	  signup findByUsername(String username);
}