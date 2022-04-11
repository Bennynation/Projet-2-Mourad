package classeur;

import java.util.ArrayList;
import java.util.List;

import entite.Client;
import entite.Compte;

public class ClasseurClient {
	List<Client> listClient = new ArrayList<>();
	
	public void addCompte(Client compte)
	{
		listClient.add(compte);
	}
	public Client getCompteSpecfic(int id, String pass)
	{
		Client tmp = null;
		for(Client q : listClient)
		{
			if(q.getId()==id && q.getPass().equals(pass))
			{
				tmp=q;
				break;
			}
		}
		
		return tmp;
	}
	
	public Client getCompteSpecefic(String lname,String fname)
	{
		Client tmp = null;
		for(Client q : listClient)
		{
			if(q.getLname().equals(lname)&& q.getFname().equals(fname))
			{
				tmp=q;
				break;
			}
		}
		
		return tmp;
	}
	
	public Client getCompteSpecefic(String fullAddresse)
	{
		Client tmp = null;
		for(Client q : listClient)
		{
			if(q.getFullAddresse().equals(fullAddresse))
			{
				tmp=q;
				break;
			}
		}
		
		return tmp;
	}
	
	public List<Client> getListCompte()
	{
		return listClient;
	}
}