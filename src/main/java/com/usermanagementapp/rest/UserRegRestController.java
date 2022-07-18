package com.usermanagementapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagementapp.binding.UserForm;
import com.usermanagementapp.service.UserMgmtService;

@RestController
public class UserRegRestController {
	
	@Autowired
	private UserMgmtService service;
	
	@PostMapping("/user")
	public String userReg(@RequestBody UserForm userForm) {
		return service.registerUser(userForm);
	}

}
