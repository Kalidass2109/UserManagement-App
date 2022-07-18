package com.usermanagementapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagementapp.binding.UnlockForm;
import com.usermanagementapp.service.UserMgmtService;

@RestController
public class UnlockRestController {

	@Autowired
	private UserMgmtService service;
	
	@PostMapping("/unlock")
	public String unlockAcc(@RequestBody UnlockForm form) {
		return service.unlockAccount(form);
	}
}
