package classeur;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entite.Client;
import entite.Compte;
import entite.Location;
import entite.Reservation;
import entite.Vehicules;

public class ClasseurLocation {
	private List<Location> listlocation = new ArrayList<>();
	
	public void addCompte(Location loca)
	{
		listlocation.add(loca);
	}
	
	public boolean verifDateIdVehicule(int idV, Date dateD, Date dateF) {
		for (Location l : listlocation) 
			{ 
			if (l.getIdVehicule() == idV) {
			    if ((dateD.after(l.getDateDebut()) && dateD.before(l.getDateRetour())) || dateD.equals(l.getDateDebut())  || dateD.equals(l.getDateRetour()) ){	
			    	return false;
		    		}
			    else if ((dateF.after(l.getDateDebut()) &&  dateF.before(l.getDateRetour())) || dateF.equals(l.getDateDebut())  || dateF.equals(l.getDateRetour()) ) {
    			    return false;	
			    }
			}
			}
		return true;
	}
	
	public List<Vehicules> verifLocation(List<Vehicules> listV, Date dateF, Date dateD){
		List<Vehicules> listClear = new ArrayList<>();
		
		for(Vehicules v: listV) {
			if (verifDateIdVehicule(v.getId(),dateD,dateF))
				listClear.add(v);
		}
		
		return listClear;		
	}

}
