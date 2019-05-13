package be.biziway.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.biziway.entities.Compte;
import be.biziway.metier.CompteMetier;
import be.biziway.metier.OperationMetier;
import be.biziway.metier.PageOperation;

@Component // car composant Spring, afin qu'il puisse le considérer
@WebService // pour que la classe soit un webservice (ajouter aussi autowired et webparam) // elle aurait pu être nommée util ou appartenir à ce package
public class BanqueSoapService {
	@Autowired
	private CompteMetier compteMetier;
	@Autowired
	private OperationMetier operationMetier;

	@WebMethod
	public Compte getCompte(@WebParam(name = "code") String code) {
		return compteMetier.getCompte(code);
	}

	@WebMethod
	public List<Compte> listComptes() {
		return compteMetier.listComptes();
	}

	@WebMethod
	public boolean addMoney(@WebParam(name = "code") String code, @WebParam(name = "montant") double montant, @WebParam(name = "codeEmp") Long codeEmp) {
		return operationMetier.addMoney(code, montant, codeEmp);
	}

	@WebMethod
	public boolean removeMoney(@WebParam(name = "code") String code, @WebParam(name = "montant") double montant, @WebParam(name = "codeEmp") Long codeEmp) {
		return operationMetier.removeMoney(code, montant, codeEmp);
	}

	@WebMethod
	public boolean transferMoney(@WebParam(name = "cpte1") String cpte1, @WebParam(name = "cpte2") String cpte2, @WebParam(name = "montant") double montant,
			@WebParam(name = "codeEmp") Long codeEmp) {
		return operationMetier.transferMoney(cpte1, cpte2, montant, codeEmp);
	}

	@WebMethod
	public PageOperation getOperations(@WebParam(name = "codeCompte") String codeCompte, @WebParam(name = "pageCourante") int pageCourante,
			@WebParam(name = "size") int size) {
		return operationMetier.getOperations(codeCompte, pageCourante, size);
	}

}
