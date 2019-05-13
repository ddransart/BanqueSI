package be.biziway.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

//1ère étape : package entities (ou domain) - On crée une entité Compte
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Cette annotation signifie qu'il s'agit d'une classe abstraite et Single table pour dire qu'on ne va
														// créer qu'une seule table dans la BDD même si on a plusieurs types de comptes.
														// Mapping objet-jpa
@DiscriminatorColumn(name = "TYPE_CPTE", discriminatorType = DiscriminatorType.STRING, length = 2) // On spécifie la colonne du type de compte dans la BDD.

// Pour que Json reconnaisse mes classes filles (Mapping objet-json)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(name = "CC", value = CompteCourant.class), @Type(name = "CE", value = CompteEpargne.class) })
@XmlSeeAlso({ CompteCourant.class, CompteEpargne.class }) // pour que xml(jaxB) reconnaisse mes classes filles
public abstract class Compte implements Serializable {

	@Id
	private String codeCompte;

	private Date dateCreation;
	private double solde;

	@ManyToOne
	@JoinColumn(name = "CODE_CLI") // Ici c'est la clé étrangère
	private Client client;

	@ManyToOne
	@JoinColumn(name = "CODE_EMP") // Ici c'est la clé étrangère
	private Employe employe;

	@OneToMany(mappedBy = "compte", fetch = FetchType.LAZY)
	private Collection<Operation> operations;

	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	// On décide de ne garder que les infos du compte mais pas des associations
	public Compte(String codeCompte, Date dateCreation, double solde) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
	}

	public String getCodeCompte() {
		return codeCompte;
	}

	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	@JsonIgnore // pour json
	@XmlTransient // pour xml
	public Collection<Operation> getOperations() {
		return operations;
	}

	@JsonSetter
	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}

}
