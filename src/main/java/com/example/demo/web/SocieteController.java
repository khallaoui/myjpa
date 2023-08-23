package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.AppUser;
import com.example.demo.entities.Societe;
import com.example.demo.metier.SecuriteService;
import com.example.demo.metier.SocieteService;

import jakarta.validation.Valid;

@Controller
public class SocieteController {
	@Autowired
	private SocieteService SocieteSer;
	
	@RequestMapping("/addsoci")
	public String ajouterSociete(Model model) {
		Societe soci = new Societe();
		
		model.addAttribute("societe", soci);//recupere les donnes entrer par utilisateur
		System.out.println("----------- ici1 -------------");
		return "ajouteSociete";
 }
	@PostMapping("/PostAddsoci")
	public String postAjouterSociete(/*indiquer au Spring de lancer la verification*/ 
			
									@Valid @ModelAttribute("societe")Societe soci,
									 /*ajouter ce parametre qui detient les erreurs*/
										BindingResult bindingResult) {

		// si l'une des contraintes n'est pas respectées : bindingResult.hasErrors() retourne true
		if(bindingResult.hasErrors()) {
			// retour au meme formulaire
			return "ajouteSociete";
		}		
		SocieteSer.ajouterSociete(soci);
		System.out.println("----------- ici 2-------------");
		return "ajouteSociete";
	}

}
