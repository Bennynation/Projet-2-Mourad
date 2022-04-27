package classeur;

import java.util.ArrayList;
import java.util.List;

import entite.Compte;
import entite.Vehicules;

public class InventaireVehicules {
	 private List<Vehicules> listeVehicule = new ArrayList<>();
	
	public void addVehicule(Vehicules vehi)
	{
		listeVehicule.add(vehi);
	}	
	
	public  List<Vehicules> afficherTousVehicules() {		
		return listeVehicule;	
	}
	
	public  boolean dispo(int idVehicule){	
		
		for (Vehicules v : listeVehicule) 
		{ 
			if (v.getId() == idVehicule) {
				if (v.isDispo())
					return true;
				else
					return false;
			}
		}	
		return false;
	}
	
	public  List<Vehicules> afficherTousVehiculesDispo() {
		List<Vehicules> listeEnvoie = new ArrayList<>();
		 
			for (Vehicules v : listeVehicule) 
			{ 
				if (v.isDispo())
					listeEnvoie.add(v);
			}		
		return listeEnvoie;	
	}
	
	public  List<Vehicules> afficherSimpleVehicules() {
		List<Vehicules> listeEnvoie = new ArrayList<>();
		 
			for (Vehicules v : listeVehicule) 
			{ 
				if (v.getType().equals("Simple"))
					listeEnvoie.add(v);
			}		
		return listeEnvoie;	
	}
	
	public  List<Vehicules> afficherSimpleVehiculesDispo() {
		List<Vehicules> listeEnvoie = new ArrayList<>();
		 
			for (Vehicules v : listeVehicule) 
			{ 
				if (v.isDispo() && v.getType().equals("Simple"))
					listeEnvoie.add(v);
			}		
		return listeEnvoie;	
	}
	
	public  List<Vehicules> afficherUtiliVehicules() {
		List<Vehicules> listeEnvoie = new ArrayList<>();
		 
			for (Vehicules v : listeVehicule) 
			{ 
				if (v.getType().equals("Utilitaire"))
					listeEnvoie.add(v);
			}		
		return listeEnvoie;	
	}
	
	public  List<Vehicules> afficherUtiliVehiculesDispo() {
		List<Vehicules> listeEnvoie = new ArrayList<>();
		 
			for (Vehicules v : listeVehicule) 
			{ 
				if (v.isDispo() && v.getType().equals("Utilitaire"))
					listeEnvoie.add(v);
			}		
		return listeEnvoie;	
	}
	
	public  List<Vehicules> afficherPrestigeVehicules() {
		List<Vehicules> listeEnvoie = new ArrayList<>();
		 
			for (Vehicules v : listeVehicule) 
			{ 
				if (v.getType().equals("Prestige"))
					listeEnvoie.add(v);
			}		
		return listeEnvoie;	
	}

	
	public List<Vehicules> afficherPrestigeVehiculesDispo() {
		List<Vehicules> listeEnvoie = new ArrayList<>();
		 
			for (Vehicules v : listeVehicule) 
			{ 
				if (v.isDispo() && v.getType().equals("Prestige"))
					listeEnvoie.add(v);
			}		
		return listeEnvoie;	
	}
	
	public void modifierEtat(int id,String etat,String desc) {
		for (Vehicules v : listeVehicule) 
		{ 
			if (v.getId() == id) {
				v.setEtat(etat);
				v.setDescEtat(desc);
				v.setDispoSelonEtat();
			}		
		}	
	}
}

