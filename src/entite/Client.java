package entite;


public class Client extends Compte{

  private String noPermit;
  private String CarteBank;
  private double retard;

  public Client(String noPermit, String carteBank, double retard,int idClient, String lname, String fname, String rue, int noCivique, String ville, String codePostal, String pass, int droit) {
    super(idClient,lname,fname,rue,noCivique,ville,codePostal,pass,0);
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

  public double getRetard() {
    return retard;
  }

  public void setRetard(double retard) {
    this.retard = retard;
  }
}
