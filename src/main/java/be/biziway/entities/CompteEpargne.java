package be.biziway.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

// 1ère étape : package entities (ou domain) - On crée une entité type de compte
@Entity
@DiscriminatorValue("CE")
@XmlType(name = "CE")
public class CompteEpargne extends Compte {

	private double taux;

	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteEpargne(String codeCompte, Date dateCreation, double solde, double taux) {
		super(codeCompte, dateCreation, solde);
		this.taux = taux;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

}
