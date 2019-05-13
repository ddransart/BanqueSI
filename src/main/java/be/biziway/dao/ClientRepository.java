package be.biziway.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import be.biziway.entities.Client;

// 2ème étape : package dao - On crée une interface pour gérer les clients
public interface ClientRepository extends JpaRepository<Client, Long> {

}
