
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

@Entity
@Table(name = "comptes")
public class Compte {

	public enum CompteType {
		ESPECE
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "compte_id")
	private Integer id;

	@Column
	private Double solde;

	@Enumerated(EnumType.STRING)
	@Column
	private CompteType type;

	@ManyToOne
	@JoinColumn(name = "username", nullable = false)
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public CompteType getType() {
		return type;
	}

	public void setType(CompteType type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Compte [id=").append(id).append(", solde=").append(solde).append(", compteType=").append(type).append(user).append("]");
		return builder.toString();
	}

	public static class Builder {

		private final Compte compte = new Compte();

		public Builder id(Integer id) {
			compte.id = id;
			return this;
		}

		public Builder solde(Double solde) {
			compte.solde = solde;
			return this;
		}

		public Builder type(CompteType type) {
			compte.type = type;
			return this;
		}

		public Builder user(User user) {
			compte.user = user;
			return this;
		}

		public Compte build() {
			return compte;
		}
	}

}
