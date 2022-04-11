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

	public Compte(int idClient, String lname, String fname, String rue, int noCivique, String ville, String codePostal,String pass) {
		this.id = id;
		this.lname = lname;
		this.fname = fname;
		this.rue = rue;
		this.noCivique = noCivique;
		this.ville = ville;
		this.codePostal = codePostal;
		this.pass = pass;
		this.fullAddress=this.noCivique+""+this.rue;
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
}