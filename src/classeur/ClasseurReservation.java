package classeur;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entite.Compte;
import entite.Reservation;
import entite.Vehicules;
import fenetres.MenuPrincipal;

public class ClasseurReservation {
	 private List<Reservation> listeReserv = new ArrayList<Reservation>();


	public int ajouterRéservation(int Compte,int idVehicule,Date dateD,Date dateF) {
		int i = 0, random_int = (int)Math.floor(Math.random()*(10000-100+1)+100);   
		while (i == 0) {
			if (this.verifId(random_int)) {
				listeReserv.add(new Reservation(random_int,idVehicule, Compte, dateD, dateF));
				i = 1;
			}	
			else {
				random_int = (int)Math.floor(Math.random()*(10000-100+1)+100);  
			}
				
		}	
		return random_int;
	}
	
	public boolean verifId(int i) {
		for (Reservation r : listeReserv) 
			{ 
			    if (r.getIdL()==i) {
			    	return false;
			    }
			}
		return true;
	}
	
	public boolean verifDateIdVehicule(int idV, Date dateD, Date dateF) {
		for (Reservation r : listeReserv) 
			{ 
				
				if (r.getIdV() == idV) {
				    if ((dateD.after(r.getdReservD()) && dateD.before(r.getdReservF())) || dateD.equals(r.getdReservD())  || dateD.equals(r.getdReservF()) ){
				    	return false;}
			    	else if((dateF.after(r.getdReservD()) &&  dateF.before(r.getdReservF())) || dateF.equals(r.getdReservD())  || dateF.equals(r.getdReservF())){
			    		return false;
			    		}
				}
			}
		return true;
		}
		
	public List<Vehicules> verifReserv(List<Vehicules> listV, Date dateF, Date dateD){
		List<Vehicules> listClear = new ArrayList<>();
		
		for(Vehicules v: listV) {
			if (verifDateIdVehicule(v.getId(),dateD,dateF))
				listClear.add(v);
		}
		
		return listClear;		
	}

	
}
