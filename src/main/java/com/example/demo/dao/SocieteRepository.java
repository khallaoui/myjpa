package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Abonnement;
import com.example.demo.entities.AppUser;
import com.example.demo.entities.Societe;abstract
@Repository
public interface SocieteRepository extends JpaRepository<Societe,Integer>{
	Societe findByLoginS (String login);
	
	
}
