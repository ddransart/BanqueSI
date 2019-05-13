package be.biziway.metier;

import java.io.Serializable;
import java.util.List;

import be.biziway.entities.Operation;

public class PageOperation implements Serializable {
	private List<Operation> operations;
	private int pageCourante;
	private int nombreOperationsPage;
	private int totalOperations;
	private int totalPages;

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public int getPageCourante() {
		return pageCourante;
	}

	public void setPageCourante(int pageCourante) {
		this.pageCourante = pageCourante;
	}

	public int getNombreOperationsPage() {
		return nombreOperationsPage;
	}

	public void setNombreOperationsPage(int nombreOperationsPage) {
		this.nombreOperationsPage = nombreOperationsPage;
	}

	public int getTotalOperations() {
		return totalOperations;
	}

	public void setTotalOperations(int totalOperations) {
		this.totalOperations = totalOperations;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

}
