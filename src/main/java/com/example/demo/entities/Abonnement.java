package com.example.demo.entities;

import org.hibernate.validator.constraints.UniqueElements;

import groovy.transform.ToString;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="abonnements")
@ToString
public class Abonnement {
	
	@Id // clé primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private int id;
	@NotNull(message ="Champ Duree null !!!") // libelle n'accepte pas la valeur null. Le vide
	@Column(length = 50) // changer le nom d'une colonne
	private String Duree;
	
	@NotNull(message ="Champ Depart null !!!") // libelle n'accepte pas la valeur null. Le vide
	@Column(length = 50) // changer le nom d'une colonne
	private String Depart;
	@NotNull(message = "Champ Arrive null !!!") // libelle n'accepte pas la valeur null. Le vide
	@Column(length = 50) // changer le nom d'une colonne
	private String Arrive;
	@Min(10) @Max(100) // imposer une valeur max et min au prix
	
	private int Capacite;
	private int MinUtilisateur;
	@NotNull(message = "Mettre un prix !!!") 

	private double prix;
	
	@NotNull(message ="le statut est null !!! selectionner un statut")
	 @Enumerated(EnumType.STRING)
	private Statut statut;
	
	public Statut getStatut() {
		return statut;
	}
	public void setStatut(Statut statut) {
		this.statut = statut;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDuree() {
		return Duree;
	}
	public void setDuree(String duree) {
		Duree = duree;
	}
	public String getDepart() {
		return Depart;
	}
	public void setDepart(String depart) {
		Depart = depart;
	}
	public String getArrive() {
		return Arrive;
	}
	public void setArrive(String arrive) {
		Arrive = arrive;
	}
	public int getCapacite() {
		return Capacite;
	}
	public void setCapacite(int capacite) {
		Capacite = capacite;
	}
	public int getMinUtilisateur() {
		return MinUtilisateur;
	}
	public void setMinUtilisateur(int minUtilisateur) {
		MinUtilisateur = minUtilisateur;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public Abonnement(@NotNull(message = "Champ Duree null !!!") String duree,
			@NotNull(message = "Champ Depart null !!!") String depart,
			@NotNull(message = "Champ Arrive null !!!") String arrive, @Min(100) @Max(1000) int capacite,
			int minUtilisateur, @NotNull(message = "Mettre un prix !!!") double prix,Statut statut) {
		super();
		Duree = duree;
		Depart = depart;
		Arrive = arrive;
		Capacite = capacite;
		MinUtilisateur = minUtilisateur;
		this.prix = prix;
		this.statut=statut;
	}
	public Abonnement() {
		super();
	}
	@Override
	public String toString() {
		return "Abonnement [id=" + id + ", Duree=" + Duree + ", Depart=" + Depart + ", Arrive=" + Arrive + ", Capacite="
				+ Capacite + ", MinUtilisateur=" + MinUtilisateur + ", prix=" + prix + ", status=" + statut + "]";
	}

}
