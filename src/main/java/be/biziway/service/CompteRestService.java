package be.biziway.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import be.biziway.entities.Compte;
import be.biziway.metier.CompteMetier;

//5ème étape : package service - Création d'un microservice pour gérer les comptes (à travers un service Restful) - On définit un controller qui va fonctionner en mode REST
@RestController
public class CompteRestService {

	@Autowired
	private CompteMetier compteMetier;

	@RequestMapping(value = "/comptes", method = RequestMethod.POST)
	public Compte saveCompte(@RequestBody Compte c) {
		return compteMetier.saveCompte(c);
	}

	@RequestMapping(value = "/comptes/{code}", method = RequestMethod.GET)
	public Compte getCompte(@PathVariable String code) { // @PathVariable : annotation de Spring pour le paramètre code qu'on ajoute à l'annotation précédente.
		return compteMetier.getCompte(code);
	}

	@RequestMapping(value = "/comptes", method = RequestMethod.GET) // SI on envoie une requête Get vers compte, on aura la liste de comptes,
	public List<Compte> listComptes() {
		return compteMetier.listComptes();
	}

}
