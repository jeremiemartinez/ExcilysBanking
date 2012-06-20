
package com.excilys.excilysbanking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "authorities")
public class Authority implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4461574436681644583L;

	public enum AuthorityType {
		ROLE_USER, ROLE_ADMIN;
	}

	@Id
	@Column(name = "authority_id")
	private Integer id;

	@Enumerated(EnumType.STRING)
	private AuthorityType authority;

	public Authority() {}

	public Authority(Integer id, AuthorityType authority) {
		this.id = id;
		this.authority = authority;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setAuthority(AuthorityType authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return authority.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Authority other = (Authority) obj;
		if (authority == null) {
			if (other.authority != null)
				return false;
		} else if (!authority.equals(other.authority))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Authority [id=");
		return sb.append(id).append(", authority=").append(authority.toString()).append("]").toString();
	}

}
