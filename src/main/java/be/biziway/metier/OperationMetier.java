package be.biziway.metier;

public interface OperationMetier {

	public boolean addMoney(String code, double montant, Long codeEmp);

	public boolean removeMoney(String code, double montant, Long codeEmpl);

	public boolean transferMoney(String cpte1, String cpte2, double montant, Long codeEmp);

	public PageOperation getOperations(String codeCompte, int pageCourante, int size);

}
