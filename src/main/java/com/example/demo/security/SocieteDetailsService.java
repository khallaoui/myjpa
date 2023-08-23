package com.example.demo.security;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SocieteRepository;

import com.example.demo.entities.Societe;

@Service
public class SocieteDetailsService implements UserDetailsService{
	@Autowired
	private SocieteRepository sociRep ;
		

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		  List<GrantedAuthority> authorities = new ArrayList<>();
		 	Societe societe = sociRep.findByLoginS(username);
		 	
		if (societe == null) {
            throw new UsernameNotFoundException(username);
        }
		
		//user.getRole().toString();
			SimpleGrantedAuthority sga = new SimpleGrantedAuthority(societe.getRole());	
			authorities.add(sga);
			//SocieteUserDetails s = new User(societe.getLoginS(), societe.getMotDePasse(),authorities);		
		return new SocieteUserDetails(societe);
	}

}
