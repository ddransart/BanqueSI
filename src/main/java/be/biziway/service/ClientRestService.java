package be.biziway.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import be.biziway.entities.Client;
import be.biziway.metier.ClientMetier;

// 5ème étape : package service - Création d'un microservice pour gérer les clients (à travers un service Restful) - On définit un controller qui va fonctionner en mode REST
@RestController
public class ClientRestService {
	@Autowired
	private ClientMetier clientMetier;

	// Pour accéder à ces clients, on utiliser RequestMapping et POST pour l'ajout
	@RequestMapping(value = "/clients", method = RequestMethod.POST) // si on envoie une requete avec post, alors les données du client sont envoyées avec JSON
																		// D'OÙ @RequestBody
	public Client saveClient(@RequestBody Client c) {
		return clientMetier.saveClient(c);
	}

	@RequestMapping(value = "/clients", method = RequestMethod.GET) // SI on envoie une requête Get vers client, on aura la liste de clients,
	public List<Client> listClient() {
		return clientMetier.listClient();
	}

}
