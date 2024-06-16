package com.example.demo.paswwordmanager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class PasswordConfig  {
	

    @Bean
    public UserDetailsService userDetailsService() {
    	//Create  a in memoery manager
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        //Create a user
        manager.createUser(User.withUsername("test")
                              .password(passwordEncoder().encode("test"))
                              .roles("USER")
                              .build());
        
        System.out.println("Encrypted password is {}"+ passwordEncoder().encode("password"));
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
   
	
	
}
