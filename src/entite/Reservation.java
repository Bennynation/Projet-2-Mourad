package entite;
import java.util.Date;

public class Reservation {
	private int idL;
	private int idV;
	private int idC;
	private Date dReservD;
	private Date dReservF;


	public Reservation(int iL, int iV, int iC, Date dateR, Date dateF) {
		idL = iL;
		idV = iV;
		idC = iC;
		dReservD = dateR;
		dReservF = dateF;
	}


	public int getIdL() {
		return idL;
	}


	public int getIdV() {
		return idV;
	}


	public int getIdC() {
		return idC;
	}



	public Date getdReservD() {
		return dReservD;
	}


	public void setdReservD(Date dReservD) {
		this.dReservD = dReservD;
	}


	public Date getdReservF() {
		return dReservF;
	}


	public void setdReservF(Date dReservF) {
		this.dReservF = dReservF;
	}


	public void setIdV(int id) {
		this.idV=id;
	}
}
