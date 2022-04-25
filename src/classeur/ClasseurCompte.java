package classeur;

import java.util.ArrayList;
import java.util.List;

import entite.Client;
import entite.Compte;
import entite.Gestionnaire;
import entite.Manager;
import entite.Prepose;

public class ClasseurCompte {
	static List<Compte> listCompte = new ArrayList<>();
	
	
	public List<Compte> getListe()
	{
		return listCompte;
	}
	
	public void addCompte(Compte compte)
	{
		listCompte.add(compte);
	}
	
	public void addClient(Client c)
	{
		listCompte.add(c);
	}
	
	public Compte getCompte(String id,String mtp) {
		Compte co = null;
		for (Compte c : listCompte) 
		{ 
		    if (c.getNomUtilisateur().equals(id) && c.getPass().equals(mtp)) {
		    	co = c;
		    }
		}
		return co;
	}
	

}
