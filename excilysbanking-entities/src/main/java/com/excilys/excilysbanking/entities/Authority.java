
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
	@Column
	private Integer authority_id;
	
	@Enumerated(EnumType.STRING)
	@Column
	private AuthorityType authority;
	
	public Authority() {}
	
	public Authority(Integer authority_id, AuthorityType authority) {
		this.authority_id = authority_id;
		this.authority = authority;
	}
	
	public Integer getAuthority_id() {
		return authority_id;
	}
	
	public void setauthority_id(Integer authority_id) {
		this.authority_id = authority_id;
	}
	
	public void setAuthority(String authorityType) {
		this.authority = AuthorityType.valueOf(authorityType);
	}
	
	@Override
	public String getAuthority() {
		return authority.name();
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
		if (authority_id != other.authority_id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Authority [authority_id=");
		return sb.append(authority_id).append(", authority=").append(authority.toString()).append("]").toString();
	}
	
}
