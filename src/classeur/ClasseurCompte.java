package classeur;

import java.util.ArrayList;
import java.util.List;

import entite.Compte;

public class ClasseurCompte {
	List<Compte> listCompte = new ArrayList<>();
	
	public void addCompte(Compte compte)
	{
		listCompte.add(compte);
	}
	public Compte getCompteSpecfic(int id, String pass)
	{
		Compte tmp = null;
		for(Compte q : listCompte)
		{
			if(q.getId()==id && q.getPass().equals(pass))
			{
				tmp=q;
				break;
			}
		}
		
		return tmp;
	}
	public Compte getCompteSpecefic(String lname,String fname)
	{
		Compte tmp = null;
		for(Compte q : listCompte)
		{
			if(q.getLname().equals(lname)&& q.getFname().equals(Fname))
			{
				tmp=q;
				break;
			}
		}
		
		return tmp;
	}
	public Compte getCompteSpecefic(String fullAddresse)
	{
		Compte tmp = null;
		for(Compte q : listCompte)
		{
			if(q.getFullAddresse().equals(tmp))
			{
				tmp=q;
				break;
			}
		}
		
		return tmp;
	}
	public List<Compte> getListCompte()
	{
		return listCompte;
	}
}
