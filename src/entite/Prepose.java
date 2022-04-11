package entite;

public class Prepose extends Compte{
	public Prepose(String noPermit, String carteBank, double retard,int idClient, String lname, String fname, String rue, int noCivique, String ville, String codePostal, String pass, int droit) {
	    super(idClient,lname,fname,rue,noCivique,ville,codePostal,pass,2);
	  }
	public int getDroit()
	{
		return super.getDroit();
	}
	public void setDroit(int droit)
	{
		super.setDroit(droit);
	}
}

