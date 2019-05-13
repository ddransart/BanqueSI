package be.biziway.metier;

import java.util.List;

import be.biziway.entities.Compte;

public interface CompteMetier {
	public Compte saveCompte(Compte c); // pour créer un compte

	public Compte getCompte(String code); // pour consulter un compte

	public List<Compte> listComptes(); // pour consulter la liste des comptes

	// TODO
	// public List<Compte> listComptes(Client cli); // pour consulter la liste des comptes d'un client

}
