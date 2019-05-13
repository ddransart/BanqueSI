package be.biziway.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import be.biziway.entities.Employe;
import be.biziway.metier.EmployeMetier;

// 5ème étape : package service - Ici on gère l'employé à travers un service Restful - On définit un controller qui va fonctionner en mode REST
@RestController
public class EmployeRestService {
	@Autowired
	private EmployeMetier employeMetier;

	@RequestMapping(value = "/employes", method = RequestMethod.POST)
	public Employe saveEmploye(@RequestBody Employe e) {
		return employeMetier.saveEmploye(e);
	}

	@RequestMapping(value = "/employes", method = RequestMethod.GET)
	public List<Employe> listEmployes() {
		return employeMetier.listEmployes();
	}
}
