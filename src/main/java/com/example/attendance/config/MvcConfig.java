package com.example.attendance.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.attendance.repository.UsersRepository;







@EnableGlobalMethodSecurity(prePostEnabled= true)
@EnableJpaRepositories(basePackageClasses=UsersRepository.class)
@Configuration
@EnableWebSecurity
public class MvcConfig extends WebSecurityConfigurerAdapter
{
	
	
	
	
	//This interface provided by Spring Security
	@Autowired
	private UserDetailsService userDetailService;
	
	/**
	 **/  
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		
		auth.userDetailsService(userDetailService)
		.passwordEncoder(getPassword());
		
	}

	private PasswordEncoder getPassword() {
		return new PasswordEncoder() {
			
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public String encode(CharSequence rawPassword) {
				// TODO Auto-generated method stub
				return rawPassword.toString();
			}
		};
	}
	
	
	//@Override
	/**
	 * 
	 */
	protected void configure(HttpSecurity http) throws Exception 
	{
		
		   http.csrf().disable();
		   http.authorizeRequests()
		     .antMatchers("/secured/**").authenticated()
		     .anyRequest().permitAll()
		     .and().formLogin().permitAll();
		   
	}


}
