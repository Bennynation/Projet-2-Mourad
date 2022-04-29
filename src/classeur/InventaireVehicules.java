package classeur;

import java.util.ArrayList;
import java.util.List;

import entite.Compte;
import entite.Vehicules;

public class InventaireVehicules {
	static List<Vehicules> listeVehicule = new ArrayList<>();
	
	public void addVehicule(Vehicules vehi)
	{
		listeVehicule.add(vehi);
	}	
	
	public static List<Vehicules> afficherTousVehicules() {		
		return listeVehicule;	
	}
	
	public static boolean dispo(int idVehicule){	
		
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
	
	public static List<Vehicules> afficherTousVehiculesDispo() {
		List<Vehicules> listeEnvoie = new ArrayList<>();
		 
			for (Vehicules v : listeVehicule) 
			{ 
				if (v.isDispo())
					listeEnvoie.add(v);
			}		
		return listeEnvoie;	
	}
	
	public static List<Vehicules> afficherSimpleVehicules() {
		List<Vehicules> listeEnvoie = new ArrayList<>();
		 
			for (Vehicules v : listeVehicule) 
			{ 
				if (v.getType().equals("Simple"))
					listeEnvoie.add(v);
			}		
		return listeEnvoie;	
	}
	
	public static List<Vehicules> afficherSimpleVehiculesDispo() {
		List<Vehicules> listeEnvoie = new ArrayList<>();
		 
			for (Vehicules v : listeVehicule) 
			{ 
				if (v.isDispo() && v.getType().equals("Simple"))
					listeEnvoie.add(v);
			}		
		return listeEnvoie;	
	}
	
	public static List<Vehicules> afficherUtiliVehicules() {
		List<Vehicules> listeEnvoie = new ArrayList<>();
		 
			for (Vehicules v : listeVehicule) 
			{ 
				if (v.getType().equals("Utilitaire"))
					listeEnvoie.add(v);
			}		
		return listeEnvoie;	
	}
	
	public static List<Vehicules> afficherUtiliVehiculesDispo() {
		List<Vehicules> listeEnvoie = new ArrayList<>();
		 
			for (Vehicules v : listeVehicule) 
			{ 
				if (v.isDispo() && v.getType().equals("Utilitaire"))
					listeEnvoie.add(v);
			}		
		return listeEnvoie;	
	}
	
	public static List<Vehicules> afficherPrestigeVehicules() {
		List<Vehicules> listeEnvoie = new ArrayList<>();
		 
			for (Vehicules v : listeVehicule) 
			{ 
				if (v.getType().equals("Prestige"))
					listeEnvoie.add(v);
			}		
		return listeEnvoie;	
	}

	
	public static List<Vehicules> afficherPrestigeVehiculesDispo() {
		List<Vehicules> listeEnvoie = new ArrayList<>();
		 
			for (Vehicules v : listeVehicule) 
			{ 
				if (v.isDispo() && v.getType().equals("Prestige"))
					listeEnvoie.add(v);
			}		
		return listeEnvoie;	
	}
	
	public static void modifierEtat(int id,String etat,String desc) {
		for (Vehicules v : listeVehicule) 
		{ 
			if (v.getId() == id) {
				v.setEtat(etat);
				v.setDescEtat(desc);
				v.setDispoSelonEtat();
			}		
		}	
	}
	public static Vehicules getVehicule(String NomVehicule)
	{
		Vehicules tmp = null;
		for(Vehicules v: listeVehicule)
		{
			if(v.getNomVehicule().equals(NomVehicule))
			{
				tmp=v;
			}
		}
		return tmp;
	}
	public static Vehicules getVehicule(int idVehicule)
	{
		Vehicules tmp = null;
		for(Vehicules v: listeVehicule)
		{
			if(v.getId()==idVehicule)
			{
				tmp=v;
			}
		}
		return tmp;
	}
}

