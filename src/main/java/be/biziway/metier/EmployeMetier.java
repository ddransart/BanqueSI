package be.biziway.metier;

import java.util.List;

import be.biziway.entities.Employe;

// 3ème étape : package métier - On crée une interface pour la logique métier avec la liste de tous les traitements à effectuer sur l'employé
public interface EmployeMetier {
	public Employe saveEmploye(Employe e);

	public List<Employe> listEmployes();
}
