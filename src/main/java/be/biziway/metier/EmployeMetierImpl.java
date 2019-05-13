package be.biziway.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.biziway.dao.EmployeRepository;
import be.biziway.entities.Employe;

// 4ème étape : package métier - On implémente l'interface; Toutes les méthodes sont implémentées
@Service
public class EmployeMetierImpl implements EmployeMetier {
	@Autowired
	private EmployeRepository employeRepository;

	@Override
	public Employe saveEmploye(Employe e) {
		return employeRepository.save(e);
	}

	@Override
	public List<Employe> listEmployes() {
		return employeRepository.findAll();
	}

}
