package be.biziway.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

// 1ère étape : package entities (ou domain) - On crée une entité type de compte
@Entity
@DiscriminatorValue("CC") // Ceci siginifie que chaque fois que je vois CC dans ma colonne type de compte, alors il s'agit bien d'un compte courant.
@XmlType(name = "CC") // pour personnaliser mon compte courant
public class CompteCourant extends Compte {
	private double decouvert;

	public CompteCourant() {
		super();
	}

	public CompteCourant(String codeCompte, Date dateCreation, double solde, double decouvert) {
		super(codeCompte, dateCreation, solde);
		this.decouvert = decouvert;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

}
