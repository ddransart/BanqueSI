package be.biziway.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import be.biziway.entities.Employe;

// 2ème étape : package dao - On crée une interface pour gérer les employés
public interface EmployeRepository extends JpaRepository<Employe, Long> {

}
