
package com.excilys.excilysbanking.entities;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
public class User implements UserDetails, Serializable {
	
	private static final long serialVersionUID = 5858881328596684803L;
	
	@Id
	@Generated("assigned")
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column
	private String firstname;
	
	@Column
	private String lastname;
	
	@ManyToMany
	@JoinTable(name = "users_authorities", joinColumns = { @JoinColumn(name = "username", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "authority_id", nullable = false, updatable = false) })
	private List<Authority> authorities;
	
	@OneToMany(targetEntity = com.excilys.excilysbanking.entities.Compte.class, cascade = CascadeType.ALL, mappedBy = "user")
	private List<Compte> comptes;
	
	public User() {}
	
	public User(String username, String password, String firstname, String lastname) {
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	@Override
	public List<Authority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public String getUsername() {
		return this.username;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Override
	public String getPassword() {
		return this.password;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	
	public List<Compte> getComptes() {
		return comptes;
	}
	
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (authorities == null) {
			if (other.authorities != null)
				return false;
		} else if (!authorities.equals(other.authorities))
			return false;
		if (comptes == null) {
			if (other.comptes != null)
				return false;
		} else if (!comptes.equals(other.comptes))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [username=").append(username).append(", password=").append(password).append(", firstname=").append(firstname)
				.append(", lastname=").append(lastname).append(", authorities=").append(authorities).append(", comptes=").append(comptes).append("]");
		return builder.toString();
	}
	
}
