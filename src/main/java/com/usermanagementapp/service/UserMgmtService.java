package com.usermanagementapp.service;

import com.usermanagementapp.binding.LoginForm;
import com.usermanagementapp.binding.UnlockForm;
import com.usermanagementapp.binding.UserForm;

public interface UserMgmtService {
	
	public String Login(LoginForm loginForm);
	
	public String registerUser(UserForm userForm);
	
	public String unlockAccount(UnlockForm unlockForm);
	
	public String forgotPwd(String email);

}
