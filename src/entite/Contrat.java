package entite;


public class Contrat {

  private int idContrat;
  private int idCompte;
  private int idReserv;
  private double montant;

  public Contrat(int idCon, int idCom,int idR) {
    this.idContrat = idCon;
    this.idCompte = idCom;
    this.idReserv = idR;
    this.montant = 200;
  }

public int getIdContrat() {
	return idContrat;
}

public int getIdCompte() {
	return idCompte;
}

public int getIdReserv() {
	return idReserv;
}

public double getMontant() {
	return montant;
}

public void setMontant(double montant) {
	this.montant = montant;
}


}
