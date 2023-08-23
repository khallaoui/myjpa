package com.example.demo.metier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.AppRole;
import com.example.demo.entities.AppUser;

@Service
public class SecuriteService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RoleRepository roleRepo;

	public void addUser(AppUser u) {
		u.setMotDePasse(passwordEncoder.encode(u.getMotDePasse()));
		userRepo.save(u);
	}

	  public void addRole(AppUser u) { userRepo.save(u); }

	 
	/*
	 * public void addRole(AppRole r) { roleRepo.save(r); }
	 */
	/*
	 * public boolean addRoleToUser(AppRole r, AppUser u) { List<AppRole> roles_u =
	 * u.getRoles(); AppUser roles_u = u.getRole(); if(roles_u.contains(r)) return
	 * false; //throw new RuntimeException("Le role existe déjà !!!!");
	 * 
	 * roles_u.add(r); userRepo.save(u); return true; }
	 */
	/*
	 * public boolean removeRoleFormUser(AppRole r, AppUser u) { List<AppRole>
	 * roles_u = u.getRoles(); if (!roles_u.isEmpty()) { if (roles_u.contains(r)) {
	 * roles_u.remove(r); userRepo.save(u); return true; } } return false; }
	 */

	
	
}
