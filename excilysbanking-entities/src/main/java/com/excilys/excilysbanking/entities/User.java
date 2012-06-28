
package com.excilys.excilysbanking.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private String username;

	@Column(nullable = false)
	private String password;

	@Column
	private String firstname;

	@Column
	private String lastname;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_authorities", joinColumns = { @JoinColumn(name = "username", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "authority_id", nullable = false, updatable = false) })
	private List<Authority> authorities = new ArrayList<Authority>();

	@OneToMany(targetEntity = com.excilys.excilysbanking.entities.Compte.class, cascade = CascadeType.ALL, mappedBy = "user")
	private List<Compte> comptes = new ArrayList<Compte>();

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
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [username=").append(username).append(", password=").append(password).append(", firstname=").append(firstname)
				.append(", lastname=").append(lastname).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
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

	public static class Builder {

		private final User user = new User();

		public Builder username(String username) {
			user.username = username;
			return this;
		}

		public Builder firstname(String firstname) {
			user.firstname = firstname;
			return this;
		}

		public Builder lastname(String lastname) {
			user.lastname = lastname;
			return this;
		}

		public Builder password(String password) {
			user.password = password;
			return this;
		}

		public Builder authorities(List<Authority> authorities) {
			user.authorities = authorities;
			return this;
		}

		public Builder comptes(List<Compte> comptes) {
			user.comptes = comptes;
			return this;
		}

		public User build() {
			return user;
		}
	}

}
