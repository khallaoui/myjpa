package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Abonnement;
import com.example.demo.entities.AppUser;
import com.example.demo.metier.AbonnementService;

@Controller
public class AbonnementController {
	@Autowired
	private AbonnementService abnService;
	
	@GetMapping("/home")
	 public String getHome() {
		 System.out.println("------------ Ici Home ----------------------- ");
		 return "home";
	 } 
	
	 @GetMapping("/login")
	 public String getLogin(Model model) {
		 AppUser appUser = new AppUser();
			model.addAttribute("user", appUser);
		 
		 System.out.println("------------ ICi login ----------------------- ");
		 return "login";
	 }
	
	@RequestMapping("/addabn")
	public String ajouterArticle(Model model) {
		Abonnement abn = new Abonnement();
		model.addAttribute("abonnement", abn);//recupere les donnes entrer par utilisateur
		System.out.println("----------- ici1 -------------");
		return "ajouteAbonnement";
 }
	@RequestMapping(value="/PostAddabn", method=RequestMethod.POST)
	public String postAjouterAbonnement(@ModelAttribute("abonnement")Abonnement abn) {
		abnService.ajouterArticle(abn);
		System.out.println("----------- ici 2-------------");
		return "redirect:/";
	}
	//pour afficher la listes des abonnements
	 @GetMapping("/")
	 public String getAbonnements(Model model) {
		 List<Abonnement> Abonnements = abnService.listAbonnements();
		 model.addAttribute("Abonnements", Abonnements);
		 return"ListeAbonnements";
 }
	//prend l'abonnement choisir et le modefier
	 @RequestMapping("/editabn/{id}")
		public String modifierArticle(Model model, 
							@PathVariable(value="id") int id) {
			Abonnement abon = abnService.unabonnement(id);
			model.addAttribute("article", abon);
			
			System.out.println("----------- ici -------------");
			return "modifierabonnement";
		}
	 
	 @GetMapping("/deleteabn/{id}")
		public String delete(@PathVariable(value="id")int id) {
		 abnService.supprimer(id);
			return "redirect:/"; 
		}
	 
	 
	 
	 
	 
	 
	
}