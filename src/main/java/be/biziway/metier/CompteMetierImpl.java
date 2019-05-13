package be.biziway.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.biziway.dao.CompteRepository;
import be.biziway.entities.Compte;

@Service
public class CompteMetierImpl implements CompteMetier {
	@Autowired
	private CompteRepository compteRepository;

	@Override
	public Compte saveCompte(Compte c) {
		c.setDateCreation(new Date()); // POur que la date système soit utilisée à chaque création de compte
		return compteRepository.save(c);
	}

	@Override
	public Compte getCompte(String code) {
		return compteRepository.getOne(code);
	}

	// Cette méthode permet de consulter tous les comptes (donc avoir la liste des comptes)
	@Override
	public List<Compte> listComptes() {
		return compteRepository.findAll();
	}
	// TODO
	// public List<Compte> listComptes(Client cli) {
	// return compteRepository
	// }

}
