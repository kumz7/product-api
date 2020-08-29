package com.product.aspect;

import javax.activity.InvalidActivityException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
//
//@Component
//@Aspect
public class AdminCheck {
	
//	@Before("execution(* com.product.serviceimpl.StoreMapServiceImpl.*(..))") 
//	public boolean isAdmin() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
//		String role = authentication.getAuthorities().toArray()[0].toString();
//		return role.equals("ROLE_ADMIN");
//	} 
}
