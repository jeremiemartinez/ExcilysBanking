
package com.excilys.excilysbanking.dao.util;

import java.util.Locale;
import java.util.Random;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import com.excilys.excilysbanking.entities.Compte;
import com.excilys.excilysbanking.entities.Operation;
import com.excilys.excilysbanking.entities.Operation.OperationType;

public class Populator {
	
	private final static int VIREMENTS_MAX_PER_MONTH = 10;
	private final static int CARTES_MAX_PER_MONTH = 10;
	private final static int NB_MOIS = 8;
	
	private final static Random rand = new Random();
	private final static DateTimeFormatter fmt = DateTimeFormat.forPattern("MMMM yyyy").withLocale(Locale.ENGLISH);
	
	public static void main(String[] args) {
		DataSetRenderer r = new DbUnitDataSetRenderer();
		r.openDataSet();
		
		DateTime now = DateTime.now();
		DateTime date = new DateTime(now.year().get(), now.monthOfYear().get(), 1, 0, 0);
		int id = 153;
		int compteId = 6464;
		
		r.newHugeSection("Operation for account number " + compteId);
		
		for (int m = 0; m < NB_MOIS; m++) {
			r.newBigSection("Operations in " + fmt.print(date));
			
			r.newSection("Virements");
			for (int v = rand.nextInt(VIREMENTS_MAX_PER_MONTH) + 1; v > 0; v--)
				r.populateDataSet(buildOperation(id++, compteId, OperationType.VIREMENT, date));
			
			r.newSection("Carte");
			for (int v = rand.nextInt(CARTES_MAX_PER_MONTH) + 1; v > 0; v--)
				r.populateDataSet(buildOperation(id++, compteId, OperationType.CARTE, date));
			
			date = date.minusMonths(1);
		}
		r.closeDataSet();
		System.out.println(r.render());
	}
	
	private static Operation buildOperation(int id, int compteId, OperationType type, DateTime baseMonth) {
		Operation.Builder ob = new Operation.Builder();
		ob.id(id);
		ob.compte(new Compte.Builder().id(compteId).build());
		ob.type(type);
		ob.montant(buildMontant());
		DateTime opDate = baseMonth.plusMinutes(rand.nextInt(60));
		opDate = opDate.plusHours(rand.nextInt(24));
		opDate = opDate.plusDays(rand.nextInt(28));
		opDate = opDate.plusSeconds(rand.nextInt(60));
		ob.libelle("Some operation #" + new Random().hashCode());
		ob.date(opDate);
		return ob.build();
	}
	
	private static Double buildMontant() {
		return Double.parseDouble((rand.nextInt(2000) - rand.nextInt(1000)) + "." + rand.nextInt(100));
	}
}
