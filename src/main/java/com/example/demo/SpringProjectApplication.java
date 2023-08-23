package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.entities.AppRole;
import com.example.demo.entities.AppUser;
import com.example.demo.entities.Role;
import com.example.demo.metier.SecuriteService;

@SpringBootApplication
public class SpringProjectApplication {

	public static void main(String[] args) {

		ApplicationContext context =  SpringApplication.run(SpringProjectApplication.class, args);

		SecuriteService secServ = context.getBean(SecuriteService.class); //String
		  AppUser u1 = new AppUser("med", "1234","ROLE_ADMIN"); 
		  secServ.addUser(u1);
		 // AppUser u2 = new AppUser("aya", "1234","user");  secServ.addUser(u2);
		  
		 // AppRole r1 = new AppRole("ROLE_admin", "Admin de site"); 
		  //secServ.addRole(r1);
		  
		  
		  //secServ.addRoleToUser(r1, u1); 
	
	}

}
