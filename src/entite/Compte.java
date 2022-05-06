package entite;

public class Compte {
	private int id;
	private String lname;
	private String fname;
	private String pass;
	private String rue;
	private int noCivique;
	private String ville;
	private String codePostal;
	private String fullAddress;
	private String nomUtilisateur;
	private int droit;
	private String numTel;

	public Compte(String userCo, int idClient, String lname, String fname, String rue, int noCivique, String ville,
			String codePostal, String pass, int droit, String numTel) {
		this.nomUtilisateur = userCo;
		this.id = idClient;
		this.lname = lname;
		this.fname = fname;
		this.rue = rue;
		this.noCivique = noCivique;
		this.ville = ville;
		this.codePostal = codePostal;
		this.pass = pass;
		this.fullAddress = this.noCivique + "" + this.rue;
		this.droit = droit;
		this.numTel = numTel;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String u) {
		this.nomUtilisateur = u;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getNoCivique() {
		return noCivique;
	}

	public void setNoCivique(int noCivique) {
		this.noCivique = noCivique;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getFullAddresse() {
		return fullAddress;
	}

	public void setFullAddresse(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public int getDroit() {
		return this.droit;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public String getNomComplet() {
		return fname + " " + lname;
	}

	@Override
	public String toString() {
		return fname + " " + lname;
	}
}
