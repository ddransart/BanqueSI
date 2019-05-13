package be.biziway.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import be.biziway.entities.Groupe;

// 2ème étape : package dao - On crée une interface pour gérer les groupes
public interface GroupeRepository extends JpaRepository<Groupe, Long> {

}
