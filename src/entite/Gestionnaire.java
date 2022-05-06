package entite;

public class Gestionnaire extends Compte {
	public Gestionnaire(String user, int idClient, String lname, String fname, String rue, int noCivique, String ville,
			String codePostal, String pass, String numTel) {
		super(user, idClient, lname, fname, rue, noCivique, ville, codePostal, pass, 1, numTel);
	}
}
