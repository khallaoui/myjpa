package com.example.demo.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.entities.AppUser;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UserRepository userRepo;
		

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		  List<GrantedAuthority> authorities = new ArrayList<>();
		 	AppUser user = userRepo.findByLogin(username);
		 	
		if (user == null) {
            throw new UsernameNotFoundException(username);
        }
		
		//user.getRole().toString();
			SimpleGrantedAuthority sga = new SimpleGrantedAuthority(user.getRole());	
			authorities.add(sga);
		User u = new User(user.getLogin(), user.getMotDePasse(),authorities);	
		
		return u;
	}
}
