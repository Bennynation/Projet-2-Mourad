package classeur;

import java.util.ArrayList;
import java.util.List;

import entite.Client;
import entite.Compte;
import entite.Gestionnaire;
import entite.Manager;
import entite.Prepose;

public class ClasseurCompte {
	private List<Compte> listCompte = new ArrayList<>();
	
	
	public List<Compte> getListe()
	{
		return listCompte;
	}
	
	public void addCompte(Compte compte)
	{
		listCompte.add(compte);
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
	
	public List<Client> getClientList()
	{
		List<Client> tmp = new ArrayList();
		for(Compte c: listCompte)
		{
			if(c.getClass().equals(Client.class))
			{
				tmp.add((Client) c);
			}
		}
		return tmp;
	}
	public void setCompte(Compte co)
	{
		for (Compte c : listCompte) 
		{ 
		    if (c.getNomUtilisateur().equals(co.getNomUtilisateur()) && c.getPass().equals(co.getPass())) {
		    	co = c;
		    	break;
		    }
		}
	}

}
