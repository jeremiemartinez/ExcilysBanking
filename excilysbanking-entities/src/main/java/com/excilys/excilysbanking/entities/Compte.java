
package com.excilys.excilysbanking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	@Column
	private Integer compte_id;

	@Column
	private Double solde;

	@Enumerated(EnumType.STRING)
	@Column
	private CompteType type;

	@ManyToOne
	@JoinColumn(name = "username", nullable = false)
	private User user;

	public Compte() { }

	public Compte(Integer compte_id, Double solde, CompteType type, User user) {
		this.compte_id = compte_id;
		this.solde = solde;
		this.type = type;
		this.user = user;
	}

	public Integer getCompte_id() {
		return compte_id;
	}

	public void setCompte_id(Integer compte_id) {
		this.compte_id = compte_id;
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		if (type != other.type)
			return false;
		if (compte_id == null) {
			if (other.compte_id != null)
				return false;
		} else if (!compte_id.equals(other.compte_id))
			return false;
		if (solde == null) {
			if (other.solde != null)
				return false;
		} else if (!solde.equals(other.solde))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Compte [compte_id=").append(compte_id).append(", solde=").append(solde).append(", compteType=").append(type).append(user).append("]");
		return builder.toString();
	}

}
