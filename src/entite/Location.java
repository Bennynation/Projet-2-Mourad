package entite;

import java.util.Date;

import fenetres.MenuPrincipal;

public class Location {
	private int idLocation;
	private int idVehicule;
	private int idClient;
	private int idFacture;
	private int km;
	private Date dateDebut;
	private Date dateRetour;

	public Location(int idL, int idV, int idC, Date dateR) {
		this.idLocation = idL;
		this.idVehicule = idV;
		this.idClient = idC;
		this.idFacture = -1;
		this.dateDebut = new Date();
		this.dateRetour = dateR;
	}

	public int getIdLocation() {
		return idLocation;
	}

	public int getIdVehicule() {
		return idVehicule;
	}

	public int getIdClient() {
		return idClient;
	}

	public int getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public boolean estTermine() {
		return idFacture != -1;
	}

	public Vehicule getVehicule() {
		return MenuPrincipal.listVehicule.getVehicule(idVehicule);
	}

	public Client getClient() {
		return (Client) MenuPrincipal.listCompte.getCompteParId(idClient);
	}

	public Facture getFacture() {
		return MenuPrincipal.listFacture.getFactureParId(idFacture);
	}
}
