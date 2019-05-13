package be.biziway.rmi;

import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.biziway.entities.Compte;
import be.biziway.metier.CompteMetier;
import be.biziway.metier.OperationMetier;

@Component("myRmiService")
public class BanqueRmiRemoteImpl implements BanqueRmiRemote {
	@Autowired
	private CompteMetier compteMetier;
	@Autowired
	private OperationMetier operationMetier;

	@Override
	public Compte saveCompte(Compte cp) throws RemoteException {
		return compteMetier.saveCompte(cp);
	}

	@Override
	public Compte getCompte(String codeCpte) throws RemoteException {
		return compteMetier.getCompte(codeCpte);
	}

	@Override
	public boolean addMoney(String code, double montant, Long codeEmp) throws RemoteException {
		return operationMetier.addMoney(code, montant, codeEmp);
	}

	@Override
	public boolean removeMoney(String code, double montant, Long codeEmp) throws RemoteException {
		return operationMetier.removeMoney(code, montant, codeEmp);
	}

	@Override
	public boolean transferMoney(String cpte1, String cpte2, double montant, Long codeEmp) throws RemoteException {
		return operationMetier.transferMoney(cpte1, cpte2, montant, codeEmp);
	}

}
