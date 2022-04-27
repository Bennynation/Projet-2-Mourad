package classeur;

import java.util.ArrayList;
import java.util.List;

import entite.Client;
import entite.Compte;
import entite.Contrat;
import entite.Gestionnaire;
import entite.Manager;
import entite.Prepose;
import entite.Reservation;

public class ClasseurContrat {
	private List<Contrat> listContrat = new ArrayList<>();
	
	
	public List<Contrat> getListe()
	{
		return listContrat;
	}
	
	public void addContrat(int idC,int idR)
	{
		int i = 0, random_int = (int)Math.floor(Math.random()*(10000-100+1)+100);   
		while (i == 0) {
			if (this.verifId(random_int)) {
				listContrat.add(new Contrat(random_int,idC,idR));
				i = 1;
			}	
			else {
				random_int = (int)Math.floor(Math.random()*(10000-100+1)+100);  
			}
				
		}	
	}
	
	public boolean verifId(int i) {
		for (Contrat r : listContrat) 
			{ 
			    if (r.getIdContrat() == i) {
			    	return false;
			    }
			}
		return true;
	}
	

	

}
