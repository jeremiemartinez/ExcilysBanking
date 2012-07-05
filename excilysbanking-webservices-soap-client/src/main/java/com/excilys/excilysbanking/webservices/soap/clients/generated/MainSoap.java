
package com.excilys.excilysbanking.webservices.soap.clients.generated;

import java.util.List;
import com.excilys.excilysbanking.webservices.soap.CompteDTO;
import com.excilys.excilysbanking.webservices.soap.CompteServiceWS;
import com.excilys.excilysbanking.webservices.soap.OperationDTO;
import com.excilys.excilysbanking.webservices.soap.VirementServiceWS;
import com.excilys.excilysbanking.webservices.soap.impl.CompteServiceWSImplService;
import com.excilys.excilysbanking.webservices.soap.impl.VirementServiceWSImplService;

public class MainSoap {
	
	private static final String USERNAME = "jmartinez";
	private static final Integer COMPTE_ID = 6464;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StringBuilder out = new StringBuilder();
		
		// Testing CompteService
		
		CompteServiceWSImplService service = new CompteServiceWSImplService();
		CompteServiceWS port = service.getCompteServiceWSImplPort();
		List<CompteDTO> comptes = port.getComptesByUsername(USERNAME);
		
		out.append("\n").append("***** Compte Service *****");
		out.append("\n").append("* Liste de tous les comptes (" + comptes.size() + ") pour " + USERNAME + "\n");
		for (CompteDTO c : comptes)
			out.append("\n").append(displayCompte(c));
		out.append("\n").append("**************************\n");
		
		// Testing VirementService
		
		VirementServiceWSImplService virementService = new VirementServiceWSImplService();
		VirementServiceWS virementPort = virementService.getVirementServiceWSImplPort();
		List<OperationDTO> histVirements = virementPort.getHistoriqueVirementByCompteId(COMPTE_ID);
		Double solde = virementPort.getSoldeCompte(COMPTE_ID);
		
		out.append("\n").append("***** Virement Service *****");
		out.append("\n").append("* Solde sur le compte " + COMPTE_ID + ": " + solde + " $");
		out.append("\n").append("* Les derniers virements:");
		for (OperationDTO o : histVirements)
			out.append("\n").append(displayOperation(o));
		
		double montant = 10d;
		String libelle = "Exemple de virement";
		int compteCredit = 2138962500;
		
		out.append("\n").append("\n* On effectue un virement de " + montant + "$ vers " + compteCredit + " avec le libelle \"" + libelle + "\"\n");
		virementPort.performVirement(COMPTE_ID, compteCredit, libelle, montant);
		
		histVirements = virementPort.getHistoriqueVirementByCompteId(COMPTE_ID);
		solde = virementPort.getSoldeCompte(COMPTE_ID);
		
		out.append("\n").append("* Solde sur le compte " + COMPTE_ID + ": " + solde + " $");
		out.append("\n").append("* Les derniers virements:");
		for (OperationDTO o : histVirements)
			out.append("\n").append(displayOperation(o));
		out.append("\n").append("****************************");
		
		System.out.println(out.toString());
	}
	
	private static String displayOperation(OperationDTO o) {
		StringBuilder s = new StringBuilder();
		s.append("OperationDTO");
		s.append(" [id=").append(o.getId());
		s.append(", date=").append(o.getDate());
		s.append(", type=").append(o.getType());
		s.append(", compteDestination=").append(o.getCompteDestination());
		s.append(", libelle=").append(o.getLibelle());
		s.append(", montant=").append(o.getMontant());
		s.append("]");
		return s.toString();
	}
	
	private static String displayCompte(CompteDTO c) {
		StringBuilder builder = new StringBuilder();
		builder.append("CompteDTO [id=").append(c.getId()).append(", solde=").append(c.getSolde()).append(", compteType=").append(c.getType())
				.append(", username=").append(c.getUsername()).append("]");
		return builder.toString();
	}
}
