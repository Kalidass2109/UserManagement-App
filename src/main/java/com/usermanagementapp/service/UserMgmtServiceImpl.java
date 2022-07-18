package com.usermanagementapp.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanagementapp.binding.LoginForm;
import com.usermanagementapp.binding.UnlockForm;
import com.usermanagementapp.binding.UserForm;
import com.usermanagementapp.entity.UserAccountEntity;
import com.usermanagementapp.repository.UserAccountRepository;
import com.usermanagementapp.util.EmailUtils;

@Service
public class UserMgmtServiceImpl implements UserMgmtService{
	
	@Autowired
	private UserAccountRepository userRepo;
	
	@Autowired
	private EmailUtils emailUtil;
	
	@Override
	public String Login(LoginForm loginForm) {
		UserAccountEntity entity=userRepo.findByEmailAndPassword(loginForm.getEmail(), loginForm.getPwd());
		
		if(entity==null) {
			return "Invalid Credentials";
		}
		
		if(entity!=null && entity.getAccStatus().equals("LOCKED")) {
			return "Account Locked";
		}
		return "SUCCESS";
	}
	
	@Override
	public String registerUser(UserForm userForm) {
		UserAccountEntity userAcc=new UserAccountEntity();
		
		BeanUtils.copyProperties(userForm, userAcc);
		
		userAcc.setAccStatus("LOCKED");
		
		userAcc.setPassword(generateRandomPwd());
		
		userRepo.save(userAcc);
		
		String email=userForm.getEmail();
		String subject="User Registration Aitacs";
		String fileName="UNLOCK-ACC-EMIAL-BODY.txt";
		
		String body=readMailBodyContent(fileName,userAcc);
		
		boolean isSend=emailUtil.sendMail(email, subject, body);
		if(isSend) {
			return "SUCCESS";
		}
		return "FAIL";
	}

	private String readMailBodyContent(String fileName, UserAccountEntity userAcc) {
		String mailBody=null;
		
		
		try {
			StringBuffer sb=new StringBuffer();
			FileReader reader=new FileReader(fileName);
			BufferedReader br=new BufferedReader(reader);
			
			String readLine=br.readLine();
			
			while(readLine!=null) {
				sb.append(readLine);
				readLine=br.readLine();
			}
			mailBody=sb.toString();
			
			mailBody=mailBody.replace("{FNAME}", userAcc.getFname());
			mailBody=mailBody.replace("{LNAME}", userAcc.getLname());
			mailBody=mailBody.replace("{PWD}", userAcc.getPassword());
			mailBody=mailBody.replace("{EMAIL}", userAcc.getEmail());
			
			br.close();
			
			} catch (IOException e) {
			e.printStackTrace();
		}
		
		return mailBody;
	}

	private String generateRandomPwd() {
		int leftLimit = 48;
		int rightLimit = 122;
		int targetLimit = 6;

		Random random = new Random();

		String genratedString = random.ints(leftLimit, rightLimit + 1)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetLimit)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		return genratedString;
	}

	@Override
	public String unlockAccount(UnlockForm unlockForm) {
		if(!(unlockForm.getNewPwd().equals(unlockForm.getConfirmnewPwd()))) {
			return "New Password And confirm Password should be same";
		}
		UserAccountEntity entity=userRepo.findByEmailAndPassword(unlockForm.getEmail(), unlockForm.getTempPwd());
		
		if(entity==null) {
			return "Invalid Tempory Password";
		}
		
		entity.setPassword(unlockForm.getNewPwd());
		entity.setAccStatus("UNLOCKED");
		
		userRepo.save(entity);
		
		return "Account Unlocked";
	}

	@Override
	public String forgotPwd(String email) {
		UserAccountEntity entity=userRepo.findByEmail(email);
		
		if(entity==null) {
			return "Invalid Email Id";
		}
		String fileName="RECOVER-PWD-EMAIL-BODY.txt";
		String body=readMailBodyContent(fileName, entity);
		System.out.println("**************: "+body);
		String subject="Recover Password- Aitacs";
		
		boolean isSent=emailUtil.sendMail(email, subject, body);
		
		if(isSent) {
			return "Password Sent To Registered Mail";
		}
		return "Fail";
	}

	

}
