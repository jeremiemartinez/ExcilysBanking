
package com.excilys.excilysbanking.dto;

import javax.xml.bind.annotation.XmlRootElement;
import com.excilys.excilysbanking.entities.Compte.CompteType;

@XmlRootElement(name = "compte")
public class CompteDTO {

	private Integer id;

	private Double solde;

	private CompteType type;

	private String username;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CompteDTO [id=").append(id).append(", solde=").append(solde).append(", compteType=").append(type).append(username).append("]");
		return builder.toString();
	}

	public static class Builder {

		private final CompteDTO compte = new CompteDTO();

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

		public Builder user(String username) {
			compte.username = username;
			return this;
		}

		public CompteDTO build() {
			return compte;
		}
	}

}
