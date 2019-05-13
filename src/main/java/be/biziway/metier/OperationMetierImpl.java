package be.biziway.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.biziway.dao.CompteRepository;
import be.biziway.dao.EmployeRepository;
import be.biziway.dao.OperationRepository;
import be.biziway.entities.Compte;
import be.biziway.entities.Employe;
import be.biziway.entities.Operation;
import be.biziway.entities.Retrait;
import be.biziway.entities.Versement;

@Service
public class OperationMetierImpl implements OperationMetier {
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private EmployeRepository employeRepository;

	@Override
	@Transactional // Méthode transactionnelle et Spring ouvre une transaction; Si tout va bien, alors commit; Sinon alors Spring fait un Rollback
	public boolean addMoney(String code, double montant, Long codeEmp) {
		Compte cp = compteRepository.getOne(code); // 1. On charge un compte
		Employe empl = employeRepository.getOne(codeEmp); // On charge un employé
		Operation operation = new Versement(); // 2. On crée un versement
		operation.setDateOperation(new Date()); // 3. On édite
		operation.setMontant(montant);
		operation.setCompte(cp);
		operation.setEmploye(empl);
		operationRepository.save(operation); // on enregistre l'opération
		cp.setSolde(cp.getSolde() + montant); // on met à jour le solde du compte
		return true; // Si tout se passe bien
	}

	@Override
	@Transactional
	public boolean removeMoney(String code, double montant, Long codeEmp) {
		Compte cp = compteRepository.getOne(code); // 1. On charge un compte
		if (cp.getSolde() < montant) {
			throw new RuntimeException("Solde insuffisant");
		}
		Employe empl = employeRepository.getOne(codeEmp); // On charge un employé
		Operation operation = new Retrait(); // 2. On crée un retrait
		operation.setDateOperation(new Date()); // 3. On édite
		operation.setMontant(montant);
		operation.setCompte(cp);
		operation.setEmploye(empl);
		operationRepository.save(operation); // on enregistre l'opération
		cp.setSolde(cp.getSolde() - montant); // on met à jour le solde du compte
		return true;
	}

	@Override
	@Transactional
	public boolean transferMoney(String cpte1, String cpte2, double montant, Long codeEmp) {
		removeMoney(cpte1, montant, codeEmp);
		addMoney(cpte2, montant, codeEmp);
		return true;
	}

	@Override
	public PageOperation getOperations(String codeCompte, int pageCourante, int size) {
		Page<Operation> ops = operationRepository.getOperations(codeCompte, new PageRequest(pageCourante, size));
		PageOperation pagOp = new PageOperation();
		pagOp.setOperations(ops.getContent());
		pagOp.setNombreOperationsPage(ops.getNumberOfElements());
		pagOp.setPageCourante(ops.getNumber());
		pagOp.setTotalOperations((int) ops.getTotalElements());
		pagOp.setTotalPages(ops.getTotalPages());
		return pagOp;
	}

}
