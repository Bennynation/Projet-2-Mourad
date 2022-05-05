package entite;
import java.util.Date;

public class Reservation {
	private int idR;
	private int idV;
	private int idC;
	private Date dReservD;
	private Date dReservF;


	public Reservation(int iR, int iV, int iC, Date dateR, Date dateF) {
		idR = iR;
		idV = iV;
		idC = iC;
		dReservD = dateR;
		dReservF = dateF;
	}


	public int getIdR() {
		return idR;
	}

	public void setIdV(int id) {
		this.idV=id;
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
}
