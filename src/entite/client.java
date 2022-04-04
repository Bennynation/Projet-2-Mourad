package entite;

public class client {
	private int idClient;
	private String lname;
	private String fname;
	private String rue;
	private int noCivique;
	private String ville;
	private String codePostal;

	public client(int idClient, String lname, String fname, String rue, int noCivique, String ville, String codePostal) {
		this.idClient = idClient;
		this.lname = lname;
		this.fname = fname;
		this.rue = rue;
		this.noCivique = noCivique;
		this.ville = ville;
		this.codePostal = codePostal;
	}
}
