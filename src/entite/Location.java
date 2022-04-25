package entite;

import java.util.Date;

public class Location {
	private int idLocation;
	private int idVehicule;
	private double km;
	private Date dateDebut;
	private Date dateRetour;

	
	public Location(int idL,int idV, double km, Date dateD, Date dateR) {
		this.idLocation = idL;
		this.idVehicule = idV;
		this.km = km;
		this.dateDebut = dateD;
		this.dateRetour = dateR;
	}


	public int getIdLocation() {
		return idLocation;
	}


	public void setIdLocation(int idLocation) {
		this.idLocation = idLocation;
	}


	public int getIdVehicule() {
		return idVehicule;
	}


	public void setIdVehicule(int idVehicule) {
		this.idVehicule = idVehicule;
	}


	public double getKm() {
		return km;
	}


	public void setKm(double km) {
		this.km = km;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public Date getDateRetour() {
		return dateRetour;
	}


	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}
	

}
