package be.biziway.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

// 1ère étape : package entities (ou domain) - On crée une entité employé
@Entity
public class Employe implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeEmploye;

	private String nomEmploye;

	@ManyToOne
	@JoinColumn(name = "CODE_EMP_SUP")
	private Employe employeSup; // Association reflexive

	// Association unidirectionnelles, d'où les champs en commentaires
	// @OneToMany(fetch = FetchType.LAZY)
	// private Collection<Operation> operations;

	// @OneToMany(fetch = FetchType.LAZY)
	// private Collection<Compte> comptes;

	@ManyToMany
	@JoinTable(name = "EMP_GRPE") // Avec ce type d'association, on a une table de jointure
	private Collection<Groupe> groupes;

	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employe(String nomEmploye) {
		super();
		this.nomEmploye = nomEmploye;
	}

	public Long getCodeEmploye() {
		return codeEmploye;
	}

	public void setCodeEmploye(Long codeEmploye) {
		this.codeEmploye = codeEmploye;
	}

	public String getNomEmploye() {
		return nomEmploye;
	}

	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}

	@JsonIgnore // pour ne pas charger les données du superieur hierarchique
	public Employe getEmployeSup() {
		return employeSup;
	}

	@JsonSetter // S'il ya les données qui viennent en format JSON, elles seront prises en considération et la désérialisation va fonctionner
	public void setEmployeSup(Employe employeSup) {
		this.employeSup = employeSup;
	}

	@JsonIgnore
	public Collection<Groupe> getGroupes() {
		return groupes;
	}

	@JsonSetter
	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}
}
