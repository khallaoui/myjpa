package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
@Entity
public class Societe {
	@Id // clé primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private int id;
	@NotBlank(message ="Entrez le nom de votre societé !!!") // libelle n'accepte pas la valeur null. Le vide
	@Column(length = 50) // changer le nom d'une colonne
	private String noms;
	
	@NotBlank(message ="Champ adresse est null !!!") // libelle n'accepte pas la valeur null. Le vide
	@Column(length = 60) // changer le nom d'une colonne
	private String adresse;
	
	@Column(length = 10)
	private int numtele;
	@NotBlank(message ="Entrez une login !!!") private String loginS;
	  
	  @NotBlank(message ="Entrez une mot  de passe !!!")
	  

	  private String motDePasse;
	  private String Role;
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNoms() {
		return noms;
	}
	public void setNoms(String noms) {
		this.noms = noms;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getNumtele() {
		return numtele;
	}
	public void setNumtele(int numtele) {
		this.numtele = numtele;
	}
	
	
	public String getLoginS() {
		return loginS;
	}
	public void setLoginS(String loginS) {
		this.loginS = loginS;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public Societe() {
		super();
	}
	public Societe(@NotBlank(message = "Entrez le nom de votre societé !!!") String noms,
			@NotBlank(message = "Champ adresse est null !!!") String adresse, int numtele,
			@NotBlank(message = "Entrez une login pour vous !!!") String loginS,
			@NotBlank(message = "Entrez une mot  de passe pour vous !!!") String motDePasse) {
		super();
		this.noms = noms;
		this.adresse = adresse;
		this.numtele = numtele;
		this.loginS = loginS;
		this.motDePasse = motDePasse;
	}
	
}
