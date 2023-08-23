package com.example.demo.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AbonnementRepository;
import com.example.demo.entities.Abonnement;

@Service
public class AbonnementService {
	
	  @Autowired 
	  private AbonnementRepository abRep;
	  
	  public void ajouterArticle(Abonnement abn) { 
		  abRep.save(abn); // insert into abonnement 
	 }
	  
	  //recuper la listes de tous les abonnements 
	  public List<Abonnement> listAbonnements(){
		  return abRep.findAll(); 
		  }
	
	  public Abonnement unabonnement(int id) {
		  Optional<Abonnement> Abon=abRep.findById(id);
		  Abonnement Abonnement=null;
	  if(Abon.isPresent()) Abonnement = Abon.get();
	  		return Abonnement ;
	  }
	  public void modifier(Abonnement ANouveau) {
		  Optional<Abonnement> artAncien =abRep.findById(ANouveau.getId());
		  Abonnement abn = artAncien.get();
		  abn.setDuree(ANouveau.getDuree());
		  abn.setDepart(ANouveau.getDepart());
		  abn.setArrive(ANouveau.getArrive());
		  abn.setCapacite(ANouveau.getCapacite());
	  abn.setMinUtilisateur(ANouveau.getMinUtilisateur());
	  abn.setPrix(ANouveau.getPrix());
	  abn.setStatut(ANouveau.getStatut());
	  abRep.save(abn);
	  abRep.delete(ANouveau);}
	  
	 //supprimer un abonnement
	  public void supprimer(int id) { Optional<Abonnement> abnAncien =
			  abRep.findById(id); abRep.delete(abnAncien.get()); }
			 
}
