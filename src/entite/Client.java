package entite;

public class Client extends Compte {

	private String noPermit;
	private String carteBank;
	private int retard;

	public Client(String user, String noPermit, String carteBank, int retard, int idClient, String lname, String fname,
			String rue, int noCivique, String ville, String codePostal, String pass, String numTel) {
		super(user, idClient, lname, fname, rue, noCivique, ville, codePostal, pass, 0, numTel);
		this.noPermit = noPermit;
		this.carteBank = carteBank;
		this.retard = retard;
	}

	public String getNoPermit() {
		return noPermit;
	}

	public void setNoPermit(String noPermit) {
		this.noPermit = noPermit;
	}

	public String getCarteBank() {
		return carteBank;
	}

	public void setCarteBank(String carteBank) {
		this.carteBank = carteBank;
	}

	public int getRetard() {
		return retard;
	}

	public void setRetard(int retard) {
		this.retard = retard;
	}

}
