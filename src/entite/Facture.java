package entite;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Facture {
	private int idFacture;
	private BigDecimal montant;
	private boolean estPaye;

	public Facture(int idFacture, BigDecimal montant, boolean estPaye) {
		this.idFacture = idFacture;
		this.montant = montant.setScale(2, RoundingMode.DOWN);
		this.estPaye = estPaye;
	}

	public int getIdFacture() {
		return idFacture;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public boolean getEstPaye() {
		return estPaye;
	}

}
