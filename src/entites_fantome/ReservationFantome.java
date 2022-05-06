package entites_fantome;

import java.util.Date;

import entite.Client;
import entite.Vehicule;

public class ReservationFantome {
	private String nomRervation;
	private Client client;
	private Vehicule vehicule;
	private Date dReservD;
	private Date dReservA;

	public ReservationFantome(String nomRervation, Client client, Vehicule vehicule, Date dReservD, Date dReservA) {
		this.nomRervation = nomRervation;
		this.client = client;
		this.vehicule = vehicule;
		this.dReservD = dReservD;
		this.dReservA = dReservA;
	}

	public String getNomReservation() {
		return this.nomRervation;
	}

	public void setNomReservation(String nomRervation) {
		this.nomRervation = nomRervation;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Vehicule getVehicules() {
		return this.vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Date getdReservD() {
		return dReservD;
	}

	public void setdReservD(Date dReservD) {
		this.dReservD = dReservD;
	}

	public Date getdReservA() {
		return dReservA;
	}

	public void setdReservA(Date dReservA) {
		this.dReservA = dReservA;
	}
}
