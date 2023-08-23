package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;


@Entity
public class AppUser {
	@Id
	/* 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
	 */
	@Column(length = 80)
	private String login;	
	private String motDePasse;
	
	private String role;
	//@Enumerated(EnumType.STRING)private Role role;
	
	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "Role", referencedColumnName = "id") private AppRole role;
	 */
	 
	
	
	/*
	 * @ManyToMany(fetch = FetchType.EAGER) private List<AppRole> roles = new
	 * ArrayList<>();
	 * 
	 * public List<AppRole> getRoles() { return roles; } public void
	 * setRoles(List<AppRole> roles) { this.roles = roles; }
	 */
	public AppUser() {
	}
	/*
	 * public AppUser(String login, String motDePasse) { this.login = login;
	 * this.motDePasse = motDePasse; }
	 */

	public AppUser(String login, String motDePasse, String role) {
		super();
		this.login = login;
		this.motDePasse = motDePasse;
		this.role = role;
	}

	
	/*
	 * public Role getRole() { return role; }
	 * 
	 * public void setRole(Role role) { this.role = role; }
	 */
	/*
	 * public int getId() { return id; } public void setId(int id) { this.id = id; }
	 */
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
