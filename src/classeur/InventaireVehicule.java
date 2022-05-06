package classeur;

import java.util.ArrayList;
import java.util.List;

import entite.Vehicule;

public class InventaireVehicule {
	private List<Vehicule> listeVehicule = new ArrayList<>();

	public void addVehicule(Vehicule vehi) {
		listeVehicule.add(vehi);
	}

	public List<Vehicule> getListVehicule() {
		return listeVehicule;
	}

	public boolean dispo(int idVehicule) {

		for (Vehicule v : listeVehicule) {
			if (v.getId() == idVehicule) {
				return v.isDispo();
			}
		}
		return false;
	}

	public List<Vehicule> afficherTousVehiculesDispo() {
		List<Vehicule> listeEnvoie = new ArrayList<>();

		for (Vehicule v : listeVehicule) {
			if (v.isDispo())
				listeEnvoie.add(v);
		}
		return listeEnvoie;
	}

	public List<Vehicule> afficherSimpleVehicules() {
		List<Vehicule> listeEnvoie = new ArrayList<>();

		for (Vehicule v : listeVehicule) {
			if (v.getType().equals("Simple"))
				listeEnvoie.add(v);
		}
		return listeEnvoie;
	}

	public List<Vehicule> afficherSimpleVehiculesDispo() {
		List<Vehicule> listeEnvoie = new ArrayList<>();

		for (Vehicule v : listeVehicule) {
			if (v.isDispo() && v.getType().equals("Simple"))
				listeEnvoie.add(v);
		}
		return listeEnvoie;
	}

	public List<Vehicule> afficherUtiliVehicules() {
		List<Vehicule> listeEnvoie = new ArrayList<>();

		for (Vehicule v : listeVehicule) {
			if (v.getType().equals("Utilitaire"))
				listeEnvoie.add(v);
		}
		return listeEnvoie;
	}

	public List<Vehicule> afficherUtiliVehiculesDispo() {
		List<Vehicule> listeEnvoie = new ArrayList<>();

		for (Vehicule v : listeVehicule) {
			if (v.isDispo() && v.getType().equals("Utilitaire"))
				listeEnvoie.add(v);
		}
		return listeEnvoie;
	}

	public List<Vehicule> afficherPrestigeVehicules() {
		List<Vehicule> listeEnvoie = new ArrayList<>();

		for (Vehicule v : listeVehicule) {
			if (v.getType().equals("Prestige"))
				listeEnvoie.add(v);
		}
		return listeEnvoie;
	}

	public List<Vehicule> afficherPrestigeVehiculesDispo() {
		List<Vehicule> listeEnvoie = new ArrayList<>();

		for (Vehicule v : listeVehicule) {
			if (v.isDispo() && v.getType().equals("Prestige"))
				listeEnvoie.add(v);
		}
		return listeEnvoie;
	}

	public void modifierEtat(int id, String etat, String desc) {
		for (Vehicule v : listeVehicule) {
			if (v.getId() == id) {
				v.setEtat(etat);
				v.setDescEtat(desc);
				v.setDispoSelonEtat();
			}
		}
	}

	public Vehicule getVehicule(String nomVehicule) {
		Vehicule tmp = null;
		for (Vehicule v : listeVehicule) {
			if (v.getNomVehicule().equals(nomVehicule)) {
				tmp = v;
			}
		}
		return tmp;
	}

	public Vehicule getVehicule(int idV) {
		Vehicule tmp = null;
		for (Vehicule v : listeVehicule) {
			if (v.getId() == idV) {
				tmp = v;
			}
		}
		return tmp;
	}

	public List<Vehicule> getVehiculesDispoParNomOuId(String texteRecherche) {
		List<Vehicule> vehicules = new ArrayList<>();

		for (Vehicule v : listeVehicule) {
			if (v.isDispo() && (v.getId() + v.getNomVehicule()).contains(texteRecherche)) {
				vehicules.add(v);
			}
		}

		return vehicules;
	}
}
