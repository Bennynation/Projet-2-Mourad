package classeur;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import autre.Util;
import entite.Reservation;
import entite.Vehicule;

public class ClasseurReservation {
	private List<Reservation> listeReserv = new ArrayList<>();

	public int ajouterReservation(int compte, int idVehicule, Date dateD, Date dateF) {
		int i = 0;
		int randomInt = Util.genNumAleatoire(0, 10000);
		while (i == 0) {
			if (this.verifId(randomInt)) {
				listeReserv.add(new Reservation(randomInt, idVehicule, compte, dateD, dateF));
				i = 1;
			} else {
				randomInt = Util.genNumAleatoire(0, 10000);
			}

		}
		return randomInt;
	}

	public boolean verifId(int i) {
		for (Reservation r : listeReserv) {
			if (r.getIdR() == i) {
				return false;
			}
		}
		return true;
	}

	public boolean verifDateIdVehicule(int idV, Date dateD, Date dateF) {
		for (Reservation r : listeReserv) {

			if (r.getIdV() == idV) {
				if ((dateD.after(r.getdReservD()) && dateD.before(r.getdReservF())) || dateD.equals(r.getdReservD())
						|| dateD.equals(r.getdReservF())) {
					return false;
				}
				if ((dateD.before(r.getdReservD()) && dateF.after(r.getdReservF()))) {
					return false;
				}
				if ((dateF.after(r.getdReservD()) && dateF.before(r.getdReservF())) || dateF.equals(r.getdReservD())
						|| dateF.equals(r.getdReservF())) {
					return false;
				}
			}
		}
		return true;
	}

	public List<Vehicule> verifReserv(List<Vehicule> listV, Date dateF, Date dateD) {
		List<Vehicule> listClear = new ArrayList<>();

		for (Vehicule v : listV) {
			if (verifDateIdVehicule(v.getId(), dateD, dateF))
				listClear.add(v);
		}

		return listClear;
	}

	public List<Reservation> getListReservation() {
		return listeReserv;
	}

	public boolean estReserveEntreDate(Vehicule v, Date dateDebut, Date dateFin) {
		for (Reservation r : listeReserv) {
			if (r.getIdV() == v.getId()) {
				return Util.datesSeChevauchent(r.getdReservD(), r.getdReservF(), dateDebut, dateFin);
			}
		}
		return false;
	}

}
