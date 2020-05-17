package com.basicwebapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.basicwebapp.model.User;
import com.basicwebapp.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userDetailService;
	
	@Override
	public void configure(WebSecurity webS)throws Exception{
		webS.ignoring().antMatchers("/h2-console/**");
	}
	
	
	@Override
	protected void configure(HttpSecurity httpS)throws Exception{
		
		httpS.formLogin()
				.and()
				.logout()
				.permitAll()
				.and()
				.authorizeRequests()
				.antMatchers("/**")
				.hasRole("USER");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder authBuilder)throws Exception{
		
		authBuilder.authenticationProvider(authenticationProvider());
		
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider authProvider =new DaoAuthenticationProvider();
		authProvider.setPasswordEncoder(passwordEncoder());
		authProvider.setUserDetailsService(userDetailService);
		return authProvider;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public ApplicationRunner applicaitonRunner() {
		
		return args ->{
			userDetailService.create(new User(null, "Ganesha", passwordEncoder().encode("password"), 
		             "ROLE_USER"));
			userDetailService.create(new User(null, "Ganesh3", passwordEncoder().encode("password"), 
		             "ROLE_USER"));
		};
	}
}
