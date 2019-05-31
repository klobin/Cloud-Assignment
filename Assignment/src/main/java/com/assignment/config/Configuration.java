package com.assignment.config;

import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@org.springframework.context.annotation.Configuration
public class Configuration extends WebSecurityConfigurerAdapter {


	private static final String[] AUTH_WHITELIST = {
	        "/swagger-resources/**",
	        "/swagger-ui.html",
	        "/v2/api-docs",
	        "/webjars/**"
	};

	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers(AUTH_WHITELIST);
	}
}
