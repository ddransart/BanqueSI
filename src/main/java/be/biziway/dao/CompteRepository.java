package be.biziway.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import be.biziway.entities.Compte;

// 2ème étape : package dao - On crée une interface pour gérer les comptes
public interface CompteRepository extends JpaRepository<Compte, String> {

}
