package classeur;

import java.util.ArrayList;
import java.util.List;

import entite.Client;
import entite.Compte;

public class ClasseurCompte {
	private List<Compte> listCompte = new ArrayList<>();

	public List<Compte> getListe() {
		return listCompte;
	}

	public void addCompte(Compte compte) {
		listCompte.add(compte);
	}

	public Compte getCompte(String id, String mtp) {
		Compte co = null;
		for (Compte c : listCompte) {
			if (c.getNomUtilisateur().equals(id) && c.getPass().equals(mtp)) {
				co = c;
			}
		}
		return co;
	}

	public List<Client> getClientList() {
		List<Client> tmp = new ArrayList<>();
		for (Compte c : listCompte) {
			if (c.getClass().equals(Client.class)) {
				tmp.add((Client) c);
			}
		}
		return tmp;
	}

	public List<Client> getClientsParNumTel(String numTel) {
		List<Client> clients = new ArrayList<>();

		for (Compte co : listCompte) {
			if (co instanceof Client cl && co.getNumTel().contains(numTel)) {
				clients.add(cl);
			}
		}

		return clients;
	}

	public Compte getCompteParId(int id) {
		for (Compte c : listCompte) {
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
	}
}
