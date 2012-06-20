
package com.excilys.excilysbanking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comptes")
public class Compte {

	@Id
	@Column
	private Integer compte_id;

	@Column
	private Double solde;

}
