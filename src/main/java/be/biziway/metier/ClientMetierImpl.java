package be.biziway.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.biziway.dao.ClientRepository;
import be.biziway.entities.Client;

// 4ème étape : package métier - On implémente l'interface; Toutes les méthodes sont implémentées
@Service
public class ClientMetierImpl implements ClientMetier {
	@Autowired
	private ClientRepository clientRepository;

	// Cette méthode permet d'ajouter un client (en d'autre terme, de l'enregistrer)
	@Override
	public Client saveClient(Client c) {
		return clientRepository.save(c);
	}

	// Cette méthode permet de consulter tous les clients (donc avoir la liste des client)
	@Override
	public List<Client> listClient() {
		return clientRepository.findAll();
	}

}
