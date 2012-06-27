
package com.excilys.excilysbanking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "operations")
public class Operation {
	
	public enum OperationType {
		CARTE, VIREMENT
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer operation_id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "compte_id", nullable = false, updatable = false)
	private Compte compte;
	
	@Enumerated(EnumType.STRING)
	@Column
	private OperationType type;
	
	@Column
	private Double montant;
	
	@Column
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime date;
	
	@Column
	private String libelle;
	
	public Operation() {}
	
	public Operation(Integer operation_id, Compte compte, OperationType type, Double montant, DateTime date) {
		this.operation_id = operation_id;
		this.compte = compte;
		this.type = type;
		this.montant = montant;
		this.date = date;
	}
	
	public Integer getOperation_id() {
		return operation_id;
	}
	
	public void setOperation_id(Integer operation_id) {
		this.operation_id = operation_id;
	}
	
	public Compte getCompte() {
		return compte;
	}
	
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	public OperationType getType() {
		return type;
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	public void setType(OperationType type) {
		this.type = type;
	}
	
	public Double getMontant() {
		return montant;
	}
	
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	
	public DateTime getDate() {
		return date;
	}
	
	public void setDate(DateTime date) {
		this.date = date;
	}
	
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Operation [operation_id=").append(operation_id).append(", compte=").append(compte).append(", type=").append(type).append(", montant=")
				.append(montant).append(", libelle=").append(libelle).append(", date=").append(date).append("]");
		return builder.toString();
	}
	
}
