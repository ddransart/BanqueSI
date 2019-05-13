package be.biziway.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

//1ère étape : package entities (ou domain) - On crée une entité Opération
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(length = 1)

// Pour que Json reconnaisse mes classes filles (Mapping objet-json) et affiche les types d'opérations dans ma liste
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(name = "V", value = Versement.class), @Type(name = "R", value = Retrait.class) })

public class Operation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numeroOperation;
	private Date dateOperation;
	private double montant;

	@ManyToOne
	@JoinColumn(name = "CODE_CPTE") // Ici c'est la clé étrangère
	private Compte compte;

	@ManyToOne
	@JoinColumn(name = "CODE_EMP") // Ici c'est la clé étrangère
	private Employe employe;

	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Operation(Date dateOperation, double montant) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
	}

	public Long getNumeroOperation() {
		return numeroOperation;
	}

	public void setNumeroOperation(Long numeroOperation) {
		this.numeroOperation = numeroOperation;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	@JsonIgnore
	@XmlTransient
	public Compte getCompte() {
		return compte;
	}

	@JsonSetter
	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@JsonIgnore
	@XmlTransient
	public Employe getEmploye() {
		return employe;
	}

	@JsonSetter
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

}
