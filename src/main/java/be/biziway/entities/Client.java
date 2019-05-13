package be.biziway.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

// 1ère étape : package entities (ou domain) - On crée une entité client
@Entity
public class Client implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeClient;

	private String nomClient;

	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY) // comme bidirectionnelle, on utilise mappedBy et on va déclarer l'objet client dans la classe
															// compte. Avec fetch, la BDD ne chargera que les clients et c'est seulemt en cas de besoin qu'elle
															// va charger aussi les comptes. Ainsi, on évite certaines erreurs qui pourraient être générées au
															// chargement de la BDD. Contrairement à EAGER qui est un peu dangereux car permet de charger en
															// mémoire trop de données qui ne vont pas toutes etre utilisées par l'appli.
	private Collection<Compte> comptes; // car association bidirectionnelle

	public Client() {
		super();
	}

	// Pour ce constructeur, on ne garde que le nom du client car c'est lui qui nous intéresse ici)
	public Client(String nomClient) {
		super();
		this.nomClient = nomClient;
	}

	public Long getCodeClient() {
		return codeClient;
	}

	public void setCodeClient(Long codeClient) {
		this.codeClient = codeClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	@JsonIgnore // cette méthode étant ignorée, ne sera donc pas sérialisée
	@XmlTransient
	public Collection<Compte> getComptes() {
		return comptes;
	}

	@JsonSetter
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}

}
