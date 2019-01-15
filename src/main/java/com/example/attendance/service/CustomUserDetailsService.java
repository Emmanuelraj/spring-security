package com.example.attendance.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.attendance.model.CustomUserDetails;
import com.example.attendance.model.Users;
import com.example.attendance.repository.UsersRepository;



@Service
public class CustomUserDetailsService implements UserDetailsService 
{

	
	
	@Autowired
	private UsersRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Users> optionalUsers = userRepository.findByName(username);
		
		
		
		
		optionalUsers.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		
		
		return optionalUsers.map(CustomUserDetails::new).get();	
		
		
		
	}

}
