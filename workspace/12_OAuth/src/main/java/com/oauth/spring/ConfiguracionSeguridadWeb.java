package com.oauth.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ConfiguracionSeguridadWeb extends WebSecurityConfigurerAdapter {

	private static final Logger log = LoggerFactory.getLogger(ConfiguracionSeguridadWeb.class);
	
	@Override
	@Autowired // <-- This is crucial otherwise Spring Boot creates its own
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		log.info("Defining inMemoryAuthentication (2 users)");
		auth.inMemoryAuthentication()

				.withUser("user").password("password").roles("USER")

				.and()

				.withUser("admin").password("password").roles("USER", "TRUSTED_CLIENT");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()

				.and()
				
				.httpBasic().disable()
				.anonymous().disable()
				.csrf().disable()
				.authorizeRequests().anyRequest().authenticated();
	}
}