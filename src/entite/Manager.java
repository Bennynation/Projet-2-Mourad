package entite;

public class Manager extends Compte {
	public Manager(String user, int idClient, String lname, String fname, String rue, int noCivique, String ville,
			String codePostal, String pass, String numTel) {
		super(user, idClient, lname, fname, rue, noCivique, ville, codePostal, pass, 3, numTel);
	}

}
