package entite;


public class Client extends Compte{

  private String noPermit;
  private String CarteBank;
  private int retard;

  public Client(String user, String noPermit, String carteBank, int retard,int idClient, String lname, String fname, String rue, int noCivique, String ville, String codePostal, String pass, int droit) {
    super(user,idClient,lname,fname,rue,noCivique,ville,codePostal,pass,0);
    this.noPermit = noPermit;
    CarteBank = carteBank;
    this.retard = retard;
  }

  public String getNoPermit() {
    return noPermit;
  }

  public void setNoPermit(String noPermit) {
    this.noPermit = noPermit;
  }

  public String getCarteBank() {
    return CarteBank;
  }

  public void setCarteBank(String carteBank) {
    CarteBank = carteBank;
  }

  public int getRetard() {
    return retard;
  }

  public void setRetard(int retard) {
    this.retard = retard;
  }
  
	public int getDroit()
	{
		return super.getDroit();
	}
}
