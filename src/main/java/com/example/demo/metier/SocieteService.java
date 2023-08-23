package com.example.demo.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.dao.SocieteRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.Societe;

@Service
public class SocieteService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	  @Autowired 
	  private SocieteRepository SociRep;
		/*
		 * @Autowired private UserRepository userRep;
		 */
	  
	  
	  
	public void ajouterSociete(Societe societe) { 
		societe.setMotDePasse(passwordEncoder.encode(societe.getMotDePasse()));
		societe.setRole("ROLE_FOURNISSEUR");
		SociRep.save(societe); // insert into abonnement 
	 }
	  
	  //recuper la listes de tous les abonnements 
	  public List<Societe> listSocietes(){
		  return SociRep.findAll(); 
		  }
	  
	  public Societe unSociete(int id) {
		  Optional<Societe> Soci=SociRep.findById(id);
		  Societe Societe=null;
	  if(Soci.isPresent()) Societe = Soci.get();
	  		return Societe ;
	  }
}
