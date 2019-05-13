package be.biziway.metier;

import java.util.List;

import be.biziway.entities.Client;

// 3ème étape : package métier - On crée une interface pour la logique métier avec la liste de tous les traitements à effectuer sur le client
// Donc mon appli permet d'ajouter un client et de consulter la liste de tous les clients

public interface ClientMetier {
	public Client saveClient(Client c); // pour enregistrer le client

	public List<Client> listClient(); // pour consulter la liste des clients
}
