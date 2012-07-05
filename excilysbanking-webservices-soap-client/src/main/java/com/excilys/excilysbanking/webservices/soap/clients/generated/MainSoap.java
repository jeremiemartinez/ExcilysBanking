
package com.excilys.excilysbanking.webservices.soap.clients.generated;

import java.util.List;
import com.excilys.excilysbanking.webservices.soap.CompteDTO;
import com.excilys.excilysbanking.webservices.soap.CompteServiceWS;
import com.excilys.excilysbanking.webservices.soap.impl.CompteServiceWSImplService;

public class MainSoap {

	private static final String USERNAME = "jmartinez";

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CompteServiceWSImplService service = new CompteServiceWSImplService();

		CompteServiceWS port = service.getCompteServiceWSImplPort();

		List<CompteDTO> comptes = port.getComptesByUsername(USERNAME);

		System.out.println("***** Generated Client Program *****");

		System.out.println("* Liste de toute les comptes (" + comptes.size() + ") pour " + USERNAME + "\n");

		for (CompteDTO c : comptes)
			System.out.println(displayCompte(c) + "\n");

		System.out.println("***** Fin du programme *****");

	}

	private static String displayCompte(CompteDTO c) {
		StringBuilder builder = new StringBuilder();
		builder.append("CompteDTO [id=").append(c.getId()).append(", solde=").append(c.getSolde()).append(", compteType=").append(c.getType())
				.append(", username=").append(c.getUsername()).append("]");
		return builder.toString();
	}
}
