package be.biziway.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import be.biziway.entities.Compte;

public interface BanqueRmiRemote extends Remote {
	public Compte saveCompte(Compte cp) throws RemoteException; // il faut toujours lever l'exception pour que ce soit une interface RMI

	public Compte getCompte(String codeCpte) throws RemoteException;

	public boolean addMoney(String code, double montant, Long codeEmp) throws RemoteException;

	public boolean removeMoney(String code, double montant, Long codeEmp) throws RemoteException;

	public boolean transferMoney(String cpte1, String cpte2, double montant, Long codeEmp) throws RemoteException;

}
