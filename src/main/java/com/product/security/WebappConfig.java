package com.product.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class WebappConfig extends WebSecurityConfigurerAdapter {
	   @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http .headers().frameOptions().disable().and().csrf().disable().authorizeRequests()
	                .anyRequest().authenticated()
	                .and()
	                .formLogin() .and()
	                .httpBasic().and()
	                .logout().clearAuthentication(true).logoutUrl("/logout")
	                .invalidateHttpSession(true)
	                .deleteCookies("JSESSIONID");
	   }
	 @Override
	    @Bean
	    public UserDetailsService userDetailsService() {
	        List<UserDetails> users= new ArrayList<UserDetails>();
	        users.add(User.withUsername("admin").password("{noop}MSR@Dm!&").roles("ADMIN").build()); 
	        users.add(User.withUsername("worker").password("{noop}w0rk#&").roles("USER").build()); 
	        return new InMemoryUserDetailsManager(users);
	    }
}
