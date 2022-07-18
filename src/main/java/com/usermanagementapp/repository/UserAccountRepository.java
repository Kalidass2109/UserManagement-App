package com.usermanagementapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermanagementapp.entity.UserAccountEntity;

public interface UserAccountRepository extends JpaRepository<UserAccountEntity, Integer>{
	
	public UserAccountEntity findByEmailAndPassword(String email,String pwd);
	
	public UserAccountEntity findByEmail(String email);
}
