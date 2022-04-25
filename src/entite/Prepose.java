package entite;

public class Prepose extends Compte{
	public Prepose(String userCo,int idClient, String lname, String fname, String rue, int noCivique, String ville, String codePostal, String pass, int droit) {
	    super(userCo,idClient,lname,fname,rue,noCivique,ville,codePostal,pass,2);
	  }
	public int getDroit()
	{
		return super.getDroit();
	}

}

