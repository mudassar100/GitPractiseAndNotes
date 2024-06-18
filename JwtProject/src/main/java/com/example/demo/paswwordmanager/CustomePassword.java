package com.example.demo.paswwordmanager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.Repo.CustomerRepo;
import com.example.demo.entity.CustomerEntity;

@Component
public class CustomePassword implements UserDetailsService {

	@Autowired
	CustomerRepo CustomerRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String userName;
		String password;
		
		List<GrantedAuthority> authorities = null;
		List<CustomerEntity> findByEmail = CustomerRepo.findByEmail(username);
		if(findByEmail.get(0)== null)
		{
			throw new UsernameNotFoundException("No details found!!!!");
		}
		else
		{
			userName =findByEmail.get(0).getEmail();
			password =findByEmail.get(0).getPwd();
			authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(findByEmail.get(0).getRole()));
		}
		return new User(userName,password,authorities);
	}

}
