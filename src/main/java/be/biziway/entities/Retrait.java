package be.biziway.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

// 1ère étape : package entities (ou domain) - On crée une entité type d'opération
@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation {

}
