package entitesFantome;

import java.util.Date;

import entite.Client;
import entite.Vehicules;

public class ReservationFantome {
	String nomRervation;
	private Client client;
	private Vehicules vehicule;
	private Date dReservD;
	
	public ReservationFantome(String nomRervation,Client client,Vehicules vehicule,Date dReservD)
	{
		this.nomRervation = nomRervation;
		this.client=client;
		this.vehicule=vehicule;
		this.dReservD=dReservD;
	}
	
	public String getNomReservation()
	{
		return this.nomRervation;
	}
	public void setNomReservation(String nomRervation)
	{
		this.nomRervation = nomRervation;
	}
	public Client getClient()
	{
		return this.client;
	}
	public void setClient(Client client)
	{
		this.client = client;
	}
	public Vehicules getVehicules()
	{
		return this.vehicule;
	}
	public void setVehicule(Vehicules vehicule)
	{
		this.vehicule=vehicule;
	}
	public Date getdReservD() {
		return dReservD;
	}


	public void setdReservD(Date dReservD) {
		this.dReservD = dReservD;
	}
}
