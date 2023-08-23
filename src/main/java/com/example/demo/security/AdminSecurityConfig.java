package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity 
@Order(1)
public class AdminSecurityConfig {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	private UserDetailsServiceImpl userDetails;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public void configureGlobal1(AuthenticationManagerBuilder auth)
	  throws Exception {
	    auth.userDetailsService(userDetails); // se baser sur des users et roles personnalisés
	}
	
	@Bean
    public SecurityFilterChain filterChain1(HttpSecurity http) throws Exception {
		  
		//http.userDetailsService(userDetails);

		 http.authorizeHttpRequests().requestMatchers("/").permitAll(); // l'accè à la racine est permis sans aucune authentification : sans login et mot de passe
		 http.authorizeHttpRequests().requestMatchers("/home").authenticated(); 
	
		 http.formLogin()
		     .loginPage("/login")  // l'adresse pour le traitement de login, indiquée dans l'action de formulaire de login : /login
		 	 .usernameParameter("login") // ça m'a pris une journée pour decouvrir ceci!!!!!!!! Utiliser pour personnaliser le formulaire du login :
		 	 .passwordParameter("motDePasse") // username ----> login et password ------> motDePasse

		 	 .failureUrl("/login?error=true") // pour rester convenable avec la version automatique de traitement de login.
			 .defaultSuccessUrl("/home").permitAll();
		 
			    
		 http.logout().permitAll(); // par defaut l'application retourne à la page /login
		     // .logoutSuccessUrl("/login") : pour changer la redirection après le logout
		 
	     http.authorizeHttpRequests()
 	  	     .requestMatchers("/deleteabn/**", "/addabn","/editart/**","/addsoci")
 	         .hasAuthority("ROLE_ADMIN"); // permet à l'admin d'acceder aux chemins-requetes : /deleteart/*/*, /addart, /editart/*/*

		  http.authorizeHttpRequests()
		  	  .requestMatchers("/css/**", "/js/**")
		  	  .permitAll(); //  permettre les ressources du site qui se trouvent dans les dossiers /css et /js
		  
		  http.exceptionHandling().accessDeniedPage("/403"); // preparer une page 403.html pour afficher le message "vous n'avez pas le droit à cette action"
		 
		  
		  http.authorizeHttpRequests().anyRequest().authenticated(); // toute requete necessite le login et le mot de passe 
		  
		 // http.httpBasic(Customizer.withDefaults());
		  
		  http.csrf();
		  
		  // nouveau 
		  http.authenticationProvider(authenticationProvider1());
		  
	   return	http.build();	
    }
	
	
	@Bean
	public AuthenticationProvider authenticationProvider1() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetails);
		authenticationProvider.setPasswordEncoder(passwordEncoder);
		return authenticationProvider;
	}

}
