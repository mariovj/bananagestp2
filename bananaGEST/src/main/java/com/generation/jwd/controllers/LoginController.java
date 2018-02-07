package com.generation.jwd.controllers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.generation.jwd.beans.User;

@Controller
@RequestMapping("/login")
public class LoginController {	
	
	@RequestMapping(method = RequestMethod.GET)
	public String renderUser() {
		
		System.out.println("#########Inicio##########");
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		User user = new User();
		user.setId(6);
		user.setEmail("prueba");
		user.setPassword("passwordprueba");
		
		session.persist(user);
		
		t.commit();
		
		session.close();
		
		System.out.println("Fin");
		
		return "user_home";
	}
}