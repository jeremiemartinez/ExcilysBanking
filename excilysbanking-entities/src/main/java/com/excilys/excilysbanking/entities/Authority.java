
package com.excilys.excilysbanking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "authorities")
public class Authority implements GrantedAuthority {

	private static final long serialVersionUID = 2431697487487879447L;

	public enum AuthorityType {
		ROLE_USER, ROLE_ADMIN;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "authority_id")
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column
	private AuthorityType authority;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setAuthority(String authorityType) {
		this.authority = AuthorityType.valueOf(authorityType);
	}

	@Override
	public String getAuthority() {
		return authority.name();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Authority [id=");
		return sb.append(id).append(", authority=").append(authority.toString()).append("]").toString();
	}

	public static class Builder {

		private final Authority authority = new Authority();

		public Builder id(Integer id) {
			authority.id = id;
			return this;
		}

		public Builder type(AuthorityType type) {
			authority.authority = type;
			return this;
		}

		public Authority build() {
			return authority;
		}
	}

}
