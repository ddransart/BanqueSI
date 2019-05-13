package be.biziway.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

// 1ère étape : package entities (ou domain) - On crée une entité Groupe
@Entity
// @Table(name="GROUPES") si on veut changer le nom de la table en GROUPES dans notre BDD, sinon par défaut le nom de la table correspond au nom de la classe
public class Groupe implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeGroupe;

	private String nomGroupe;

	@ManyToMany(mappedBy = "groupes") // On peut aussi préciser l'attribut groupes qui est défini dans la classe employé pour notre jointure au lieu d'utiliser
										// @JoinTable
	private Collection<Employe> employes;

	public Groupe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Groupe(String nomGroupe) {
		super();
		this.nomGroupe = nomGroupe;
	}

	public Long getCodeGroupe() {
		return codeGroupe;
	}

	public void setCodeGroupe(Long codeGroupe) {
		this.codeGroupe = codeGroupe;
	}

	public String getNomGroupe() {
		return nomGroupe;
	}

	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

	@JsonIgnore
	public Collection<Employe> getEmployes() {
		return employes;
	}

	@JsonSetter
	public void setEmployes(Collection<Employe> employes) {
		this.employes = employes;
	}

}
