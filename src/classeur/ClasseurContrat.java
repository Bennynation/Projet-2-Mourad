package classeur;

import java.util.ArrayList;
import java.util.List;

import autre.Util;
import entite.Contrat;

public class ClasseurContrat {
	private List<Contrat> listContrat = new ArrayList<>();

	public List<Contrat> getListe() {
		return listContrat;
	}

	public void addContrat(int idC, int idR) {
		int i = 0;
		int randomInt = Util.genNumAleatoire(0, 10000);
		while (i == 0) {
			if (this.verifId(randomInt)) {
				listContrat.add(new Contrat(randomInt, idC, idR));
				i = 1;
			} else {
				randomInt = Util.genNumAleatoire(0, 10000);
			}

		}
	}

	public boolean verifId(int i) {
		for (Contrat r : listContrat) {
			if (r.getIdContrat() == i) {
				return false;
			}
		}
		return true;
	}

}
