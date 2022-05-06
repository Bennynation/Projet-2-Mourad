package classeur;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import autre.Util;
import entite.Facture;
import entite.Location;
import exception.IdException;

public class ClasseurFacture {
	private List<Facture> listFactures = new ArrayList<>();

	public Facture getFactureParId(int id) {
		for (Facture f : listFactures) {
			if (f.getIdFacture() == id) {
				return f;
			}
		}
		return null;
	}

	public boolean faireFacture(Location l, int kilometrage, BigDecimal charges) {
		int id;

		try {
			id = getUniqueId();
		} catch (IdException e) {
			return false;
		}

		BigDecimal montant = new BigDecimal(0);
		montant = montant.add(charges);
		long nbJoursLocation = ChronoUnit.DAYS.between(l.getDateDebut().toInstant(), l.getDateRetour().toInstant());
		kilometrage -= 100 * nbJoursLocation;
		if (kilometrage > 0) {
			montant = montant.add(new BigDecimal(kilometrage).multiply(new BigDecimal("0.25")));
		}

		long nbJoursRetard = ChronoUnit.DAYS.between(l.getDateRetour().toInstant(), Instant.now());
		if (nbJoursRetard > 0) {
			montant = montant.add(new BigDecimal(nbJoursRetard * 75));
		}

		long nbHeureRetard = ChronoUnit.HOURS.between(l.getDateRetour().toInstant(), Instant.now());
		if (nbHeureRetard > 0) {
			montant = montant.add(new BigDecimal(nbHeureRetard % 24 * 2));
		}

		l.setIdFacture(id);
		listFactures.add(new Facture(id, montant, false));
		return true;
	}

	private int getUniqueId() throws IdException {
		if (listFactures.size() - 1 == 10000) {
			throw new IdException();
		}

		while (true) {
			int id = Util.genNumAleatoire(0, 10000);
			if (idEstDisponible(id)) {
				return id;
			}
		}
	}

	private boolean idEstDisponible(int id) {
		for (Facture f : listFactures) {
			if (f.getIdFacture() == id) {
				return false;
			}
		}
		return true;
	}
}
