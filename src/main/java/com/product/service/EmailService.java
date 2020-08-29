package com.product.service;

public interface EmailService {
	public boolean sentEmail(String host,String port,boolean auth, boolean tlsEnable, String from,String password, String to, String sub,String msg) ;
}
