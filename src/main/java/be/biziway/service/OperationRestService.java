package be.biziway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import be.biziway.metier.OperationMetier;
import be.biziway.metier.PageOperation;

@RestController
public class OperationRestService {
	@Autowired
	private OperationMetier operationMetier;

	@RequestMapping(value = "/operations", method = RequestMethod.GET)
	public PageOperation getOperations(@RequestParam String codeCompte, @RequestParam int pageCourante, @RequestParam int size) { // On filtre selon la norme
																																	// RESTFUL
		return operationMetier.getOperations(codeCompte, pageCourante, size);
	}

	@RequestMapping(value = "/versement", method = RequestMethod.PUT)
	public boolean addMoney(@RequestParam String code, @RequestParam double montant, @RequestParam Long codeEmp) {
		return operationMetier.addMoney(code, montant, codeEmp);
	}

	@RequestMapping(value = "/retrait", method = RequestMethod.PUT)
	public boolean removeMoney(@RequestParam String code, @RequestParam double montant, @RequestParam Long codeEmpl) {
		return operationMetier.removeMoney(code, montant, codeEmpl);
	}

	@RequestMapping(value = "/virement", method = RequestMethod.PUT)
	public boolean transferMoney(@RequestParam String cpte1, @RequestParam String cpte2, @RequestParam double montant, @RequestParam Long codeEmp) {
		return operationMetier.transferMoney(cpte1, cpte2, montant, codeEmp);
	}

}
