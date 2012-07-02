
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
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import com.excilys.excilysbanking.entities.util.CustomDateSerializer;

@Entity
@Table(name = "operations")
public class Operation {
	
	public enum OperationType {
		CARTE, VIREMENT
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "operation_id")
	private Integer id;
	
	@JsonIgnore
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
	@JsonSerialize(using = CustomDateSerializer.class)
	private DateTime date;
	
	@Column
	private String libelle;
	
	public Integer getId() {
		return id;
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
		builder.append("Operation [id=").append(id).append(", compte=").append(compte).append(", type=").append(type).append(", montant=").append(montant)
				.append(", libelle=").append(libelle).append(", date=").append(date).append("]");
		return builder.toString();
	}
	
	public static class Builder {
		
		private final Operation operation = new Operation();
		
		public Builder montant(Double montant) {
			operation.montant = montant;
			return this;
		}
		
		public Builder type(OperationType type) {
			operation.type = type;
			return this;
		}
		
		public Builder libelle(String libelle) {
			operation.libelle = libelle;
			return this;
		}
		
		public Builder date(DateTime date) {
			operation.date = date;
			return this;
		}
		
		public Builder compte(Compte compte) {
			operation.compte = compte;
			return this;
		}
		
		public Operation build() {
			return operation;
		}
	}
	
}
