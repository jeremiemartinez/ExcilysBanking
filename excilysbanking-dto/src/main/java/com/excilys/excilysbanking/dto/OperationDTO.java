
package com.excilys.excilysbanking.dto;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import com.excilys.excilysbanking.dto.utils.CustomDateSerializer;
import com.excilys.excilysbanking.entities.Operation.OperationType;

public class OperationDTO {

	private Integer id;

	private OperationType type;

	private Double montant;

	@JsonSerialize(using = CustomDateSerializer.class)
	private DateTime date;

	private String libelle;

	private Integer compte;

	private Integer compteDestination;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OperationType getType() {
		return type;
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

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Integer getCompte() {
		return compte;
	}

	public void setCompte(Integer compte) {
		this.compte = compte;
	}

	public Integer getCompteDestination() {
		return compteDestination;
	}

	public void setCompteDestination(Integer compteDestination) {
		this.compteDestination = compteDestination;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OperationDTO [id=").append(id).append(", operationType=").append(type).append(", Montant=").append(montant).append(", date=")
				.append(date).append(", libelle=").append(libelle).append(", compte=").append(compte).append(", compteDestination=").append(compteDestination)
				.append("]");
		return builder.toString();
	}

	public static class Builder {

		private final OperationDTO operation = new OperationDTO();

		public Builder id(Integer id) {
			operation.id = id;
			return this;
		}

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

		public Builder compte(Integer compte) {
			operation.compte = compte;
			return this;
		}

		public Builder compteDestination(Integer compteDestination) {
			operation.compteDestination = compteDestination;
			return this;
		}

		public OperationDTO build() {
			return operation;
		}
	}

}
