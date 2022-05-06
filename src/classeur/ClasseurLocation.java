package classeur;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import autre.Util;
import entite.Client;
import entite.Location;
import entite.Vehicule;
import exception.IdException;
import fenetres.MenuPrincipal;

public class ClasseurLocation {
	private List<Location> listlocation = new ArrayList<>();

	public void addLocation(Location loca) {
		listlocation.add(loca);
	}

	public boolean verifDateIdVehicule(int idV, Date dateD, Date dateF) {
		for (Location l : listlocation) {
			if (l.getIdVehicule() == idV) {
				if ((dateD.after(l.getDateDebut()) && dateD.before(l.getDateRetour())) || dateD.equals(l.getDateDebut())
						|| dateD.equals(l.getDateRetour())) {
					return false;
				}
				if ((dateD.after(l.getDateDebut()) && dateF.before(l.getDateRetour()))) {
					return false;
				}
				if ((dateF.after(l.getDateDebut()) && dateF.before(l.getDateRetour())) || dateF.equals(l.getDateDebut())
						|| dateF.equals(l.getDateRetour())) {
					return false;
				}
			}
		}
		return true;
	}

	public List<Vehicule> verifLocation(List<Vehicule> listV, Date dateF, Date dateD) {
		List<Vehicule> listClear = new ArrayList<>();

		for (Vehicule v : listV) {
			if (verifDateIdVehicule(v.getId(), dateD, dateF))
				listClear.add(v);
		}

		return listClear;
	}

	public List<Location> getLocationParClientOuVehicule(String motsRecherche) {
		List<Location> locations = new ArrayList<>();

		for (Location l : listlocation) {
			String champsRecherche = l.getClient().getNomComplet() + l.getIdVehicule()
					+ l.getVehicule().getNomVehicule();
			if (!l.estTermine() && champsRecherche.contains(motsRecherche)) {
				locations.add(l);
			}
		}

		return locations;
	}

	public boolean faireLocation(Vehicule v, Client c, Date dateFin) {
		try {
			listlocation.add(new Location(getUniqueId(), v.getId(), c.getId(), dateFin));
			v.setDispo(false);
			return true;
		} catch (IdException e) {
			return false;
		}
	}

	public boolean faireRetour(Location l, int kilometrage, BigDecimal charges) {
		if (MenuPrincipal.listFacture.faireFacture(l, kilometrage, charges)) {
			l.getVehicule().setDispo(true);
			l.setKm(kilometrage);
			return true;
		}
		return false;
	}

	private int getUniqueId() throws IdException {
		if (listlocation.size() - 1 == 10000) {
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
		for (Location l : listlocation) {
			if (l.getIdLocation() == id) {
				return false;
			}
		}
		return true;
	}

}
