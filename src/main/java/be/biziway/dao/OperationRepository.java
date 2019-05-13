package be.biziway.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import be.biziway.entities.Operation;

// 2ème étape : package dao - On crée une interface pour gérer les opérations
public interface OperationRepository extends JpaRepository<Operation, Long> {

	// Ici on n'a créé que les interfaces JpaRepository mais on a hérité de Spring Data, qui va par la suite injecter les implémentations nécessaires pour gérer
	// les entités avec entity manager;

	@Query("Select op from Operation op where op.compte.codeCompte=:x") // Pour consulter les opérations liées à un compte quelconque. Donc x.
	public Page<Operation> getOperations(@Param("x") String code, Pageable pageable);

	// 2e solution
	// public Page<Operation> findByCompte(Compte cp, Pageable pageable);
}
